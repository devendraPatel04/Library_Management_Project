import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener{
    private JTextField t1,t2,t3;
    private JComboBox cb,cb1,cb2,cb3;
    JButton b,b1,b2;
    
    public AddStudent(){
        super("Add Student JFrame");
        setBounds(400,50,485,412);
        getRootPane().setBorder(new EmptyBorder(10,10,10,10));
        getRootPane().setBackground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setUndecorated(true);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\close.png");
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        b = new JButton(i3);
        b.setBounds(440,0,25,25);
        b.addActionListener(this);
        add(b);
        
        JLabel l1 = new JLabel("Student_id");
        l1.setForeground(new Color(25,25,112));
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setBounds(64,63,102,22);
        add(l1);
        
        JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 97, 102, 22);
	add(l2);

	JLabel l3 = new JLabel("Father's Name");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 130, 102, 22);
	add(l3);

	JLabel l4 = new JLabel("Branch");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 209, 102, 22);
	add(l4);

        JLabel l5 = new JLabel("Year");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 242, 102, 22);
	add(l5);

	JLabel l6 = new JLabel("Semester");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 275, 102, 22);
	add(l6);
        
        JLabel l7 = new JLabel("Course");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(64, 173, 102, 22);
	add(l7);
        
        t1 = new JTextField();
        t1.setForeground(new Color(47,79,79));
        t1.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        t1.setBounds(180,66,156,20);
        add(t1);
        t1.setColumns(10);
        
        t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(180, 100, 156, 20);
	add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(180, 133, 156, 20);
	add(t3);
        
        cb = new JComboBox();
        cb.setModel(new DefaultComboBoxModel(new String[]{"Mechanical", "CSE", "IT", "Civil", "Automobile", "EEE", "Other" }));
        cb.setForeground(new Color(47,79,79));
        cb.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        cb.setBounds(180,211,154,20);
        add(cb);
        
        cb1 = new JComboBox();
        cb1.setModel(new DefaultComboBoxModel(new String[]{"First", "Second", "Third", "Four" }));
        cb1.setForeground(new Color(47,79,79));
        cb1.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        cb1.setBounds(180,244,154,20);
        add(cb1);
        
        cb2 = new JComboBox();
        cb2.setModel(new DefaultComboBoxModel(new String[]{"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
        cb2.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        cb2.setForeground(new Color(47,79,79));
        cb2.setBounds(180,277,154,20);
        add(cb2);
        
        cb3 = new JComboBox();
        cb3.setModel(new DefaultComboBoxModel(new String[]{ "B.E", "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "M.Sc", "B.Com", "M.Com"}));
        cb3.setForeground(new Color(47,79,79));
        cb3.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        cb3.setBounds(180,176,154,20);
        add(cb3);
        
        b1 = new JButton("ADD");
        b1.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        b1.setBounds(64,321,111,33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Back");
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(102,205,170),2,true),"Add-Student",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(30,144,255)));
        panel.setBackground(Color.WHITE);
        panel.setBounds(18,25,372,353);
        add(panel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            System.exit(0);
        }
     
            if(ae.getSource()==b1){
                try{
                    conn con = new conn();
                    String sql = "insert into student(student_id, name, father, course, branch, year, semester) values(?, ?, ?, ?, ?, ?, ?);";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
		    st.setString(3, t3.getText());
                    st.setString(4, (String)cb3.getSelectedItem());
                    st.setString(5, (String)cb.getSelectedItem());
                    st.setString(6, (String)cb1.getSelectedItem());
                    st.setString(7, (String)cb2.getSelectedItem());
                    
                    int i = st.executeUpdate();
                    if(i>0){
                        JOptionPane.showMessageDialog(null,"Successfully Added");
                        this.setVisible(false);
                        new Home().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Error");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ae.getSource()==b2){
                this.setVisible(false);
                new Home().setVisible(true);
            }
            
    }
    
    public static void main(String args[]){
        new AddStudent().setVisible(true);
    }
}
