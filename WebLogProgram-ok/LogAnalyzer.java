
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines()) {
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
         }
     }
     
     public int countUniqueIps() {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         //uniqueIPs.clear();
         for(LogEntry le : records) {
             String ipAddr = le.getIpAddress();
             if(!uniqueIPs.contains(ipAddr)) {
                 uniqueIPs.add(ipAddr);
             }
         }
         return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num) {
         for(LogEntry le : records) {
             if(le.getStatusCode() > num) {
                 System.out.println(le);
             }
         }
     }
     
     public ArrayList uniqueIPVisitsOnDay(String someday) {
         ArrayList<String> uniqueIPVisit = new ArrayList<>();
         //uniqueIPVisit.clear();
         for(LogEntry le : records) {
             String currentDay = le.getAccessTime().toString();
             if(currentDay.contains(someday)) {
                 String ip = le.getIpAddress();
                 if(!uniqueIPVisit.contains(ip)){
                     uniqueIPVisit.add(ip);
                 }
             }
         }
         return uniqueIPVisit;
     }
     
     public int countUniqueIPsInRange(int low, int high) {
         ArrayList<String> uniqueIPs = new ArrayList<>();
         for(LogEntry le : records) {
             String ipAddr = le.getIpAddress();
             int status = le.getStatusCode();
             if(!uniqueIPs.contains(ipAddr)) {
                 if(status >= low && status <= high) {
                     uniqueIPs.add(ipAddr);
                 }
             }
         }
         return uniqueIPs.size();
     }
     
     public HashMap<String, Integer> countVisitsPerIP() {
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         for(LogEntry le : records) {
             String ip = le.getIpAddress();
             if(!counts.containsKey(ip)) {
                 counts.put(ip, 1);
             } else {
                 counts.put(ip, counts.get(ip) + 1);
             }
         }
         return counts;
     }
     
         public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
}  
