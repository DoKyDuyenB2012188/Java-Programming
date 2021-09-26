
/**
 * Write a description of CharacterslnPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CharacterslnPlay {
    private ArrayList<String>Name;
    private ArrayList<Integer>count;
    public CharacterslnPlay(){
        Name = new ArrayList<String>();//size =0
        count = new ArrayList<Integer>();//size =0
    }
    public void update(String person){
            //String person = Person.toLowerCase();
            //System.out.println(person.toLowerCase());
            int index = Name.indexOf(person);
            if(index == -1){
                Name.add(person);
                count.add(1);
            }
        
            else{
                int value = count.get(index);
                count.set(index,value+1);
            }
    }
    public void findAllCharacters(){
        FileResource resource = new FileResource();
        String string ="";
        for(String s: resource.lines()){
            int index = s.indexOf('.');
            if(index!=-1){
            //System.out.println(s.substring(0,index));
            update(s.substring(0,index));
            }
        }
    }
    public void tester(){
        findAllCharacters();
        int max =0;
        for(int i=0;i<count.size();i++){
           if(count.get(i)>count.get(max)){
               max =i;
            }
        }
        characterWithNumParts(10,15);
        System.out.println("Max: "+Name.get(max)+"\t"+count.get(max));

    }
    public void characterWithNumParts(int num1 ,int num2){
        for(int i=0;i<count.size();i++){
            if((count.get(i)>=num1)&&(count.get(i)<=num2)){
                System.out.println(Name.get(i)+"\t"+count.get(i));
            }
        }
    }

}
