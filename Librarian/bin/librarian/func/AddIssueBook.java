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
import Dao.DaoBooks;
import librarian.LibrarianSuccess;

public class AddIssueBook extends JFrame{
    static AddIssueBook frame;

    private JLabel lblTitle;
    private JLabel lblTag_1;
    private JLabel lblTag_2;
    private JLabel lblTag_3;
    private JLabel lblTag_4;

     //String callno, String name, String author, String publisher, Integer quantity, Integer issued
    private JTextField textfield_1;
    private JTextField textfield_2;
    private JTextField textfield_3;
    private JTextField textfield_4;

    JButton btnAddIssueBook = new JButton("Add Issue Book");
    JButton btnBack = new JButton("Back");

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    frame= new AddIssueBook();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    
    public AddIssueBook(){



        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-450)/2,
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-433)/2,
            450, 433
        );
        setResizable(false);

        lblTitle = new JLabel("Add Issue Book");
        lblTitle.setForeground(Color.gray);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));

        lblTag_1 = new JLabel("book call number:");
        lblTag_2 = new JLabel("Student ID:");
        lblTag_3 = new JLabel("Student name:");
        lblTag_4 = new JLabel("Student contact:");

         //String callno, String name, String author, String publisher, Integer quantity, Integer issued
        textfield_1 = new JTextField(10);
        textfield_2 = new JTextField(10);
        textfield_3 = new JTextField(10);
        textfield_4 = new JTextField(10);

        JButton btnAddIssueBook = new JButton("Add Issue Book");
        JButton btnBack = new JButton("Back");

        btnAddIssueBook.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                int i=0;
                String bookcallno = textfield_1.getText();
                int studentId = Integer.parseInt(textfield_2.getText());
                String studentname = textfield_3.getText();
                int studentcontact = Integer.parseInt(textfield_4.getText());

                DaoIssueBooks issuebook = new DaoIssueBooks(bookcallno, studentId, studentname, studentcontact);
                i = issuebook.add();
                System.out.println("add issue book status: ["+ i +"]");
                int updateStatus=0;
                if(i>0){
                    updateStatus = new DaoBooks().update(bookcallno, "addissue");
                    if(updateStatus>0){
                        JOptionPane.showMessageDialog(AddIssueBook.this, "issue book save success!");
                        textfield_1.setText("");
                        textfield_2.setText("");
                        textfield_3.setText("");
                        textfield_4.setText("");
                    }else{
                        JOptionPane.showMessageDialog(AddIssueBook.this, "book cannot be updated");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog( AddIssueBook.this , "issue book cannot save!");
                }
            }
        });
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                LibrarianSuccess.main(new String[] {});
                frame.dispose();
            }
        });

        lblTitle.setBounds(140,20, 150, 20);
        lblTag_1.setBounds(50,70, 150,20); textfield_1.setBounds(160,70, 250, 20);
        lblTag_2.setBounds(50,110, 150,20); textfield_2.setBounds(160,110, 250, 20);
        lblTag_3.setBounds(50,150, 150,20); textfield_3.setBounds(160,150, 250, 20);
        lblTag_4.setBounds(50,190, 150,20); textfield_4.setBounds(160,190, 250, 20);
        btnAddIssueBook.setBounds(150, 260, 150, 30);
        btnBack.setBounds(280, 330, 100,30);

        add(lblTitle);
        add(lblTag_1); add(textfield_1);
        add(lblTag_2); add(textfield_2);
        add(lblTag_3); add(textfield_3);
        add(lblTag_4); add(textfield_4);
        add(btnAddIssueBook);
        add(btnBack);


    }

}
