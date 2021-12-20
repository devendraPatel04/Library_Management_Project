import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
public class StudentDetails extends JFrame implements ActionListener{
    private JTable table;
    private JTextField search;
    private JButton b1,b2;
    
    public void student(){
         try {
            conn con = new conn();
            String sql = "select * from student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public StudentDetails(){
        super("Student Details JFrame");
        setBounds(350,50,890,475);
        getContentPane().setBackground(Color.WHITE);
        getRootPane().setBorder(new EmptyBorder(5,5,5,5));
        setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50,100,771,288);
        add(scrollPane);
        
        table = new JTable();
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent args){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,1).toString());
            }
        });
        
        table.setBackground(new Color(240,248,255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("trebuchet MS",Font.BOLD,16));
        scrollPane.setViewportView(table);
        
        JButton b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255,20,147),2,true));
        ImageIcon i1 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\eight.png");
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setForeground(new Color(199,21,133));
        b1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        b1.setBounds(538,63,138,33);
        add(b1);
        
        JButton b2 = new JButton("Delete");
        b2.addActionListener(this);
        b2.setBorder(new LineBorder(new Color(255,20,147),2,true));
        b2.setBounds(680,63,138,33);
        add(b2);
        
        search = new JTextField();
        search.setBackground(new Color(255,240,245));
        search.setBorder(new LineBorder(new Color(255,105,180),2,true));
        search.setForeground(new Color(47,79,79));
        search.setBounds(176,63,357,33);
        add(search);
        search.setColumns(10);
        
        JLabel l2 = new JLabel("Back");
        l2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                setVisible(false);
                new Home().setVisible(true);
            }
        });
        l2.setForeground(Color.GRAY);
        l2.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        ImageIcon i7 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\tenth.png");
        Image i8 = i7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l2.setIcon(i9);
        l2.setBounds(70,63,130,35);
        add(l2);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(95,158,160),2,true),"Student-Details",TitledBorder.LEADING, TitledBorder.TOP,null,new Color(72,209,204)));
        panel.setBounds(40,45,791,355);
        panel.setBackground(Color.WHITE);
        add(panel);
        
        student();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         try{
            
            conn con = new conn();
            if( ae.getSource() == b1){
                String sql = "select * from student where concat(name, student_id) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(rs));
		rs.close();
		st.close();
            }
    
            if(ae.getSource() == b2){
                String sql = "delete from student where name = '" + search.getText() + "'";
		PreparedStatement st = con.c.prepareStatement(sql);

		JDialog.setDefaultLookAndFeelDecorated(true);
		int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.NO_OPTION) {

		} else if (response == JOptionPane.YES_OPTION) {
                    int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted !!");
		} else if (response == JOptionPane.CLOSED_OPTION) {
                
                }
		st.close();
            }
            con.c.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new StudentDetails().setVisible(true);
    }
}
