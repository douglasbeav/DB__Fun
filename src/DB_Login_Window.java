import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DB_Login_Window {

    private JFrame frame;
    private JTextField usrTxtFld;
    private JPasswordField pswrdFld;
    private JLabel usrLbl;
    private JLabel pswrdLbl;

    public DB_Login_Window() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Login Window");
        frame.setBounds(800, 500, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        usrLbl = new JLabel("User name:");
        usrLbl.setBounds(57, 61, 87, 16);
        frame.getContentPane().add(usrLbl);

        usrTxtFld = new JTextField();
        usrTxtFld.setBounds(156, 56, 203, 36);
        frame.getContentPane().add(usrTxtFld);
        usrTxtFld.setColumns(10);

        pswrdLbl = new JLabel("Password:");
        pswrdLbl.setBounds(63, 112, 87, 16);
        frame.getContentPane().add(pswrdLbl);

        pswrdFld = new JPasswordField();
        pswrdFld.setBounds(156, 107, 203, 36);
        frame.getContentPane().add(pswrdFld);

        JButton connectBtn = new JButton("Connect");
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   String userName = usrTxtFld.getText();
                   String password = new String(pswrdFld.getPassword());
                   if(DB_Statements.checkLogin(userName, password)) {
                       JOptionPane.showMessageDialog(null,
                               "User found.\nAccess granted.");
                   } else {
                       JOptionPane.showMessageDialog(null,
                               "User not found\nAccess denied");
                   }
                   usrTxtFld.setText("");
                   pswrdFld.setText("");
                   usrTxtFld.grabFocus();

               } catch (Exception e1) {
                   JOptionPane.showMessageDialog(null, e1);
               }
            }
        });

        connectBtn.setBounds(148, 172, 117, 29);
        frame.getContentPane().add(connectBtn);

        frame.setVisible(true);
    }
}
