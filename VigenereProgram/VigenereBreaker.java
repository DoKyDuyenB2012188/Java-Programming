import java.util.*;
import edu.duke.*;
import java.io.*;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String newString="";
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            newString+=message.charAt(i);
        }
        return newString;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for(int i=0;i<klength;i++){
            String encrypt = sliceString(encrypted,i,klength);
            key[i]= cc.getKey(encrypt);
        }
        
        return key;
    }
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> box = new HashSet<String>();
        for(String s: fr.words()){
            s=s.toLowerCase();
            box.add(s);
        }
        return box;
    }
    public int countWords(String message, HashSet<String> box){
        int count=0;
        String[] words = message.split("\\W+");
        for(int i=0;i<words.length;i++){
            words[i] = words[i].toLowerCase();
            //System.out.println(words[i]);
            if(box.contains(words[i])){
                count++;
            }
        }
        return count;
    }
    public int breakForLanguage(String encrypted, HashSet<String> dictionary){
        int[] keyList = new int[100];
        int max=0;
        int trueKey=0;
        for(int i=1;i<100;i++){
            int[] key = tryKeyLength(encrypted,i,mostCommonCharIn(dictionary));
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int mount = countWords(decrypted,dictionary);
            keyList[i] = mount;
            if(keyList[i]>max){
                max=keyList[i];
                trueKey = i;
            }
        }
        return trueKey;
    }
    public char mostCommonCharIn(HashSet<String> dictionary){
        int max=0;
        char mostchar='\0';
        String alphabet ="abcdefghijklmnopqrstuvwxyz";
        HashMap<Character,Integer> list = new HashMap<Character,Integer>();
        for(String s: dictionary){
            for(char k: s.toCharArray()){
                int index = alphabet.indexOf(k);
                if(Character.isLetter(k) && index!=-1){
                    if(!list.containsKey(k)){
                        list.put(k,1);
                    }
                    else{
                        list.put(k,list.get(k)+1);
                    }
                }
            }
        }
        for(char c: list.keySet()){
            //System.out.println(c +"\t"+list.get(c));
            if(list.get(c)>max){
                max = list.get(c);
                mostchar = c;
            }
        }
        return mostchar;
    }
    public void breakForAllLangs(String encrypted, HashMap<String,HashSet<String>>languages){
        HashMap<String,Integer>list= new HashMap<String,Integer>();
        HashMap<String,Integer>TrueKeyL= new HashMap<String,Integer>();
        HashMap<String,Character>commoncL= new HashMap<String,Character>();
        for(String s: languages.keySet()){
            int trueKey=breakForLanguage(encrypted,languages.get(s));
            char mostchar = mostCommonCharIn(languages.get(s));
            int[] key = tryKeyLength(encrypted,trueKey,mostchar);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int count = countWords(decrypted,languages.get(s));
            list.put(s,count);
            TrueKeyL.put(s,trueKey);
            commoncL.put(s,mostchar);
        //System.out.println("countWords: "+count);
        }
        int max=0;
        String keyL="";
        for(String s: list.keySet()){
            if(list.get(s)>max){
                max=list.get(s);
                keyL=s;
            }
        }
        System.out.println(keyL);
        int[] key = tryKeyLength(encrypted,TrueKeyL.get(keyL),commoncL.get(keyL));
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted = vc.decrypt(encrypted);
        System.out.println(decrypted.substring(0,100));
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource file = new FileResource();
        String encrypted = file.asString();
        DirectoryResource dic = new DirectoryResource();
        //FileResource dic = new FileResource();
        HashMap<String,HashSet<String>> languages = new HashMap<String,HashSet<String>>();
        for (File f : dic.selectedFiles()) {
            FileResource fr = new FileResource(f);
            languages.put(f.getName(),readDictionary(fr));
        }
        breakForAllLangs(encrypted,languages);
        //HashSet<String> dictionary = readDictionary(dic);
        //char most = mostCommonCharIn(dictionary);
        //System.out.println(most);
        //int trueKey = breakForLanguage(encrypted,dictionary);
        //int[] key = tryKeyLength(encrypted,trueKey,'e');
        //System.out.println("KeyL:"+key.length);
        /*for(int i=0;i<key.length;i++){
            System.out.println(key[i]);
        }*/
        //VigenereCipher vc = new VigenereCipher(key);
        //String decrypted = vc.decrypt(encrypted);
        //int count = countWords(decrypted,dictionary);
        //System.out.println("countWords: "+count);
        //System.out.println(decrypted.substring(0,52));
    }
    
}
