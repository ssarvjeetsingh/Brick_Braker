
package javaapplication2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import static javaapplication2.Main.j1;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class score extends JPanel{
    
    static JLabel scor;
    score()
    {
       setLayout(new GridLayout(1,1));
          scor=new JLabel("Score :0");
        
          // scor.setFontColor(Color.red);
       add(scor);
    }
}
