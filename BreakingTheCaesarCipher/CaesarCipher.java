
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet ="abcdefghijklmnopqrstuvwxyz";//abcdefgh
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            char temp = currChar;
            int idx = alphabet.indexOf(Character.toLowerCase(currChar));
            if(idx!=-1){
                char newChar = shiftedAlphabet.charAt(idx);
                if(temp == Character.toLowerCase(temp)){
                    encrypted.setCharAt(i,newChar);
                }
                else{
                 encrypted.setCharAt(i,Character.toUpperCase(newChar));
                }
            }
       
        }
        return encrypted.toString();
    }
    public void test(){
        //FileResource M = new FileResource();
        //String m = M.asString();
        String s ="Can you imagine life WITHOUT the internet AND computers in your pocket?";
        //String m = encrypt(s,15);
        //System.out.println(m);
        System.out.println(encrypt(s,15));
        
        }
}
