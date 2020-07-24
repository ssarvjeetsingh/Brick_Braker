
package javaapplication2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class gameplay extends JPanel implements KeyListener,ActionListener{
      
    private boolean play=false;
    private int player=310,delay=20;
    private Timer timer;
   
    int scoree=0;
    int tbrich=21;
    private int ballposx=120;
    private int ballposy=350;
    private int ballxdir=-1;
    private int ballydir=-2;
    private frame fr;
     
    gameplay()
    {  fr=new frame(3,7); 
       
        addKeyListener(this);
       setFocusable(true);
       setFocusTraversalKeysEnabled(false);
   
       timer =new Timer(delay,this);
       timer.start();
        
    }
    
    public void paint(Graphics g)
    {
     ///score
        //g.setColor(Color.white);
        
      ///backgroud
        
        g.setColor(Color.white);
        g.fillRect(1, 1, 692,592);
        ///scores
        g.setColor(Color.red);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString((""+scoree), 590, 30);
        
        ////
          fr.draw((Graphics2D)g);
         
        ///paddel
        
        g.setColor(Color.red);
        g.fillRect(player, 550, 100,8);
       
        ////ba;;k
        g.setColor(Color.blue);
        g.fillOval(ballposx, ballposy, 20,20);
        ////win game
        
        if(tbrich==0)
        {
          play=false;
           ballxdir=0;
             ballydir=0;
        g.setColor(Color.GREEN);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString(("you won! Score:"+scoree), 190, 300);
        
        
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString(("press enter to play again:"), 200, 350);
   
        }
        ///game over
        
        if(ballposy>590)
        {
         play=false;
           ballxdir=0;
             ballydir=0;
        g.setColor(Color.RED);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString(("Game Over! Score:"+scoree), 190, 300);
        
        
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString(("press enter to start:"), 200, 350);
        }
         g.dispose();
    }
   
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
     
          timer.start();
            if(play)
          {
              
              if(new Rectangle(ballposx, ballposy, 20,20).intersects(new Rectangle(player, 550, 100,8)))
                      {
                          ballydir=-ballydir;
                      }
          
          
          A:  for(int i=0;i<fr.map.length;i++){
            for(int j=0;j<fr.map[0].length;j++)
            {
            if(fr.map[i][j]>0)
            {
           int brickx=j*fr.brickwidth+80;  
           int bricky=i*fr.brickheight+50;
           int brickwidth=fr.brickwidth;
           int brickheight=fr.brickheight;
           
           Rectangle rect=new Rectangle(brickx,bricky,brickwidth,brickheight);
           Rectangle ballrect=new Rectangle(ballposx, ballposy, 20,20);
           Rectangle brickrect=rect;
           if(ballrect.intersects(brickrect))
           {
               fr.setbrikvalue(0,i,j);
               tbrich--;
               scoree+=5;
               score.scor.setText("score :"+scoree);
             /*  if(tbrich==0)
               {
                    int v=JOptionPane.showConfirmDialog(Main.j1,"you won do you want restart","confirm",JOptionPane.YES_NO_OPTION);
				if(v==JOptionPane.YES_OPTION)
				{   
                                      play=false;
                                     player=310;
                                     delay=20;
                                     
                                     scoree=0;
                                      tbrich=21;
                                       ballposx=120;
                                         ballposy=350;
                                       ballxdir=-1;
                                       ballydir=-2;
                                       player=310;
                                   
                                       new Main(); 
		                }
                                else
                                {
                                    
                                }
               }*/
               if(ballposx+19<=brickrect.x||ballposx+1>=brickrect.x+brickrect.width)
               {
                   ballxdir=-ballxdir;
               }
               else
               {
                   ballydir=-ballydir;
               }
               break A;
           }
        
             }
        }
           
          
         
              ballposx+=ballxdir;
               ballposy+=ballydir;
               if(ballposx<0)
               {
                   ballxdir=-ballxdir;
                   
               }
               if(ballposy<0)
               {
                    ballydir=-ballydir;
               }
               if(ballposx>670)
               {
                    ballxdir=-ballxdir;
               }
             /*  if(ballposy>600)
               {
                  
                  int v=JOptionPane.showConfirmDialog(Main.j1,"game over with score:"+scoree+"do you want restart","confirm",JOptionPane.YES_NO_OPTION);
				if(v==JOptionPane.YES_OPTION)
				{   
                                      play=false;
                                     player=310;
                                     delay=20;
                                     
                                     scoree=0;
                                      tbrich=21;
                                       ballposx=120;
                                         ballposy=350;
                                       ballxdir=-1;
                                       ballydir=-2;
  
                                   
                                       new Main(); 
		                }
                                else
                                {
                                    Main.j1.setVisible(false);
                                }

               }*/
          }
        repaint();
    }
    }
     @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
@Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
           if(player>=600)
           {
               player=600;
           }
           else
           {
               moveRight();
           }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
           if(player<10)
           {
               player=10;
           }
           else
           {
               moveLeft();
           } 
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
     play=true;       
     scoree=0;
     tbrich=21;
     ballposx=120;
     ballposy=350;
     ballxdir=-1;
     ballydir=-2;
     player=350;
     fr=new frame(3,7);
     repaint();
     
        }
        
    }

    void  moveRight()
    {
        play=true;
        player=player+40;
       
    }
        void  moveLeft()
    {
        play=true;
        player=player-40;
        
    }
    
    
}
