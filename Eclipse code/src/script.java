import javax.swing.*;

import java.awt.event.*;
import java.util.HexFormat;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import com.fazecast.jSerialComm.*;

public class script {
   
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String args[]){
        JFrame frame = new JFrame();
        
        
        //add images instead of ASCII

        JButton left = new JButton("<");
        JButton right = new JButton(">");
        JButton up = new JButton("^");
        JButton down = new JButton("v");
        JButton center = new JButton("EXIT");

        SerialPort comPort = SerialPort.getCommPort("COM4");
        
        comPort.openPort();
        

        // Add action listener to the buttons
                center.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 

                        // This code runs when the button is pressed 
                        frame.dispose();
                    } 
                }); 

                left.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 

                        // This code runs when the button is pressed 
                        comPort.writeBytes(new byte[] {'l'}, 1);
                    } 
                }); 


                right.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 

                        // This code runs when the button is pressed 
                        comPort.writeBytes(new byte[] {'r'}, 1);
                    } 
                }); 
                up.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 

                        comPort.writeBytes(new byte[] {'u'}, 1);

                        // This code runs when the button is pressed 
                        //JOptionPane.showMessageDialog(frame, "Move up"); 
                    } 
                }); 


                down.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 
                        comPort.writeBytes(new byte[] {'d'}, 1);

                        // This code runs when the button is pressed 
                        //JOptionPane.showMessageDialog(frame, "Move down"); 
                    } 
                }); 


        //add buttons to frame
        frame.add(left, BorderLayout.WEST);
        frame.add(right, BorderLayout.EAST);
        frame.add(up, BorderLayout.NORTH);
        frame.add(down, BorderLayout.SOUTH);
        frame.add(center, BorderLayout.CENTER);
        //frame.setLayout(new BorderLayout());

        frame.setLocationRelativeTo(null);
        // window size
        frame.setSize(250, 200); 

        //removes the option to minimize or close
        //frame.setUndecorated(true);
        
        // Close the application when the window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Make the window visible
		frame.setVisible(true); 

        //window is top priority
        frame.setAlwaysOnTop(true);
        
    }
}
