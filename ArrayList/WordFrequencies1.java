
/**
 * Write a description of WordFrequencies1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordFrequencies1 {
    StorageResource myWords;
    public WordFrequencies1(){
        myWords = new StorageResource();
    }
    public int getCount(){
        return myWords.size();
    }
    public void readWords(){
        myWords.clear();
        FileResource resource = new FileResource();
        for(String s: resource.words()){
            myWords.add(s.toLowerCase());
        }
    }
    public boolean contain(String[] list, String word, int number){
        for(int i=0;i<number;i++){
            if(list[i].equals(word)){
                return true;
            }
        }
        return false;
    }
    public int numberOfUniquen(){
        int numStored=0;
        String[] words = new String[myWords.size()];
        for(String s: myWords.data()){
            if(!contain(words,s,numStored)){
                words[numStored]=s;
                numStored++;
            }
        }
        return numStored;// tra ve so lan lap tuc la so tu khac nhau
    }
    public void testcase(){
        readWords();
        int WordsUniquen = numberOfUniquen(); 
        System.out.println("Number of words read: "+myWords.size());
        System.out.println("array count: "+WordsUniquen);
    }

}
