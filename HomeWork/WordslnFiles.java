
/**
 * Write a description of WordslnFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.File;
public class WordslnFiles {
    private HashMap<String,ArrayList<String>>map;// word->filename
    public WordslnFiles(){
        map = new HashMap<String,ArrayList<String>>();
    }
    private void addWordsFromFile(File f){
        FileResource file = new FileResource(f);
         //String s = file.asString();
         //System.out.println(s);
        for(String word: file.words()){
            //System.out.println(word);
            //word.toLowerCase();
            if(!map.containsKey(word)){
                map.put(word,new ArrayList<String>());
                (map.get(word)).add(f.getName());
            }
            else{
                if(!map.get(word).contains(f.getName())){
                (map.get(word)).add(f.getName());
                }
            }
        }
        
    }
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int max = 0;
        for(String key: map.keySet()){
            if(map.get(key).size()>max){
                max = map.get(key).size();
            }
        }
        return max;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        System.out.print("wordsInNumFiles "+number+": ");
        ArrayList<String> temp = new ArrayList<String>();
        for(String key: map.keySet()){
            if(map.get(key).size() == number){
                temp.add(key);
            }
        }
        return temp;
    }
    public void printFilesIn(String word){
        System.out.print(word+": ");
        for(String s: map.keySet()){
            if(s.equals(word)){
                for(int i=0;i<map.get(s).size();i++){
                    System.out.print(map.get(s).get(i)+" ");
                }
            }
        }
    }
    public void tester(){
        buildWordFileMap();
        /*for(String s: map.keySet()){
            System.out.print(s+"\t");
            for(int i=0;i<map.get(s).size();i++){
                System.out.print(map.get(s).get(i)+" ");
            }
            System.out.println();
        }*/
        System.out.println("Max: "+maxNumber());
        ArrayList<String> w = new ArrayList<String>();
        w = wordsInNumFiles(4);
        System.out.println("Size: "+w.size());
        /*for(int i=0;i<w.size();i++){
            System.out.println(w.get(i)+" ");
        }*/
        printFilesIn("sea");
    }

}
