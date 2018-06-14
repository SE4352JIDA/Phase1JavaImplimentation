package KWIC;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer {
    
    public static ArrayList<ArrayList> alphabetize(ArrayList<ArrayList> input){
        for(ArrayList list: input){
            Collections.sort(list);
        }
        return input;
    }
}
