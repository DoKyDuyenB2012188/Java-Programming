
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer test = new LogAnalyzer();
        test.readFile("weblog2_log");
        int num = test.countUniqueIPsInRange(200,299);
        System.out.println("countUniqueIPsInRange: "+num);
        test.printAllHigherThanNum(400);
        int ipU = test.countUniquenIPs();
        System.out.println("IP unique: "+ipU);
        ArrayList<String> t = new ArrayList<String>();
        t= test.uniqueIPVisitsOnDay("Sep 27");
        System.out.println("uniqueIPVisitsOnDay: "+t.size());
        System.out.println("most number visit by ip: ");
        HashMap<String,Integer> count = test.countVisitsPerIP();
        int max = test.mostNumberVisitsByIP(count);
        System.out.println(max);
        ArrayList<String> most = new ArrayList<String>();
        System.out.println("IP most visit");
        most = test.iPsMostVisits(count);
        for(String s: most){
            System.out.println(s);
        }
        System.out.println("Date\tMount of IP");
        HashMap<String,ArrayList<String>> IpDay = test.iPsForDays();
        for(String s: IpDay.keySet()){
            System.out.println(s+"\t"+IpDay.get(s).size());
        }
        String mostIP = test.dayWithMostIPVisits(IpDay);
        System.out.println("most mount of IP of day: "+mostIP);
        //test.test();
        /*for(int i=0;i<t.size();i++){
            System.out.println(t.get(i));
        }*/
        System.out.println("IP most of visit on day: ");
        ArrayList<String> visitOnDay = test.iPsWithMostVisitsOnDay(IpDay,"Sep 29");
        for(String s: visitOnDay){
            System.out.println(s);
        }
    }
}
