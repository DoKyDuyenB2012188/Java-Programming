
/**
 * Write a description of CaesarBreaker2Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarBreaker2Key {
    public String halfOfString(String message, int start){
        String temp ="";
        for(int i=0; i<message.length();i++){
            if((start==0)&&(i%2==0)){
                temp+=message.charAt(i);
            }
            if((start==1)&&(i%2)!=0){
                temp+=message.charAt(i);
            }
        }
        return temp;
    }
    public String encrypted(String message, int key1, int key2){
        CaesarCipher cc = new CaesarCipher(); 
        String string1 = halfOfString(message,0);
        String string2 = halfOfString(message,1);
        String encrypt1 = cc.encrypt(string1,key1);
        System.out.println(encrypt1);
        String encrypt2 = cc.encrypt(string2,key2);
        System.out.println(encrypt2);
        int index1=0, index2=0;
        String string="";
        for(int i=0; i<message.length();i++){
            if(i%2==0){
                string+=encrypt1.charAt(index1);
                index1++;
            }
            else{
                string+=encrypt2.charAt(index2);
                index2++;
            }
        }
        return string;
    }
    public void test(){
        //CaesarBreaker cb = new CaesarBreaker();
        //FileResource c = new FileResource();
        //String s = c.asString();
        String s ="Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String message = encrypted(s,21,8);
        System.out.println(message);
        //cb.decryptTwokeys(message);
        
    }
}
