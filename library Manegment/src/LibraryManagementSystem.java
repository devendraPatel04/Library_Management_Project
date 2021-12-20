import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1,b;
        
        public LibraryManagementSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(0,0,1367,730);
                setUndecorated(true);
                setLayout(null);
                
                ImageIcon bi = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\close.png");
                Image bi1 = bi.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                ImageIcon bi2 = new ImageIcon(bi1);
        
                b = new JButton(bi2);
                b.setBounds(1340,0,25,25);
                b.addActionListener(this);
                add(b);

		l1 = new JLabel("");
                b1 = new JButton("Next");
                
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		
                ImageIcon i1  = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\first.jpg");
                Image i3 = i1.getImage().getScaledInstance(1367, 730,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                b1.setBounds(900,645,90,25);
		l1.setBounds(0, 0, 1367, 730);
                
                l1.add(b1);
		add(l1);
                
                b1.addActionListener(this);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b1){
                new Login_user().setVisible(true);
                this.setVisible(false);
            }
            
            if(ae.getSource()==b){
                System.exit(0);
            }
        }
        
        public static void main(String[] args) {
                LibraryManagementSystem window = new LibraryManagementSystem();
                window.setVisible(true);			
	}
}
