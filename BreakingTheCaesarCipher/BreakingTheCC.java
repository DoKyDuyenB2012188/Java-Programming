
/**
 * Write a description of BreakingTheCC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
import edu.duke.*;
public class BreakingTheCC {
    public int[] countLetters(String encrypted){
        String alphabet ="abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        for(int i=0;i<encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            int index = alphabet.indexOf(Character.toLowerCase(currChar));
            if(index!=-1){
            count[index]+=1;
            }
        }
        for(int i=0; i<alphabet.length();i++){
            System.out.println(alphabet.charAt(i)+"\t"+count[i]);
        }
        return count;
    }
    public int maxIndex(int[] freqs){
        int max =0;
        for(int i=0;i<freqs.length;i++){
            if(freqs[i]>freqs[max]){
                max = i;
            }
        }
        return max;
    }
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);//test1 
        int maxDex = maxIndex(freqs);
        System.out.println(maxDex);//22
        int dkey = maxDex-4;//22-4 = 18
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        System.out.println(dkey);
        return cc.encrypt(encrypted,26-dkey);
    }
    public void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = decrypt(message);
        System.out.println(encrypted);
        /*String alphabet ="abcdefghijklmnopqrstuvwxyz";
        int[] freqs = countLetters(message);
        for(int i=0;i<freqs.length;i++){
            System.out.println(alphabet.charAt(i)+"\t"+freqs[i]);
        }*/

    }
}