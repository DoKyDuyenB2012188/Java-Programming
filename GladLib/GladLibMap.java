
/**
 * Write a description of GladLibMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class GladLibMap {
    private HashMap<String,ArrayList<String>>myMap;
    private Random myRandom;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    public GladLibMap(){
        myMap = new HashMap<String,ArrayList<String>>();
        myRandom = new Random();
    }
    private void initializeFromSource(String source){
        for(String s: myLabel)
    }
    private String randomFrom(ArrayList<String> source){
		int index = myRandom.nextInt(source.size());// bat dau random theo vi tri
		return source.get(index);
    }
    private String getSubstitute(String label){
        if(label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return randomFrom(myMap.get(label));
    }
    

}
