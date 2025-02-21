import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.*;
import java.util.HexFormat;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import com.fazecast.jSerialComm.*;

public class script {
    static SerialPort comPort = SerialPort.getCommPort("COM5");

    public void actionPerformed(ActionEvent e) {
    }
    
    public static SerialPort getPort() {
    	SerialPort[] serialPorts = SerialPort.getCommPorts();
        SerialPort liveSerialPort = null;
        for (SerialPort p: serialPorts) {
        	System.out.println(p.getDescriptivePortName());
            p.openPort();
            if (p.isOpen()) {
            	System.out.println("IN");
                liveSerialPort = p;
                break;
            }
        }
        return liveSerialPort;
    }
    
    
    /**
     * @return
     */
    public static SerialPort portSearch(){
        SerialPort comPort = null;
        
        for(int i = 1 ;i<10;i++){

        
            try{
                comPort = SerialPort.getCommPort("COM"+i);
                comPort.openPort();
                comPort.writeBytes(new byte[] {'r'}, 1);
                //System.out.println("COM"+i);
                
            }catch(Exception e){
            	comPort = null;
            }
        
        }
        return comPort;
    }

    public static SerialPort getOpenPort(SerialPort comPort, JFrame frame){
    	SerialPort temp = null;
    	
    	if(comPort == null || !comPort.isOpen()){//
            temp = portSearch();
            if(temp == null){
                JOptionPane.showMessageDialog(frame, "not connected to device");
                System.out.println("Could not connect");
            }
            else{
            	comPort = temp;
            	
                comPort.openPort();
            }
        }else{
        	System.out.println("hi");
            comPort.openPort();
        }
        return temp;
    }
    
    public static void main(String args[]){
        JFrame frame = new JFrame();
        
        frame.setLayout(new GridBagLayout());

        //add images instead of ASCII

        JButton left = new JButton("<");
        JButton right = new JButton(">");
        JButton up = new JButton("^");
        JButton down = new JButton("v");
        JButton center = new JButton("EXIT");

        
        comPort = getPort();
/*
        // Add action listener to the buttons
                center.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 

                        // This code runs when the button is pressed 
                        frame.dispose();
                    } 
                }); 
*/
                left.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 

                    	if(comPort == null || !comPort.isOpen()) {
                            comPort = getPort();

                    	}
                        if(comPort != null) {
                        	
                        	comPort.writeBytes(new byte[] {'l'}, 1);
                        }
                        else {
                        	JOptionPane.showMessageDialog(frame, "Not connected"); 
                        }
                       } 
                }); 


                right.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 

                    	if(comPort == null || !comPort.isOpen()) {
                            comPort = getPort();

                    	}
                        if(comPort != null) {
                        	
                        	comPort.writeBytes(new byte[] {'r'}, 1);
                        }
                        else {
                        	JOptionPane.showMessageDialog(frame, "Not connected"); 
                        }
                    } 
                }); 
                up.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 
                    	
                    	if(comPort == null || !comPort.isOpen()) {
                            comPort = getPort();

                    	}
                        if(comPort != null) {
                        	
                        	comPort.writeBytes(new byte[] {'d'}, 1);
                        }
                        else {
                        	JOptionPane.showMessageDialog(frame, "Not connected"); 
                        }
                                             
                        // This code runs when the button is pressed 
                        //JOptionPane.showMessageDialog(frame, "Move up"); 
                    } 
                }); 


                down.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 

                    	if(comPort == null || !comPort.isOpen()) {
                            comPort = getPort();

                    	}
                        if(comPort != null) {
                        	
                        	comPort.writeBytes(new byte[] {'u'}, 1);
                        }
                        else {
                        	JOptionPane.showMessageDialog(frame, "Not connected"); 
                        }
                        	
                        

                        
                        // This code runs when the button is pressed 
                        //JOptionPane.showMessageDialog(frame, "Move down"); 
                    } 
                }); 


                
                
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.BOTH; // Make buttons fill the space
        //add buttons to frame
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridheight = 2; // Takes up 2 rows
                gbc.gridwidth = 1;
                gbc.weightx = 1;
                gbc.weighty = 1;
                frame.add(left, gbc);

                // Positioning Up Button (Occupies 1 row)
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.gridheight = 1; // Takes up 1 row
                gbc.gridwidth = 1;
                gbc.weightx = 1;
                gbc.weighty = 0.5;
                frame.add(up, gbc);

                // Positioning Down Button (Occupies 1 row)
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.gridheight = 1; // Takes up 1 row
                gbc.gridwidth = 1;
                gbc.weightx = 1;
                gbc.weighty = 0.5;
                frame.add(down, gbc);

                // Positioning Right Button (Occupies 2 rows)
                gbc.gridx = 2;
                gbc.gridy = 0;
                gbc.gridheight = 2; // Takes up 2 rows
                gbc.gridwidth = 1;
                gbc.weightx = 1;
                gbc.weighty = 1;
                frame.add(right, gbc);
        
                       // Positioning Left Button (Occupies 2 rows)
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridheight = 2; // Takes up 2 rows
                gbc.gridwidth = 1;
                gbc.weightx = 1;
                gbc.weighty = 1;
                frame.add(left, gbc);

                // Positioning Up Button (Occupies 1 row)
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.gridheight = 1; // Takes up 1 row
                gbc.gridwidth = 1;
                gbc.weightx = 1;
                gbc.weighty = 0.5;
                frame.add(up, gbc);

                // Positioning Down Button (Occupies 1 row)
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.gridheight = 1; // Takes up 1 row
                gbc.gridwidth = 1;
                gbc.weightx = 1;
                gbc.weighty = 0.5;
                frame.add(down, gbc);

                // Positioning Right Button (Occupies 2 rows)
                gbc.gridx = 2;
                gbc.gridy = 0;
                gbc.gridheight = 2; // Takes up 2 rows
                gbc.gridwidth = 1;
                gbc.weightx = 1;
                gbc.weighty = 1;
                frame.add(right, gbc);

   
        
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
