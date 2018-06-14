package KWIC;

import java.applet.Applet;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyApplet extends Applet implements ActionListener{
   TextArea inputArea;
   TextArea outputArea;
   TextArea sortedArea;
   InputStorage is;
   
   @Override
   public void init() {
      setSize(500, 500);
      inputArea = new TextArea(3,50);
      inputArea.setEditable(true);
      add(inputArea,"left");
      
      Button b = new Button("Shift");
      b.addActionListener(this);
      add(b);
      
      outputArea = new TextArea(20,50);
      outputArea.setEditable(false);
      add(outputArea,"left");
      
      sortedArea = new TextArea(20,50);
      sortedArea.setEditable(false);
      add(sortedArea,"left");
      
      is = new InputStorage();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      String input = inputArea.getText();
      String[] lines = input.split("\n");
      outputArea.setText("");
      //add lines to InputStorage
      for(String line: lines){
          is.addLine(line);
      }
      //add Circular Shifted lines to input storage
      ArrayList<String> unShiftedLines = is.getLines();
      for(String line: unShiftedLines){
          is.addCSLine(CircularShift.execute(line));
      }
      //set output to unsorted lines
      outputArea.setText(listofListsToString(is.getCSLines()));
      //sort ilnes and set sortedArea to them
      ArrayList<ArrayList> sortedList = Alphabetizer.alphabetize(is.getCSLines());
      sortedArea.setText(listofListsToString(sortedList));
   }
   private String listToString(ArrayList<String> input){
       String result = "";
       for(String s: input){
           result += s + "\n";
       }
       return result;
   }
   private String listofListsToString(ArrayList<ArrayList> input){
       String result = "";
       for(ArrayList s: input){
           result += listToString(s) + "\n\n";
       }
       return result;
   }
}
