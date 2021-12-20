/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dev
 */
import javax.swing.border.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Signup extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JTextField textField;
    private JTextField t1,t2,t3;
    private JButton b1,b2;
    private JComboBox comboBox;
    
    public Signup(){
        super("SIGNUP JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400,50,580,406);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        
        JLabel lu = new JLabel("Username : ");
        lu.setForeground(Color.DARK_GRAY);
        lu.setFont(new Font("Tahoma",Font.BOLD,14));
        lu.setBounds(99,86,92,26);
        contentPane.add(lu);
        
        
	JLabel lblName = new JLabel("Name :");
	lblName.setForeground(Color.DARK_GRAY);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(99, 123, 92, 26);
	contentPane.add(lblName);
        
        JLabel lp = new JLabel("Password : ");
        lp.setForeground(Color.DARK_GRAY);
        lp.setFont(new Font("Tahoma",Font.BOLD,14));
        lp.setBounds(99,163,92,26);
        contentPane.add(lp);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Your NickName?","Your Lucky Number ?","Your Childhood superhero?","your childhood name ?"}));
        comboBox.setBounds(265,202,160,20);
        contentPane.add(comboBox);
        
        JLabel lsq = new JLabel("Security Quesion : ");
        lsq.setForeground(Color.DARK_GRAY);
        lsq.setFont(new Font("Tahoma",Font.BOLD,14));
        lsq.setBounds(99,197,140,26);
        contentPane.add(lsq);
        
        textField = new JTextField();
        textField.setBounds(265,91,148,20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        t1 = new JTextField();
        t1.setColumns(10);
        t1.setBounds(265,128,148,20);
        contentPane.add(t1);
        
        t2 = new JTextField();
        t2.setColumns(10);
        t2.setBounds(265,165,148,20);
        contentPane.add(t2);
        
        t3 = new JTextField();
        t3.setColumns(10);
        t3.setBounds(265,239,148,20);
        contentPane.add(t3);
        
        b1 = new JButton("Create");
        b1.setFont(new Font("Tahoman",Font.BOLD,14));
        b1.setBounds(140,289,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);
        
        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma",Font.BOLD,14));
        b2.setBounds(300,289,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(34,139,34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31,46,476,296);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        
        setVisible(true);
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "insert into account(username,name,password,sec_q,sec_ans) values(?, ?, ?, ?, ?);";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                st.setString(1,textField.getText());
                st.setString(2,t1.getText());
                st.setString(3,t2.getText());
                st.setString(4,(String)comboBox.getSelectedItem());
                st.setString(5,t3.getText());
                
                int i = st.executeUpdate();
                if(i>0){
                    JOptionPane.showMessageDialog(null,"successfully Created");
                }
                textField.setText("");
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }
            if(ae.getSource()==b2){
                this.setVisible(false);
                new Login_user().setVisible(true);
            }
        }catch(Exception e){
        
        }
    }
    
    public static void main(String args[]){
        new Signup().setVisible(true);
    }
}
