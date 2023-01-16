package librarian;
import java.awt.EventQueue;
import java.awt.Toolkit;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;




public class Library extends JFrame{

    static Library frame;
    private JPanel contentPane;

    private JLabel lblLibraryManagement;
    private JButton btnLibraryLogin;
    private JButton btnAdminLogin ;

    /**
     * Launch the application
     */
     public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    frame = new Library();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
     }

     /**
      * create the frame
      */
     public Library(){
        //frame default settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-450)/2,
                  (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-300)/2,
                  450,300);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);

        //Label for title
        lblLibraryManagement = new JLabel("Library Management");
        lblLibraryManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLibraryManagement.setForeground(Color.GRAY);

        //create bottons for AdminLogin and LibraryLogin
        btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btnLibraryLogin = new JButton("Library Login");
        btnLibraryLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        //Add actionlistener for two buttons with lamda
        btnAdminLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                //add AdminLogin.java here
                AdminLogin.main(new String[]{});
                frame.dispose();
            }
        });
        btnLibraryLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                //add LibraryLogin.java here
                // call main method in LibraryLogin
                LibrarianLogin.main(new String[]{});
                frame.dispose();
            }
        });

        // set GoupLayout and add contentPane here to manage the format
            //1. create grouplayout and add contentPane here
            //2. set horizon group
            //3. set verical group
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        // add title label here
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(125)
                            .addComponent(lblLibraryManagement))
                        // add btns here
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(140)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(btnLibraryLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdminLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                    .addContainerGap(95, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup( gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblLibraryManagement)
                    .addGap(32)
                    .addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(btnLibraryLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)
                )
        );
        contentPane.setLayout(gl_contentPane);
     }





}

