//Anthony Pitts

import java.util.ArrayList;
import java.io.*;
public class Talk implements Comparable<Talk>{
    
    private int startTime;
    private int stopTime;
    private String name;
    
    public Talk(String name, int startTime, int stopTime){
        name = "";
        startTime = 0000;
        stopTime = 0000;
    }
    public String getName(){
        return name;
    }
    
    public int getStartTime(){
        return startTime;
    }
    
    public int getStopTime(){
        return stopTime;
    }
    public void setName(String n){
        this.name = n;
    }
    
    public void setStartTime(int i){
        this.startTime = i;
    }
    
    public void setStopTime(int j){
        this.stopTime = j;
    }
    
    public int compareTo(Talk t){
        if(this.getStopTime()>t.getStopTime()){
            return 1;
        }
        else if(this.getStopTime()<t.getStopTime()){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    public String toString(){
        String talkDetails = this.getName()+"    "+this.getStartTime()+"    "+this.getStopTime();
        return talkDetails;
    }
}