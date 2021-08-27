import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;

public class AdminLogin implements Runnable {

    private JFrame frmAdmin;

    public void run() {
		try {
			AdminLogin window = new AdminLogin();
			window.frmAdmin.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	AdminLogin() {
            AdminLoginGUI();
    }  // AdminLogin() 

	public void AdminLoginGUI() {
        frmAdmin = new JFrame();
        frmAdmin.setTitle("Admin Login");
        frmAdmin.setBackground(new Color(128, 0, 0));
        frmAdmin.getContentPane().setBackground(new Color(255, 102, 0));
        frmAdmin.setBounds(100, 100, 400, 500);
        frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdmin.getContentPane().setLayout(null);

        JLabel lblback = new JLabel("back");
		lblback.setIcon(new ImageIcon(AdminLogin.class.getResource("/images/back.png")));
		lblback.setBounds(20, 20, 30, 30);
		frmAdmin.getContentPane().add(lblback);
        lblback.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent objME) {
				Main.ActivityMain();
				frmAdmin.dispose();                		
			}  //public void mouseClicked(MouseEvent objME)
		}); //txtEmail.addMouseListener(new MouseAdapter()
		
        JLabel lblKeyIcon = new JLabel("pwIcon");
		lblKeyIcon.setIcon(new ImageIcon(AdminLogin.class.getResource("/images/key.png")));
		lblKeyIcon.setBounds(80, 246, 25, 25);
		frmAdmin.getContentPane().add(lblKeyIcon);
		
		JLabel lblEmailIcon = new JLabel("userIcon");
		lblEmailIcon.setIcon(new ImageIcon(AdminLogin.class.getResource("/images/email.png")));
		lblEmailIcon.setBounds(80, 185, 25, 25);
		frmAdmin.getContentPane().add(lblEmailIcon);

        JTextField txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setText("  User");
		txtEmail.setBounds(130, 179, 180, 35);
		frmAdmin.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JPasswordField pwPassword = new JPasswordField();
		pwPassword.setHorizontalAlignment(SwingConstants.LEFT);
		pwPassword.setText(" Password");
		pwPassword.setColumns(10);
		pwPassword.setBounds(130, 240, 180, 36);
		frmAdmin.getContentPane().add(pwPassword);

        txtEmail.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent objME) {
				txtEmail.setText(null);                		
			}  //public void mouseClicked(MouseEvent objME)
		}); //txtEmail.addMouseListener(new MouseAdapter()

		pwPassword.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent objME) {
				pwPassword.setText(null); 		
			}  //public void mouseClicked(MouseEvent objME)
		}); //pwPassword.addMouseListener(new MouseAdapter()

		pwPassword.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if (pwPassword.getText().equals("Password")){
					pwPassword.setEchoChar('*');
					pwPassword.setText("");
				} //if (pwPassword.getText().equals("Password"))
				else {
					pwPassword.selectAll();
				} //else
			} //public void focusGained(FocusEvent arg0)
		}); //pwPassword.addFocusListener(new FocusAdapter()
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setBounds(160, 380, 89, 23);
		frmAdmin.getContentPane().add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				String email = txtEmail.getText().trim();
				String pw = pwPassword.getText().trim();
				if((email.equals("admin")) & (pw.equals("password"))){
					Main.ActivityRecords();
					frmAdmin.dispose();
				}
			} //public void actionPerformed(ActionEvent objAE)
		});

	} //public void AdminLoginGUI()
}//public class AdminLogin implements Runnable