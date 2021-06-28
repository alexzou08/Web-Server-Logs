
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
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
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        //la.printAll();
        //int uIps = la.countUniqueIps();
        //System.out.println("There are " + uIps + " IPs");
        //la.printAllHigherThanNum(400);
        //la.readFile("weblog-short_log");
        //ArrayList<String> uIP1 = la.uniqueIPVisitsOnDay("Sep 14");
        ArrayList<String> uIP2 = la.uniqueIPVisitsOnDay("Mar 17");
        //for(String s : uIP1) {
        //    System.out.println(s);
        //}
        //for(String s : uIP2) {
        //    System.out.println(s);
        //}
        System.out.println(uIP2.size());
    }
    
    public void testCountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        int test1 = la.countUniqueIPsInRange(200, 299);
        System.out.println("Expected:  Got " + test1);
        int test2 = la.countUniqueIPsInRange(300, 399);
        System.out.println("Expected:  Got " + test2);
    }
    
    public void testCountsHashMap() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
    }
}
