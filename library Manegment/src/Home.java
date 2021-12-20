import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class Home extends JFrame implements ActionListener{
    private JButton b1,b2,b3,b4,b5,b6;
    
    public Home(){
        getContentPane().setBackground(new Color(227, 203, 242));
        setTitle("Home JFrame");
        
        JMenuBar menubar = new JMenuBar();
        menubar.setBorder(new EtchedBorder(EtchedBorder.LOWERED,new Color(0,128,0),new Color(128,128,128)));
        menubar.setBackground(new Color(204, 149, 237));
        menubar.setBounds(0,0,800,35);
        add(menubar);
        
        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("Tahoma",Font.BOLD,17));
        
        JMenuItem mnItem = new JMenuItem("Logout");
        mnItem.setBackground(new Color(211,211,211));
        mnItem.setForeground(new Color(105,105,105));
        mnItem.addActionListener(this);
        mnExit.add(mnItem);
        
        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.setForeground(new Color(105,105,105));
        mniExit.setBackground(new Color(211,211,211));
        mniExit.addActionListener(this);
        mnExit.add(mniExit);
        
        JMenu mnHelp = new JMenu("Help");
        mnHelp.setFont(new Font("Trebuchet MS",Font.BOLD,17));
        
        JMenuItem mniReadme = new JMenuItem("Read Me");
        mniReadme.setBackground(new Color(211,211,211));
        mniReadme.setForeground(new Color(105,105,105));
        mnHelp.add(mniReadme);
        
        JMenuItem mniAboutus = new JMenuItem("About Us");
        mniAboutus.setForeground(new Color(105,105,105));
        mniAboutus.setBackground(new Color(211,211,211));
        mniAboutus.addActionListener(this);
        mnHelp.add(mniAboutus);
        
        JMenu mnRecord = new JMenu("Record");
        mnRecord.setFont(new Font("Trbuchet Ms",Font.BOLD,17));
        
        JMenuItem bookdetails = new JMenuItem("Book Details");
        bookdetails.setBackground(new Color(211,211,211));
        bookdetails.setForeground(Color.DARK_GRAY);
        bookdetails.addActionListener(this);
        mnRecord.add(bookdetails);
        
        JMenuItem studentdetails = new JMenuItem("Student Details");
        studentdetails.setBackground(new Color(211,211,211));
        studentdetails.setForeground(Color.DARK_GRAY);
        studentdetails.addActionListener(this);
        mnRecord.add(studentdetails);
  
        menubar.add(mnRecord);
        menubar.add(mnExit);
        menubar.add(mnHelp);
        
        JLabel l1 = new JLabel("Library Management System");
        l1.setForeground(new Color(204,51,102));
        l1.setFont(new Font("Segoe UI Semilight",Font.BOLD,30));
        l1.setBounds(203,30,701,80);
        add(l1);
        
        JLabel l2 = new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\second.png");
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(60,140,150,150);
        add(l2);
        
        JLabel l3 = new JLabel("");
        ImageIcon i4 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\third.png");
        Image i5 = i4.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(300,160,150,140);
        add(l3);
        
        JLabel l4 = new JLabel("");
        ImageIcon i7 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\fourth.png");
        Image i8 = i7.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setBounds(530,140,220,150);
        add(l4);
        
        b1 = new JButton("Add Books");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 320, 159, 44);
        add(b1);

        b2 = new JButton("Statistics");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(313, 320, 139, 44);
        add(b2);

        b3 = new JButton("Add Student");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(562, 320, 167, 44);
        add(b3);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(250,128,114),2),"Operation",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(220,20,60)));
        panel.setBounds(20,120,750,260);
        panel.setBackground(new Color(227, 203, 242));
        add(panel);
        
        b4 = new JButton("Issue Book");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(76,620,143,41);
        add(b4);
        
        b5 = new JButton("Return Book");
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(310, 620, 159, 41);
        add(b5);

        b6 = new JButton("About Us");
        b6.addActionListener(this);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(562, 620, 159, 41);
        add(b6);
        
        JLabel l5 = new JLabel("");
        ImageIcon i10 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\fifth.png");
        Image i11 = i10.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setBounds(60,440,150,150);
        add(l5);
        
        JLabel l6 = new JLabel("");
        ImageIcon i13 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\sixth.png");
        Image i14 = i13.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(320,440,139,152);
        add(l6);
        
        JLabel l7 = new JLabel("");
        ImageIcon i16 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\library Manegment\\src\\icons\\seventh.png");
        Image i17 = i16.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        l7 = new JLabel(i18);
        l7.setBounds(562,440,150,150);
        add(l7);
        
        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(205,133,63),2),"Action",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(233,150,122)));
        panel2.setBounds(20,410,750,270);
        panel2.setBackground(new Color(227, 203, 242));
        add(panel2);
        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,0,800,730);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Logout")){
            setVisible(false);
            new Login_user().setVisible(true);
        }
        else if(msg.equals("Exit")){
            System.exit(ABORT);
        }
        else if(msg.equals("Read Me")){
            
        }
        else if(msg.equals("About Us")){
            setVisible(false);
            new aboutUs().setVisible(true);
        }
        else if(msg.equals("Book Details")){
            setVisible(false);
            new BookDetails().setVisible(true);
        }
        else if(msg.equals("Student Details")){
            setVisible(false);
            new StudentDetails().setVisible(true);
        }
        
        if(ae.getSource() == b1){
            this.setVisible(false);
            new AddBook().setVisible(true);
        }
        
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Statistics().setVisible(true);
        }
        
        if(ae.getSource() == b3){
            this.setVisible(false);
            new AddStudent().setVisible(true);
        }
        
        if(ae.getSource() == b4){
            this.setVisible(false);
            new IssueBook().setVisible(true);
        }
        
        if(ae.getSource() == b5){
            this.setVisible(false);
            new ReturnBook().setVisible(true);
        }
        
        if(ae.getSource() == b6){
            this.setVisible(false);
            new aboutUs().setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new Home().setVisible(true);
    }
}
