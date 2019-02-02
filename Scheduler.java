//Anthony Pitts

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;
public class Scheduler{

    private static ArrayList<Talk> talks = new ArrayList<Talk>();
    private static ArrayList<Talk> talkOrder = new ArrayList<Talk>();
    
    public Scheduler(){
    }
 
    public static ArrayList<Talk> makeTalks(String talksFile) throws IOException{
        File f = new File(talksFile);
        String talksString = new Scanner(f).useDelimiter("\\A").next();  
        //learned abt this Syntax on stackOverflow
        talksString = talksString.replaceAll("\\s+","");
        int a=0;
        while(a<(talksString.length()-1)){
            String name = "";
            int startTime = 0000;
            int stopTime = 0000;
            Talk newTalk = new Talk(name, startTime, stopTime);
            while(Character.isLetter(talksString.charAt(a))){
                name = name + talksString.charAt(a);
                newTalk.setName(name);
                a++;
            }
            for(int b=a;(a-b)<4;a++){
                if(Character.isDigit(talksString.charAt(a))){
                    newTalk.setStartTime((newTalk.getStartTime()*10)+
                       Character.getNumericValue(talksString.charAt(a)));
                }
                else{
                    System.out.println("This is the incorrect file format");
                    System.exit(0);
                }
                if(startTime>2400){
                    System.out.println("Hours can't exceed 24");
                    System.exit(0);
                }
            }
            for(int c=a;(a-c)<4;a++){
                if(Character.isDigit(talksString.charAt(a))){
                    newTalk.setStopTime((newTalk.getStopTime()*10)+ 
                      Character.getNumericValue(talksString.charAt(a)));
                }
                else{
                    System.out.println("This is incorrect file format");
                    System.exit(0);
                }
                if(startTime>2400){
                    System.out.println("Hours can't exceed 24");
                    System.exit(0);
                }
            }  
            talks.add(newTalk);
        }
        return talks;
    }
    
    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talks) throws IOException{
        talks = talks;
        sortStopTimes();
        int i=0;
        while(talkOrder.size()==0){
            outer: if((talks.get(i).getStopTime())<=(talks.get(i+1).getStartTime())){
                        if((talks.get(i).getStartTime())<(talks.get(i+1).getStartTime())){
                             talkOrder.add(talks.get(i));
                             i++;
                             break outer;
                            
                        }
                        i++;
                 }
                 else{
                     i++;
                 }
       }
        
       for(int a=0;i<(talks.size()-1);i++){
            if((talkOrder.get(a).getStopTime())<=(talks.get(i).getStartTime())){
                if((talkOrder.get(a).getStartTime())<(talks.get(i).getStartTime())){
                    talkOrder.add(talks.get(i));
                    a++;
                }
            }
       }
       System.out.println("The maximum number of presentations is "+talkOrder.size());
       return talkOrder; 
    }
    
    public static void sortStopTimes(){
        for(int a=0; a<(talks.size());a++){
            for(int i=0;i<(talks.size()-1);i++){
                int result = talks.get(i).compareTo(talks.get(i+1));
                if(result==1){
                    Collections.swap(talks,i,(i+1));
                }
            }
        }
    }
    
}
