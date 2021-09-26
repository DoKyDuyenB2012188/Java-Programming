
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        char[] vowel ={'a','e','o','u','i'};// array char
        for(int i=0; i<vowel.length;i++){
            if(vowel[i]==ch){
                return true;
            }
        }
        return false;
    }
    public String ReplaceVowels(String phrase, char ch){
        StringBuilder Phrase = new StringBuilder(phrase);
        for(int i=0;i<Phrase.length();i++){
            if(isVowel(Phrase.charAt(i))){
                Phrase.setCharAt(i,ch);
            }
        }
        return Phrase.toString();
    }
    public String emphasize(String phrase, char ch){
         StringBuilder Phrase = new StringBuilder(phrase);
         for(int i=0;i<Phrase.length();i++){
             if(Phrase.charAt(i)==ch){
                 if((i+1)%2!=0){
                     Phrase.setCharAt(i,'*');
                    }
                 else{
                     Phrase.setCharAt(i,'+');
                    }
                }
            }
            return Phrase.toString();
        }
    public void testcase(){
        System.out.println(ReplaceVowels("Hello World",'*'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        
    }
}
    
