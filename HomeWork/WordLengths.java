
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class WordLengths {
    private ArrayList<String> myWords;
    private ArrayList<Integer>lengthWords;
    public WordLengths(){
        myWords = new ArrayList<String>();
        lengthWords = new ArrayList<Integer>();
    }
    public void findUnique(FileResource resource){
        for(String s: resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                lengthWords.add(1);
            }
            else{
                int value = lengthWords.get(index);
                lengthWords.set(index,value+1);
            }
        }
    }
    public boolean isLetter(char ch){
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        int index = alphabet.indexOf(ch);
        if(index !=-1){
            return true;
        }
        return false;
    }
    public void countWordLengths(FileResource resource){
        for(int i =0; i<myWords.size();i++){
            int count =0;
            String word = myWords.get(i);
            for(int k=0; k<word.length();k++){
                char ch = word.charAt(k);
                if(isLetter(ch)){
                    count++;
                }
            }
            lengthWords.add(count);
        }
    }
    public void testCountWordLengths(){
     FileResource resource = new FileResource();
     findUnique(resource);
     //countWordLengths(resource);
     int max = indexOfMax();
     /*for(int i=0;i<myWords.size();i++){
     System.out.println(myWords.get(i)+"\t"+lengthWords.get(i));
    }*/
     System.out.println("Max word of length: "+myWords.get(max)+" "+lengthWords.get(max));
    }
    public int indexOfMax(){
        int max =0;
      for(int i=0;i<lengthWords.size();i++){
          if(lengthWords.get(i)>lengthWords.get(max)){
              max = i;
            }
        }
        return max;
    }

}
