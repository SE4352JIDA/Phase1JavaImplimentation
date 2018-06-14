package KWIC;

//Class used from twinklesharma1311/KWIC-Index

import java.util.ArrayList;

public class CircularShift {

    public static ArrayList execute(String s) {
        ArrayList<String> list = new ArrayList();
        String[] input = (s.toLowerCase()).split(" ");

        String temp = s;
        list.add(temp);
        for(int j=0; j<input.length-1;j++)
        {
            input = temp.split(" ");
            temp = "";
            for(int i=0; i<input.length -1;i++)
            {
                temp += input[i+1] + " ";
            }
            temp +=input[0];
 
            list.add(temp);
        }
        return list;
    }
}
