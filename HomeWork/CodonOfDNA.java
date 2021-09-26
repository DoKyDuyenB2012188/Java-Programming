
/**
 * Write a description of CodonOfDNA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CodonOfDNA {
    private HashMap<String,Integer> listCodon;
    public CodonOfDNA(){
        listCodon = new HashMap<String, Integer>();
    }
    public void buildCodonMap(int start, String dna){
        listCodon.clear();
        //System.out.println("end: "+end);
        int end = (dna.length()-(start))/3;
        if(dna.charAt(dna.length()-1)=='\n'){
            end = (dna.length()-(start+1))/3;
        }
        for(int i=0;i<end;i++){
            String codon = dna.substring(start,start+3);
            //System.out.println(codon);
            if(!codon.contains("-1")){
                if(listCodon.containsKey(codon)){
                int value = listCodon.get(codon);
                listCodon.put(codon,value+1);
            }
            else{
                listCodon.put(codon,1);
            }
            }
            start+=3;
        }
    }
    public String getMostCommonCodon(){
        int max=0;
        String lot="";
        for(String s: listCodon.keySet()){
            if(listCodon.get(s)>max){
                max = listCodon.get(s);
                lot = s;
            }
        }
        return lot;
    }
    public void printCodonCount(int start, int end){
        String max = getMostCommonCodon();
        for(String s : listCodon.keySet()){
            if((listCodon.get(s)>=start)&&(listCodon.get(s)<=end)){
                System.out.println(s+"\t"+listCodon.get(s));
            }
        }
        System.out.println("Max: "+max+"\t"+listCodon.get(max));
    }
    public void tester(){
        FileResource DNA = new FileResource();
        String dna= DNA.asString();
        //String dna = "CGTTCAAGTTCAA";
        //System.out.println(dna.length());
        //System.out.println("*"+(int)(dna.charAt(13))+"*");
        /*for(String s: listCodon.keySet()){
            System.out.println(s+"\t"+listCodon.get(s));
        }*/
        //buildCodonMap(0,dna);
        //printCodonCount(0, 1);
        buildCodonMap(1,dna);
        //printCodonCount(0,5);
        //buildCodonMap(2,dna);
        //printCodonCount(0,1);
    }

}
