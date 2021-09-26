
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarBreaker {
    public int[] countLetters(String encrypted){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        for(int i=0;i<encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            int index = alphabet.indexOf(currChar);
            if(index!=-1){
                count[index]+=1;
            }
        }
        return count;
    }
    public int maxIndex(int[] freqs){
        int max=0;
        for(int i=0;i<freqs.length;i++){
            if(freqs[i]>freqs[max]){
                max =i;
            }
        }
        return max;
    }
    public String decrypt(String encrypted, int key){
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted,26-key);
        return message;
    }
    public void testDecrypt(){
       FileResource fr = new FileResource();
        String message = fr.asString();
        //String message ="Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        decryptTwokeys(message);
    }
    public String halfOfString(String message, int start){
        String newString="";
        for(int i=start;i<message.length();i+=2){
            newString+=message.charAt(i);
        }
        return newString;
    }
    public int getKey(String s){
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int key = maxDex - 4;
        if(maxDex<4){
            key = 26 - (4-maxDex);
        }
        return key;
    }
    public void decryptTwokeys(String encrypted){
        //System.out.println(encrypted);
        String string1 = halfOfString(encrypted,0);
        //System.out.println(string1);
        String string2 = halfOfString(encrypted,1);
        //System.out.println(string2);
        int key1 = getKey(string1);
        int key2 = getKey(string2);
        System.out.println("Key1: "+key1+"\t"+"Key2: "+key2);
        String decrypt1 = decrypt(string1,key1);
        String decrypt2 = decrypt(string2,key2);
        String messager="";
        int index1=0;
        int index2=0;
        for(int i =0;i<(decrypt1.length()+decrypt2.length());i++){
            if(i%2==0){
                messager+=decrypt1.charAt(index1);
                index1++;
            }
            if(i%2!=0){
                messager+=decrypt2.charAt(index2);
                index2++;
            }
        }
        System.out.println(messager);
    }

}
