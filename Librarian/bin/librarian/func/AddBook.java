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

import librarian.LibrarianSuccess;
import Dao.DaoBooks;

public class AddBook extends JFrame{
    static AddBook frame;

    private  JLabel lblTitle;
    private JLabel lblTag_1;
    private JLabel lblTag_2 ;
    private JLabel lblTag_3 ;
    private JLabel lblTag_4 ;
    private JLabel lblTag_5 ;

        //String callno, String name, String author, String publisher, Integer quantity, Integer issued
    private JTextField textfield_1;
    private JTextField textfield_2;
    private JTextField textfield_3;
    private JTextField textfield_4;
    private JTextField textfield_5;

    private JButton btnAddBook;
    private JButton btnBack;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    frame= new AddBook();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    
    public AddBook(){


        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-450)/2,
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-433)/2,
            450, 433
        );
        setResizable(false);
        
        lblTitle = new JLabel("Add Book");
        lblTitle.setForeground(Color.gray);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));

        lblTag_1 = new JLabel("call number:");
        lblTag_2 = new JLabel("name:");
        lblTag_3 = new JLabel("author:");
        lblTag_4 = new JLabel("publisher:");
        lblTag_5 = new JLabel("quantity:");

        //String callno, String name, String author, String publisher, Integer quantity, Integer issued
        textfield_1 = new JTextField(10);
        textfield_2 = new JTextField(10);
        textfield_3 = new JTextField(10);
        textfield_4 = new JTextField(10);
        textfield_5 = new JTextField(10);

        textfield_1.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_2.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_3.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_4.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_5.setFont(new Font("Arial", Font.PLAIN, 15));

        btnAddBook = new JButton("Add Book");
        btnBack = new JButton("Back");

        btnAddBook.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                int i=0;
                String callno = textfield_1.getText();
                String name = textfield_2.getText();
                String author = textfield_3.getText();
                String publisher = textfield_4.getText();
                int quantity = Integer.parseInt(textfield_5.getText());

                DaoBooks daobook = new DaoBooks(callno, name, author, publisher, quantity);
                i= daobook.add();

                if(i>0){
                    JOptionPane.showMessageDialog(AddBook.this, "Book add success!");
                    textfield_1.setText("");
                    textfield_2.setText("");
                    textfield_3.setText("");
                    textfield_4.setText("");
                    textfield_5.setText("");
                }else{
                    JOptionPane.showMessageDialog( AddBook.this , "book cannot save!");
                }
            }
        });
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                LibrarianSuccess.main(new String[] {});
                frame.dispose();
            }
        });

        lblTitle.setBounds(170,20, 150, 20);
        lblTag_1.setBounds(50,70, 150,20); textfield_1.setBounds(150,70, 250, 20);
        lblTag_2.setBounds(50,100, 150,20); textfield_2.setBounds(150,100, 250, 20);
        lblTag_3.setBounds(50,130, 150,20); textfield_3.setBounds(150,130, 250, 20);
        lblTag_4.setBounds(50,160, 150,20); textfield_4.setBounds(150,160, 250, 20);
        lblTag_5.setBounds(50,190, 150,20); textfield_5.setBounds(150,190, 250, 20);
        btnAddBook.setBounds(170, 270, 100, 30);
        btnBack.setBounds(280, 330, 100,30);

        add(lblTitle);
        add(lblTag_1); add(textfield_1);
        add(lblTag_2); add(textfield_2);
        add(lblTag_3); add(textfield_3);
        add(lblTag_4); add(textfield_4);
        add(lblTag_5); add(textfield_5);
        add(btnAddBook);
        add(btnBack);

    }
}
