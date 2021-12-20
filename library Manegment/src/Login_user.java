import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Login_user extends JFrame implements ActionListener{
    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1,b2,b3;
    
    
    public Login_user(){
        
        setTitle("Login JFrame");
        panel=new JPanel();
        setLayout(null);
        setBackground(new Color(169,169,169));
        setBounds(410,10,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.setBackground(new Color(176,224,230));
        setContentPane(panel);
        panel.setLayout(null);
        
        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(124,89,100,35);
        panel.add(l1);
        
        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(124,140,100,35);
        panel.add(l2);
        
        textField = new JTextField();
        textField.setBounds(230,97,157,20);
        panel.add(textField);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(230,147,157,20);
        panel.add(passwordField);
        
        b1 = new JButton("Login");
        b1.setForeground(new Color(46,139,87));
        b1.setBackground(new Color(250,250,210));
        b1.setBounds(149,205,130,30);
        panel.add(b1);
        
        b2 = new JButton("Signup");
        b2.setForeground(new Color(139,69,19));
        b2.setBackground(new Color(255,235,205));
        b2.setBounds(300,205,140,30);
        panel.add(b2);
        
        b3 = new JButton("Forgot Password");
        b3.setForeground(new Color(205,92,92));
        b3.setBackground(new Color(253,245,230));
        b3.setBounds(210,260,179,30);
        panel.add(b3);
        
        JLabel l3 = new JLabel("Trouble in Login ? ");
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        l3.setForeground(new Color(0,0,0));
        l3.setBounds(50,265,150,20);
        panel.add(l3);
        
         JPanel panel2 = new JPanel();
        panel2.setBackground(Color.YELLOW);
        panel2.setBounds(30,40,520,270);
        panel.add(panel2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setVisible(true);
        panel.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            Boolean status = false;
           try{
                conn con = new conn();
                String sq1 = "select * from account where username=? and password=?;";
                PreparedStatement st = con.c.prepareStatement(sq1);
                
                st.setString(1,textField.getText());
                st.setString(2,passwordField.getText());
                
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    this.setVisible(false);
                    new Loading().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login...");
                } 
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==b2){
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }
        if(ae.getSource()==b3){
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }
    }
    
    public static void main(String args[]){
        
        new Login_user().setVisible(true);
    }
}
