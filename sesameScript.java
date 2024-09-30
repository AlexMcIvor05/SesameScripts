import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class sesameScript {
   
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String args[]){
        JFrame frame = new JFrame();
        
        
        JButton left = new JButton("<-");
        JButton right = new JButton("->");
        
                // Add action listener to the button 
                left.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 
                        // This code runs when the button is pressed 
                        JOptionPane.showMessageDialog(frame, "Move left"); 
                    } 
                }); 


                right.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 
                        // This code runs when the button is pressed 
                        JOptionPane.showMessageDialog(frame, "Move right"); 
                    } 
                }); 

                 
        frame.add(left);
        //frame.getContentPane().add(right);
        
        frame.add(right);
        frame.setLayout(new GridLayout());


        //frame.setLayout(new BorderLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        frame.setSize(300, 150); // Set your desired size
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
		//frame.setLocationRelativeTo(null); // Center the window on the screen

		frame.setVisible(true); // Make the window visible
    }
}
