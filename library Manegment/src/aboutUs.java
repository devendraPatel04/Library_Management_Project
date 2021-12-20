import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.awt.Desktop.*;
public class aboutUs extends JFrame{
    JButton b ,b3;
    public aboutUs(){
        super("About Us JFrame");
        getContentPane().setBackground(new Color(240, 200, 173));
        
        JLabel l = new JLabel("Well This Is Me");
        l.setFont(new Font("Courier",Font.ITALIC,18));
        l.setBounds(220,30,150,30);
        add(l);
        
        b3 = new JButton("Back");
        b3.setFont(new Font("Trebuchet MS",Font.BOLD,15));
        b3.setBounds(10,10,80,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);
        
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new Home().setVisible(true);
            }
        });
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\dev_profile.jpeg");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b = new JButton(i3);
        b.setBounds(190,100,200,200);
        add(b);
        
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                    try{
                        Desktop.getDesktop().browse(new URL("https://github.com/devendraPatel04").toURI());
                        //Desktop.getDesktop().browse(new URL("https://www.linkedin.com/in/devendra-patel-5a9aa4221/").toURI());
                    }
                    catch(Exception ee){
                        ee.printStackTrace();
                    }
            }
        });
        
        setBounds(410,10,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
    }
    
    public static void main(String args[]){
        new aboutUs().setVisible(true);
    } 
}
