
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique(){
        FileResource resource = new FileResource();
        for(String s : resource.words()){
            s = s.toLowerCase();
            int in = myWords.indexOf(s);
            if(in == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
        
            else{
                int value = myFreqs.get(in);
                myFreqs.set(in,value+1);
            }
        }
    }
    public int MaxOf(){
        int max =0;
        for(int i=0;i<myFreqs.size();i++){
            if(myFreqs.get(i)>myFreqs.get(max)){
                max =i;
            }
        }
        return max;
    }
    void testcase(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        int max = MaxOf();
           System.out.println(myFreqs.get(max)+"\t"+myWords.get(max));
       

    }
}
