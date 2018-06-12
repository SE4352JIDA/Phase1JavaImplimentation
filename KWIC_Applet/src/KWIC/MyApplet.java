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
   ArrayList<String> csItems;
   
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
      outputArea.setEditable(true);
      add(outputArea,"left");
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      String input = inputArea.getText();
      outputArea.setText("");
      csItems = CircularShift.execute(input.toLowerCase());
      outputArea.setText(listToString(csItems));
   }
   // Converts an List of Strings to a single string with each element
   // of the list seperated by a newline
   private String listToString(ArrayList<String> input){
       String result = "";
       for(String s: input){
           result += s + "\n";
       }
       return result;
   }
}
