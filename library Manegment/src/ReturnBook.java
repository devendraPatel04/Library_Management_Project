import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class ReturnBook extends JFrame implements ActionListener{
    private JTextField tf,tf1,tf2,tf3,tf4,tf5,tf6,tfd;
    private JButton b1,b2,b3;
    String date;
    
    public void delete(){
        try {
            conn con = new conn();
            String sql = "delete from issueBook where student_id=?;";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, tf1.getText());
            int i = st.executeUpdate();
            if (i > 0){
                JOptionPane.showConfirmDialog(null, "Book Returned");
                tf.setText("");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                tf6.setText("");
            }
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
	}
    }
    
    public ReturnBook(){
        
        setBounds(400,50,617,363);
        getRootPane().setBorder(new EmptyBorder(10,10,10,10));
        getRootPane().setBackground(Color.BLACK);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Book_id");
	lblNewLabel.setForeground(new Color(0, 0, 0));
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel.setBounds(52, 52, 87, 24);
	add(lblNewLabel);

	JLabel lblStudentid = new JLabel("Student_id");
	lblStudentid.setForeground(Color.BLACK);
	lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblStudentid.setBounds(243, 52, 87, 24);
	add(lblStudentid);

	JLabel lblBook = new JLabel("Book");
	lblBook.setForeground(Color.BLACK);
	lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblBook.setBounds(52, 98, 71, 24);
	add(lblBook);

	JLabel lblName = new JLabel("Name");
	lblName.setForeground(Color.BLACK);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(300, 98, 71, 24);
	add(lblName);

        JLabel lblCourse = new JLabel("Course");
	lblCourse.setForeground(Color.BLACK);
	lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblCourse.setBounds(52, 143, 87, 24);
	add(lblCourse);

        JLabel lblBranch = new JLabel("Branch");
	lblBranch.setForeground(Color.BLACK);
	lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblBranch.setBounds(303, 144, 68, 24);
	add(lblBranch);

	JLabel lblDateOfIssue = new JLabel("Date of Issue");
	lblDateOfIssue.setForeground(Color.BLACK);
	lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDateOfIssue.setBounds(52, 188, 105, 29);
	add(lblDateOfIssue);

	JLabel lblDateOfReturn = new JLabel("Date of Return");
	lblDateOfReturn.setForeground(Color.BLACK);
	lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblDateOfReturn.setBounds(52, 234, 118, 29);
	add(lblDateOfReturn);
        
        tf = new JTextField();
        tf.setForeground(new Color(105,105,105));
        tf.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        tf.setBounds(128,56,105,20);
        add(tf);
        tf.setColumns(10);
       
        tf1 = new JTextField();
        tf1.setForeground(new Color(105,105,105));
        tf1.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        tf1.setBounds(340,56,93,20);
        add(tf1);
        tf1.setColumns(10);
         
        b1 = new JButton("Search");
        b1.setBounds(443,52,105,29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        tf2 = new JTextField();
        tf2.setEditable(false);
        tf2.setForeground(new Color(0,100,0));
        tf2.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        tf2.setBounds(128,100,162,20);
        add(tf2);
        tf2.setColumns(10);
        
        tf3 = new JTextField();
        tf3.setEditable(false);
        tf3.setForeground(new Color(0,100,0));
        tf3.setFont(new Font("Trebuchet MS",Font.BOLD,14));
        tf3.setColumns(10);
        tf3.setBounds(369,102,179,20);
        add(tf3);
        
        tf4 = new JTextField();
	tf4.setEditable(false);
	tf4.setForeground(new Color(0, 100, 0));
	tf4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	tf4.setColumns(10);
	tf4.setBounds(128, 147, 162, 20);
	add(tf4);

	tf5 = new JTextField();
	tf5.setForeground(new Color(0, 100, 0));
	tf5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	tf5.setEditable(false);
	tf5.setColumns(10);
	tf5.setBounds(369, 147, 179, 20);
	add(tf5);

	tf6 = new JTextField();
	tf6.setForeground(new Color(0, 100, 0));
	tf6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
	tf6.setEditable(false);
	tf6.setColumns(10);
	tf6.setBounds(167, 194, 162, 20);
	add(tf6);
        
        Date d = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");
        date = fmt.format(d);
        tfd = new JTextField();
        tfd.setBackground(Color.BLACK);
        tfd.setForeground(Color.WHITE);
        tfd.setEditable(false);
        tfd.setBounds(167,234,150,27);
        tfd.setFont(new Font("Tahoma",Font.BOLD,15));
        tfd.setText("      "+date);
        add(tfd);
        
        b2 = new JButton("Return");
        b2.setFont(new Font("Trebuchet MS",Font.BOLD,15));
        b2.setBounds(369,190,149,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setFont(new Font("Trebuchet MS",Font.BOLD,15));
        b3.setBounds(369,231,149,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(255,69,0),2,true),"Return-panel",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(220,20,60)));
        panel.setBounds(6,26,569,269);
        panel.setBackground(Color.WHITE);
        add(panel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource()==b1){
                String sql = "select * from issueBook where student_id=? and book_id=?;";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, tf1.getText());
                st.setString(2, tf.getText());
                ResultSet rs = st.executeQuery();
                
                while(rs.next()){
                    tf2.setText(rs.getString("bname"));
                    tf3.setText(rs.getString("sname"));
                    tf4.setText(rs.getString("course"));
                    tf5.setText(rs.getString("branch"));
                    tf6.setText(rs.getString("dateOfIssue"));
                }
                st.close();
                rs.close();
            }
            
            if(ae.getSource() == b2){
                if(tf.getText().equals("") || tf1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"fill book id and student id");
                }
                else{
                    String sql = "insert into returnBook(book_id, student_id, bname, sname,course, branch, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?);";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, tf.getText());
                    st.setString(2, tf1.getText());
                    st.setString(3, tf2.getText());
                    st.setString(4, tf3.getText());
                    st.setString(5, tf4.getText());
                    st.setString(6, tf5.getText());
                    st.setString(7, tf6.getText());
                    st.setString(8, date);
                
                    int i = st.executeUpdate();
                
                    if(i>0){
                        JOptionPane.showMessageDialog(null, "Processing");
                        delete();
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Error");
                }
            }
            
            if(ae.getSource()==b3){
                setVisible(false);
                new Home().setVisible(true);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String rag[]){
        new ReturnBook().setVisible(true);
    }
}
