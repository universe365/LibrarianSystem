package librarian;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Dao.DaoLibrarian;

public class LibrarianLogin extends JFrame{
    static LibrarianLogin frame;
    private JPanel contentPane;
    private JLabel title;
    private int screenX = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-450)/2;
    private int screenY = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-300)/2;

    private JLabel username;
    private JLabel password;
    private JTextField textfield;
    private JPasswordField passwordfield;

    public static void main(String[] args){
        EventQueue.invokeLater(
            new Runnable(){
                public void run(){
                    try{
                        frame = new LibrarianLogin();
                        frame.setVisible(true);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        );
    }

    LibrarianLogin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds( screenX,
                   screenY,
                   450, 300 );
        setResizable(false);

        title = new JLabel("Librarian Login");
        title.setFont(new Font("Tahoma", Font.PLAIN, 18));
        title.setForeground(Color.gray);

        username = new JLabel("username:");
        password = new JLabel("password");
        username.setFont(new Font("Tahoma", Font.PLAIN, 15));
        password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        textfield = new JTextField();
        passwordfield = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String name = textfield.getText();
                String password = String.valueOf(passwordfield.getPassword());
                // System.out.println(name+" "+ password);
                if( !(name.equals("")||name==null || password==null || String.valueOf(passwordfield.getPassword()).equals("")) ){
                    DaoLibrarian librarian = new DaoLibrarian();
                    boolean execute = librarian.verify(name, password);
                    if(execute){
                        LibrarianSuccess.main(new String[] {});
                        frame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(LibrarianLogin.this, "username or password not exist");
                    }
                }else{ JOptionPane.showMessageDialog(LibrarianLogin.this, "username and password cannot be blank"); }

            }
        });

        contentPane = new JPanel();
        GroupLayout layout = new GroupLayout(contentPane);

        // layout.setHorizontalGroup(
            
        //     layout.createParallelGroup(Alignment.TRAILING)
        //         .addGroup( layout.createSequentialGroup()
        //             .addGroup( layout.createParallelGroup(Alignment.LEADING)
        //                 .addGroup( layout.createSequentialGroup()
        //                     .addGap(140)
        //                     .addComponent(title))
                            
        //                 .addGroup( layout.createSequentialGroup()
        //                     .addGap(70)
        //                     .addGroup( layout.createParallelGroup(Alignment.LEADING)
        //                         .addComponent(username)
        //                         .addComponent(password))
                            
        //                     .addGap(30)
        //                     .addGroup( layout.createParallelGroup(Alignment.LEADING)
        //                         .addComponent(textfield, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        //                         .addComponent(passwordfield))))
        //         ) 
        // );

        layout.setHorizontalGroup(

            layout.createParallelGroup(Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150)
                            .addComponent(title))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100)
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(username)
                                .addComponent(password))
                            
                            .addGap(10)
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(passwordfield)
                                .addComponent(textfield, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                )))
                        .addContainerGap(107, Short.MAX_VALUE) )       
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(140, Short.MAX_VALUE)
                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                        .addGap(151))
        );


        layout.setVerticalGroup(
           
           layout.createParallelGroup(Alignment.LEADING)

                .addGroup( layout.createSequentialGroup()
                    .addGap(40)
                    .addComponent(title)

                    .addGap(40)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        
                        .addComponent(username)
                        .addComponent(textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        
                        .addComponent(password)
                        .addComponent(passwordfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addComponent(btnLogin)
                )
            


        );






        contentPane.setLayout(layout);
        add(contentPane);

    }


}