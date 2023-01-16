package librarian;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import librarian.func.AddLibrarian;
import librarian.func.DeleteLibrarian;
import librarian.func.ViewLibrarian;

public class AdminSuccess extends JFrame{

    static AdminSuccess frame;
    private JPanel contentPane;

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    frame = new AdminSuccess();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    AdminSuccess(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(  ( (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() -450)/2,
                    ( (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() -433)/2,
                    450, 433 );
        setLayout(null);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new GridLayout(4, 1));
        contentPane.setBounds(50,60, 330, 270);

        JLabel lblTitle = new JLabel("Admin Section");
         lblTitle.setBounds(150, 20, 200, 30);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTitle.setForeground(Color.GRAY);
       

        JButton btnAdd = new JButton("Add Librarian");
        JButton btnView = new JButton("View Librarian");
        JButton btnDelete = new JButton("Delete Librarian");
        JButton btnLogout = new JButton("Logout");

        btnAdd.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                AddLibrarian.main(new String[]{});
                frame.dispose();
            }
        } );

        btnView.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                ViewLibrarian.main(new String[]{});
            }
        });

        btnDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                DeleteLibrarian.main(new String[]{});
            }
        });

        btnLogout.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Library.main(new String[]{});
                frame.dispose();
            }
        });

        contentPane.add(btnAdd);
        contentPane.add(btnView);
        contentPane.add(btnDelete);
        contentPane.add(btnLogout);
        
        add(lblTitle);
        add(contentPane);

    }





        
}