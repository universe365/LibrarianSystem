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

public class DeleteLibrarian extends JFrame{
    static DeleteLibrarian frame;

    private JLabel lblTitle;
    private JLabel lblID;
    private JTextField textID;
    private JButton btnDelete;

    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    frame= new DeleteLibrarian();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public DeleteLibrarian(){



        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-400)/2,
            ( (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-200)/2,
            400, 200
        );
        setResizable(false);

        lblTitle = new JLabel("Delete Librarian");
        lblTitle.setForeground(Color.gray);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));

        lblID = new JLabel("Librarian ID:");

        textID = new JTextField(10);

        btnDelete = new JButton("Delete Librarian");


        btnDelete.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent a){
                int i=0;
                int id = Integer.parseInt(textID.getText());
                if( textID.getText()!="" || textID.getText()!=null){

                    DaoLibrarian librarian = new DaoLibrarian();
                    i = librarian.delete(id);
                    if(i>0){
                        JOptionPane.showMessageDialog(DeleteLibrarian.this, "librarian delete success");
                        textID.setText("");
                    }else{
                        JOptionPane.showMessageDialog(DeleteLibrarian.this, "librarian delete fail");
                    }
                }else{
                    JOptionPane.showMessageDialog(DeleteLibrarian.this,"id cannot be blank");
                }

            }
        });

        
        lblTitle.setBounds(140,20, 150, 20);
        lblID.setBounds(50,60, 100, 20);
        textID.setBounds(150, 60, 200, 20);
        btnDelete.setBounds(130, 100, 140, 30);

        add(lblTitle);
        add(lblID); add(textID);
        add(btnDelete);

    }
}
