package librarian;
import java.awt.EventQueue;
import java.awt.Toolkit;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import librarian.func.AddBook;

import javax.swing.JLabel;  // title
import javax.swing.JButton; //need four

import librarian.func.ViewBook;
import librarian.func.ViewIssueBook;
import librarian.func.AddIssueBook;
import librarian.func.ReturnBook;

public class LibrarianSuccess extends JFrame{

    static LibrarianSuccess frame;
    private JPanel contentPane;    

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    frame = new LibrarianSuccess();
                    frame.setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


    }

    public LibrarianSuccess(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(  ( (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() -450)/2, 
                    ( (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() -433)/2,
                    450, 433 );
        setLayout(null);
        setResizable(false);

        JLabel lblTitle = new JLabel("Librarian Section");
        lblTitle.setBounds(150,20, 200, 30);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTitle.setForeground(Color.gray);

        //buttons
        JButton btnAdd = new JButton("Add Books");
        JButton btnView = new JButton("View Book");
        JButton btnIssue = new JButton("Issue Book");
        JButton btnViewIssue = new JButton("View Issued Books");
        JButton btnReturn = new JButton("Return Book");
        JButton btnLogout = new JButton("Logout");

        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                AddBook.main(new String[]{});
                frame.dispose();
            }
        });

        btnView.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ViewBook.main(new String[]{});
            }
        });

        btnIssue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                AddIssueBook.main(new String[]{});
                frame.dispose();
            }
        });

        btnViewIssue.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ViewIssueBook.main(new String[]{});
            }
        });

        btnReturn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ReturnBook.main(new String[]{});
                frame.dispose();
            }
        });

        btnLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent args0){
                Library.main(new String[]{});
                frame.dispose();
            }
        });

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(6, 1));
        contentPane.setBounds( 100, 70, 250, 250);
        contentPane.add(btnAdd);
        contentPane.add(btnView);
        contentPane.add(btnIssue);
        contentPane.add(btnViewIssue);
        contentPane.add(btnReturn);
        contentPane.add(btnLogout);

        add(lblTitle);
        add(contentPane);

    }








}