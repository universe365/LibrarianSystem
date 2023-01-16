package librarian.func;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Dao.DaoLibrarian;

public class ViewLibrarian extends JFrame{
    static ViewLibrarian frame;
    private JPanel centerpane;
    private JTable table;
    private String[][] data;
    private String[] column;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    frame= new ViewLibrarian();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewLibrarian(){

       

        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-1000)/2,
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-400)/2,
            1000, 400
        );
        setResizable(false);
        
        centerpane=new JPanel();
        centerpane.setBorder(new EmptyBorder(5,5,5,5));
        centerpane.setLayout(new BorderLayout(0,0));


        JLabel lblTitle = new JLabel("Delete Librarian");
        lblTitle.setForeground(Color.gray);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));

        DaoLibrarian librarian = new DaoLibrarian();
        librarian.view();
        data= librarian.getData();
        column= librarian.getColumn();

        table = new JTable(data, column);
        JScrollPane sp = new JScrollPane(table);
        centerpane.add(sp);

        

        lblTitle.setBounds(450,20, 150, 20);
        centerpane.setBounds(50, 50, 900, 270);


        add(lblTitle);
        add(centerpane, BorderLayout.CENTER);





    }




}