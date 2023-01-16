package librarian.func;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import Dao.DaoIssueBooks;
import librarian.LibrarianSuccess;

public class ReturnBook extends JFrame{
    static ReturnBook frame;

    private JLabel lblTitle;
    private JLabel lblStudentID ;
    private JLabel lblCallNo;

    private JTextField textStudentID;
    private JTextField textCallNo;

    private JButton btnReturn;
    private JButton btnBack;
        

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    frame= new ReturnBook();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    
    public ReturnBook(){



        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-450)/2,
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-433)/2,
            450, 433
        );
        setResizable(false);

        lblTitle = new JLabel("Return Book");
        lblTitle.setForeground(Color.gray);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));

        // return by studentId & callno
        lblStudentID = new JLabel("Student ID:");
        lblCallNo = new JLabel("Coll no:");

        textStudentID = new JTextField(10);
        textCallNo = new JTextField(10);

        btnReturn = new JButton("Return Book");
        btnBack = new JButton("Back");


        btnReturn.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent a){
                int status=0;
                String bookcallno = textCallNo.getText();
                int studentid = Integer.parseInt( textStudentID.getText() );

                DaoIssueBooks issuebook = new DaoIssueBooks();
                status = issuebook.delete(bookcallno, studentid);
                
                if(status>0){
                    JOptionPane.showMessageDialog(ReturnBook.this, "Return book success!");
                    textCallNo.setText("");
                    textStudentID.setText("");
                }else{
                    JOptionPane.showMessageDialog(ReturnBook.this, "Return book failed");
                }

            }
        });

        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LibrarianSuccess.main(new String[] {});
                frame.dispose();
            }
        });


        lblTitle.setBounds(140,20, 150, 20);
        lblStudentID.setBounds(75, 100, 100, 20);
        textStudentID.setBounds(180, 100, 200, 20);
        lblCallNo.setBounds(75,140, 100, 20);
        textCallNo.setBounds(180, 140, 200, 20);
        btnReturn.setBounds(170, 200, 120, 30);
        btnBack.setBounds(280, 330, 100,30);

        add(lblTitle);
        add(lblStudentID); add(textStudentID);
        add(lblCallNo); add(textCallNo);
        add(btnReturn);
        add(btnBack);
        
    }
}
