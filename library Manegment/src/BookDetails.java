import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.BorderFactory.*;
import javax.swing.border.Border;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BookDetails extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1,b2,b3;
    JButton b;
    
    public void Book(){
        try{
            conn con = new conn();
            String sql = "select * from book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
        
    public BookDetails(){
        super("Book Details JFrame");
        setBounds(230,50,890,475);
        JPanel p = new JPanel();
        
        Border border = BorderFactory.createLineBorder(new Color(196, 255, 212), 3);
        getRootPane().setBorder(border); 
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\close.png");
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        b = new JButton(i3);
        b.setBounds(858,0,25,25);
        b.addActionListener(this);
        add(b);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79,133,771,282);
        add(scrollPane);
        
        table = new JTable();
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent arg){
                int row  = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 1).toString());
            }
        });
        table.setBackground(new Color(240,248,255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS",Font.BOLD,16));
        scrollPane.setViewportView(table);
        
        JButton b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(255,20,147),2,true));
        ImageIcon i4 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\eight.png");
        Image i5 = i4.getImage().getScaledInstance(20,15,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b1.setIcon(i6);
        b1.setForeground(new Color(199,21,133));
        //b1.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        b1.setBounds(564,89,138,33);
        add(b1);
        
        JButton b2 = new JButton("Delete");
        b2.addActionListener(this);
        ImageIcon i7 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\nineth.png");
        Image i8 = i7.getImage().getScaledInstance(20,17,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        b2.setIcon(i9);
        b2.setForeground(new Color(199,21,133));
        b2.setBorder(new LineBorder(new Color(255,20,147),2,true));
        b2.setBounds(712,89,138,33);
        add(b2);
        
        JLabel l1 = new JLabel("Book Details");
        l1.setForeground(new Color(107,142,35));
        l1.setFont(new Font("Treabuchet MS",Font.BOLD | Font.ITALIC,30));
        l1.setBounds(300,15,400,47);
        add(l1);
        
        search = new JTextField();
        search.setBackground(new Color(255,240,245));
        search.setBorder(new LineBorder(new Color(255,105,180),2,true));
        search.setForeground(new Color(47,79,79));
        search.setFont(new Font("Trebuchet MS",Font.BOLD | Font.ITALIC,17));
        search.setBounds(189,89,357,33);
        search.setColumns(10);
        add(search);
        
        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                setVisible(false);
                new Home().setVisible(true);
            }
        });
        
        l3.setForeground(Color.GRAY);
        l3.setFont(new Font("Trebuchet MS",Font.BOLD,18));
        ImageIcon i10 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\tenth.png");
        Image i11 = i10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l3.setIcon(i12);
        l3.setBounds(97,89,72,33);
        add(l3);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,128,128),3,true),"Book-Details",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,128,0)));
        panel.setBounds(62,57,806,375);
        panel.setBackground(Color.WHITE);
        add(panel);
        
        Book();
        
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            System.exit(0);
        }
         try{
            conn con = new conn();
            if(ae.getSource() == b1){
             
                String sql = "select * from book where concat(name, book_id) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();

            }
            if(ae.getSource() == b2){
                String sql = "delete from book where name = '" + search.getText() + "'";
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
        }catch(Exception ee){
            System.out.println(ee);
        }
    }
    
    public static void main(String args[]){
        new BookDetails().setVisible(true);
    }
}
