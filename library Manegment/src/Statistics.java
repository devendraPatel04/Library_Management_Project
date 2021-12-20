import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class Statistics extends JFrame{
    private JTable table;
    private JTable table_1;
    
    public void issueBook(){
        try{
            conn con = new conn();
            String sql = "select * from issueBook;";
            PreparedStatement st =  con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void returnBook(){
        try{
            conn con = new conn();
            String sql = "select * from returnBook;";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Statistics(){
        setBounds(380,20,810,594);
        getContentPane().setBackground(Color.WHITE);
        getRootPane().setBorder(new EmptyBorder(5,5,5,5));
        setLayout(null);
        
        JScrollPane scrollpane = new JScrollPane(); 
        scrollpane.setBounds(40,51,708,217);
        add(scrollpane);
        
        table = new JTable();
        table.setBackground(new Color(224,255,255));
        table.setForeground(new Color(128,128,0));
        table.setFont(new Font("Trebuchet MS",Font.BOLD,15));
        scrollpane.setViewportView(table);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(47,79,79),2,true),"Issue-Book-Details",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,128,128)));
        panel.setBackground(Color.WHITE);
        panel.setForeground(new Color(0,128,128));
        panel.setBounds(26,30,737,252);
        add(panel);
        
        JLabel l1 = new JLabel("Back");
        l1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                setVisible(false);
                new Home().setVisible(true);
            }
        });
        l1.setForeground(new Color(204,0,102));
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        ImageIcon i1 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\tenth.png");
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
        l1.setBounds(690,6,96,27);
        add(l1);
        
        JScrollPane scrollpane_1 = new JScrollPane();
        scrollpane_1.setBounds(40,316,717,217);
        add(scrollpane_1);
        
        table_1 = new JTable();
        table_1.setBackground(new Color(204,255,255));
        table_1.setForeground(new Color(153,51,0));
        table_1.setFont(new Font("Tahoma",Font.BOLD,12));
        scrollpane_1.setViewportView(table_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(220,40,200),2,true),"Return-Book-Detail",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(70,50,190)));
        panel_1.setBounds(24,293,747,252);
        panel_1.setBackground(Color.WHITE);
        add(panel_1);
        
        issueBook();
        returnBook();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new Statistics().setVisible(true);
    }
}
