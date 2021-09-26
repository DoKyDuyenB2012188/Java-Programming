
/**
 * Write a description of CommonWordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CommonWordLengths {
    private ArrayList<Integer> counts;
    private ArrayList<Integer> wordLs;
    public CommonWordLengths(){
        counts = new ArrayList<Integer>();
        wordLs = new ArrayList<Integer>();
    }
    public void test(){
        FileResource resource = new FileResource();
        WordLengths(resource);
        int max = maxOf();
        for(int i=0;i<wordLs.size();i++){
            System.out.println("length of word:"+ counts.get(i) +"    "+"number of words: "+wordLs.get(i));
        }
        System.out.println("common length of words:"+ counts.get(max) +"    "+"total words owned: "+wordLs.get(max));
    }
    public void WordLengths(FileResource resource){
        for(String s: resource.words()){
            int count =0;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(Character.isLetter(ch)){
                    count++;
                }
            }
            if(!check(count)){
                counts.add(count);
                wordLs.add(1);
            }
        }
    }
    public boolean check(int count){
        for(int i =0;i<counts.size();i++){
            if(counts.get(i)==count){
                wordLs.set(i,(wordLs.get(i)+1));
                return true;
            }
        }
        return false;
    }
    public int maxOf(){
        int max=0;
        for(int i=0;i<wordLs.size();i++){
            if(wordLs.get(i)>wordLs.get(max)){
                max =i;
            }
        }
        return max;
    }

}
