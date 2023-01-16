package librarian;
import java.awt.EventQueue;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class AdminLogin extends JFrame{
    static AdminLogin frame;
    private JTextField textfield;
    private JPasswordField passwordfield;


    /**
     * Launch the application
     */
    public static void main(String[] args){
        EventQueue.invokeLater( new Runnable(){
            public void run(){
                try{
                    frame = new AdminLogin();
                    frame.setVisible(true);                
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create Frame
     */
    AdminLogin(){
        //init frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(  ((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-450)/2, 
                    ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-300)/2,
                    450,300 );
        setLayout(null);
        setResizable(false);

        //Title
        JLabel lblAdminLoginForm = new JLabel("Admin Login Form");
        lblAdminLoginForm.setForeground(Color.gray );
        lblAdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblUserName = new JLabel("User name:");
        JLabel lblPassword = new JLabel("Password:");

        textfield = new JTextField(10);
        passwordfield = new JPasswordField(10);

        JButton btnLogin = new JButton("Login");

        JPanel control = new JPanel();
        control.setLayout(new GridLayout(1,1));
        control.setBounds(190, 180, 70, 30);
        control.add(btnLogin);

        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                //get name and password value
                String username = textfield.getText();
                String password = String.valueOf(passwordfield.getPassword());
                //if username and password exist -> AdminSuccess
                //if not exist -> jump out message
                if( username.equals("admin") && password.equals("admin123") ){
                    // call AdminSuccess
                    AdminSuccess.main(new String[]{});
                    frame.dispose();
                }else{
                    JOptionPane.showMessageDialog(AdminLogin.this, "Username or Password not exist", "Login Error!", JOptionPane.ERROR_MESSAGE);
                    //clear the space
                    textfield.setText("");
                    passwordfield.setText("");
                }

            }
        });

        lblAdminLoginForm.setBounds( 150, 10, 250, 20 );
        
        lblUserName.setBounds( 100, 70, 100, 25);
        textfield.setBounds( 200, 70, 150, 25);

        lblPassword.setBounds(100, 100, 100, 25);
        passwordfield.setBounds(200, 100, 150, 25);

        add(lblAdminLoginForm);
        add(lblUserName);
        add(textfield);
        add(lblPassword);
        add(passwordfield);
        add(control);

    }
    
}
