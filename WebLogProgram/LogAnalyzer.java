
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource file = new FileResource(filename);
         for(String s: file.lines()){
             LogEntry le = WebLogParser.parseEntry(s);
             records.add(le);
         }
         
     }
     public int countUniquenIPs(){
         //ArrayList<String> uniqueIPs = new ArrayList<String>();
         HashMap<String,Integer> uniqueIPs = countVisitsPerIP();
         /*for(LogEntry le: records){
             String iAddr = le.getIpAddress();
             if(!uniqueIPs.contains(iAddr)){
                 uniqueIPs.add(iAddr);
             }
         }*/
         return uniqueIPs.size();
     }
     public void printAllHigherThanNum(int num){
         ArrayList<Integer> Ustatus = new ArrayList<Integer>();
         for(LogEntry le: records){
             if(le.getStatusCode()>num){
                 //System.out.println(le.getIpAddress());
                 if(!Ustatus.contains(le.getStatusCode())){
                     Ustatus.add(le.getStatusCode());
                     System.out.println(le.getStatusCode());
                 }
             }
         }
     }
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> ipOnDay = new ArrayList<String>();
         for(LogEntry le: records){
             String day = (le.getAccessTime()).toString();
             day = day.substring(4,10);
             //System.out.println(day);
             if(day.equals(someday)){
                 if(!ipOnDay.contains(le.getIpAddress())){
                   ipOnDay.add(le.getIpAddress());
                }
             }
         }
         return ipOnDay;
     }
     public int countUniqueIPsInRange(int low, int high){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for(LogEntry le: records){
             String iAddr = le.getIpAddress();
             if(!uniqueIPs.contains(iAddr)){
                 uniqueIPs.add(iAddr);
             }
         }
         int count =0;
         for(LogEntry le: records){
             if(uniqueIPs.contains(le.getIpAddress())&&(le.getStatusCode()>=low)&&(le.getStatusCode()<=high)){
                 uniqueIPs.remove(uniqueIPs.indexOf(le.getIpAddress()));
                 count++;
             }
         }
         return count;
     }
     public void test(){
         for(LogEntry le: records){
             if(records.contains(le.getStatusCode())){
                 System.out.println("true");
             }
             else{
                 System.out.println("false");
            }
         }
     }
     public HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String,Integer> list = new HashMap<String,Integer>();
         for(LogEntry le: records){
             if(!list.containsKey(le.getIpAddress())){
                 list.put(le.getIpAddress(),1);
             }
             else{
                 list.put(le.getIpAddress(),list.get(le.getIpAddress())+1);
             }
         }
         return list;
     }
     public int  mostNumberVisitsByIP(HashMap<String,Integer> list){
         int max=0;
         for(String s: list.keySet()){
             if(list.get(s)>max){
                 max= list.get(s);
             }
         }
         return max;
     }
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> list){
         ArrayList<String> most = new ArrayList<String>();
         int max = mostNumberVisitsByIP(list);
         for(String s: list.keySet()){
             if(list.get(s)==max){
                 most.add(s);
             }
         }
         return most;
     }
     public HashMap <String, ArrayList <String>> iPsForDays(){
         HashMap <String, ArrayList <String>> list = new HashMap <String, ArrayList <String>>();
         // khoi tao mang
         for(LogEntry le: records){
             String day = (le.getAccessTime()).toString();
             day = day.substring(4,10);
             if(!list.containsKey(day)){
                 list.put(day, new ArrayList <String>());
                 list.get(day).add(le.getIpAddress());
             }
             else{
                 list.get(day).add(le.getIpAddress());
             }
         }
         return list;
     }
     public String dayWithMostIPVisits(HashMap <String, ArrayList <String>> list){
         String mostIp="";
         int max=0;
         for(String s: list.keySet()){
             if(list.get(s).size()>max){
                 max = list.get(s).size();
                 mostIp = s;
             }
         }
         return mostIp;
     }
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap <String, ArrayList <String>> list, String day){
         HashMap<String,Integer> map = new HashMap<String,Integer>();
         for(String key: list.keySet()){
             if(key.equals(day)){
               for(String s: list.get(key)){
                  if(!map.containsKey(s)){
                     map.put(s,1);
                  }
                  else{
                      map.put(s,map.get(s)+1);
                  }
               }
            }
         }
         return iPsMostVisits(map);
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
