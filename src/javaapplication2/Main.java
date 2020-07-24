
package javaapplication2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {

   static JFrame j1;
    
    Main()
    {
        
        j1=new JFrame("game");
        
        j1.setBounds(10,10,700,600);
      
        j1.setResizable(false);
        j1.setVisible(true);
        score sr=new score();
        gameplay gp=new gameplay();
        
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          ///j1.add(sr,BorderLayout.NORTH);
        j1.add(gp);
    }
    
   
  
    public static void main(String[] args) {
    
        new Main();
        
        
    }
    
}
