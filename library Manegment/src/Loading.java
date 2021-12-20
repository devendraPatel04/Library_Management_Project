/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dev
 */
import java.awt.*;
import javax.swing.*;
public class Loading extends JFrame implements Runnable{
    private JPanel contentPane;
    private JProgressBar progressBar;
    int s;
    Thread th;
    
    public static void main(String argsp[]){
        new Loading().setVisible(true);
    }
    public void setUploading(){
        setVisible(false);
        th.start();
    }
    public void run(){
        try{
            for(int i=0;i<200;i++){
                s= s+1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if(v<m)
                    progressBar.setValue(progressBar.getValue()+1);
                else{
                    i=201;
                    setVisible(false);
                    new Home().setVisible(true);
                }
                Thread.sleep(50);
            }   
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    public Loading(){
        super("Loading JFrame");
        th = new Thread((Runnable) this);
        
        setBounds(400,50,600,400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel library1 = new JLabel("Smart Library v5.1");
        library1.setForeground(new Color(72,209,204));
        library1.setFont(new Font("Trebuchet MS ",Font.BOLD,35));
        library1.setBounds(130,46,500,35);
        contentPane.add(library1);
        
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma",Font.BOLD,12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130,135,300,25);
        contentPane.add(progressBar);
        
        JLabel label_2 = new JLabel("Please wait...");
        label_2.setFont(new Font("Yu Gothic UI Semibold",Font.BOLD,20));
        label_2.setForeground(new Color(160,82,45));
        label_2.setBounds(200,185,150,20);
        contentPane.add(label_2);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0,0,590,390);
        contentPane.add(panel);
        
        setUploading();
    }
}
