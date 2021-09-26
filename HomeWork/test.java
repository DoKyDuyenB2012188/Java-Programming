
/**
 * Write a description of test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.*;
public class test {
    public void testSplit(){
        /*DirectoryResource dr = new DirectoryResource ();
        for (File f: dr.selectedFiles ()) {
        FileResource ir = new FileResource (f);
         String s = ir.asString();
         System.out.println(s);
       }*/
       FileResource f = new FileResource();
       String s = f.asString();
       System.out.println(s.length());
    }

}
