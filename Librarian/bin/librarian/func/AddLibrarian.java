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

import Dao.DaoLibrarian;
import librarian.AdminSuccess;

public class AddLibrarian extends JFrame{
    static AddLibrarian frame;

    private JLabel lblTitle;
    private JLabel lblTag_1;
    private JLabel lblTag_2;
    private JLabel lblTag_3;
    private JLabel lblTag_4;
    private JLabel lblTag_5;
    private JLabel lblTag_6;

    private JTextField textfield_1;
    private JTextField textfield_2;
    private JTextField textfield_3;
    private JTextField textfield_4;
    private JTextField textfield_5;
    private JTextField textfield_6;




    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    frame=new AddLibrarian();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        
    }


    public AddLibrarian(){

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-450)/2,
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-433)/2,
            450, 433
        );
        setResizable(false);

        lblTitle = new JLabel("Add Librarian");
        lblTitle.setForeground(Color.gray);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));

        lblTag_1 = new JLabel("name:");
        lblTag_2 = new JLabel("password:");
        lblTag_3 = new JLabel("email:");
        lblTag_4 = new JLabel("address:");
        lblTag_5 = new JLabel("city");
        lblTag_6 = new JLabel("contact:");

        textfield_1 = new JTextField(10);
        textfield_2 = new JTextField(10);
        textfield_3 = new JTextField(10);
        textfield_4 = new JTextField(10);
        textfield_5 = new JTextField(10);
        textfield_6 = new JTextField(10);

        textfield_1.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_2.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_3.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_4.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_5.setFont(new Font("Arial", Font.PLAIN, 15));
        textfield_6.setFont(new Font("Arial", Font.PLAIN, 15));

        JButton btnAddLibrarian = new JButton("Add Librarian");
        JButton btnBack = new JButton("Back");

        btnAddLibrarian.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                int i=0;
                String name= textfield_1.getText();
                String password= textfield_2.getText();
                String email= textfield_3.getText();
                String address= textfield_4.getText();
                String city= textfield_5.getText();
                int contact= Integer.parseInt(textfield_6.getText());

                DaoLibrarian librarian = new DaoLibrarian(name, password, email, address, city, contact);
                i = librarian.add();

                if(i>0){
                    JOptionPane.showMessageDialog(AddLibrarian.this, "add librarian success");
                    textfield_1.setText("");
                    textfield_2.setText("");
                    textfield_3.setText("");
                    textfield_4.setText("");
                    textfield_5.setText("");
                    textfield_6.setText("");

                    AdminSuccess.main(new String[]{});
                    frame.dispose();
                }else{
                    JOptionPane.showMessageDialog( AddLibrarian.this , "book cannot save!");
                }
            }
        });
        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                AdminSuccess.main(new String[] {});
                frame.dispose();
            }
        });


        lblTitle.setBounds(170,20, 150, 20);
        lblTag_1.setBounds(50,70, 150,20); textfield_1.setBounds(150,70, 250, 20);
        lblTag_2.setBounds(50,100, 150,20); textfield_2.setBounds(150,100, 250, 20);
        lblTag_3.setBounds(50,130, 150,20); textfield_3.setBounds(150,130, 250, 20);
        lblTag_4.setBounds(50,160, 150,20); textfield_4.setBounds(150,160, 250, 20);
        lblTag_5.setBounds(50,190, 150,20); textfield_5.setBounds(150,190, 250, 20);
        lblTag_6.setBounds(50, 220, 150, 20); textfield_6.setBounds(150, 220, 250, 20);
        btnAddLibrarian.setBounds(170, 270, 120, 30);
        btnBack.setBounds(280, 330, 100,30);

        add(lblTitle);
        add(lblTag_1); add(textfield_1);
        add(lblTag_2); add(textfield_2);
        add(lblTag_3); add(textfield_3);
        add(lblTag_4); add(textfield_4);
        add(lblTag_5); add(textfield_5);
        add(lblTag_6); add(textfield_6);
        add(btnAddLibrarian);
        add(btnBack);


    }



}
