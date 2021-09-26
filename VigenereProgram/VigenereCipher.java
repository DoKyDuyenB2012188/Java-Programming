import edu.duke.*;
import java.util.*;

public class VigenereCipher {
    CaesarCipher[] ciphers;
    
    public VigenereCipher(int[] key) {
        ciphers = new CaesarCipher[key.length];//tao ra mang doi tuong
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CaesarCipher(key[i]);//tao tung doi tuong trong mang
        }// moi mot doi tuong ung voi mot khoa
    }
    
    public String encrypt(String input) {//ma hoa
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {// tra ve mang ki tu
            int cipherIndex = i % ciphers.length;// vong lap 0-ciphers.length
            CaesarCipher thisCipher = ciphers[cipherIndex];// gan
            answer.append(thisCipher.encryptLetter(c));// ma hoa tung ki tu
            i++;
        }
        return answer.toString();
    }
    
    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            i++;
        }
        return answer.toString();
    }
    
    public String toString() {
        return Arrays.toString(ciphers);
    }
    
}
