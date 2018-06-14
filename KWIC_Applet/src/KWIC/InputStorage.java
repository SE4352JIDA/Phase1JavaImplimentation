package KWIC;

import java.util.ArrayList;

public class InputStorage {
    
    ArrayList<String> lines;
    ArrayList<ArrayList> csLines;
    
    public InputStorage(){
        lines = new ArrayList();
        csLines = new ArrayList();
    }
    
    public void addLine(String list){
        lines.add(list);
    }
    
    public ArrayList<String> getLines(){
        return lines;
    }
    
    public void addCSLine(ArrayList<ArrayList> list){
        csLines.add(list);
    }
        
    public ArrayList<ArrayList> getCSLines(){
        return csLines;
    }
    // Converts an List of Strings to a single string with each element
   // of the list seperated by a newline
}
