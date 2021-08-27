import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Account implements Runnable {

    private JFrame frmAccount;
    
    public void run() {
		try {
			Account window = new Account();
			window.frmAccount.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	Account() {
            AccountGUI();
    }  // Account() 

	public void AccountGUI() {
        frmAccount = new JFrame();
        frmAccount.setTitle("Account Details");
        frmAccount.setBackground(new Color(128, 0, 0));
        frmAccount.getContentPane().setBackground(new Color(255, 102, 0));
        frmAccount.setBounds(100, 100, 400, 500);
        frmAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAccount.getContentPane().setLayout(null);

        JLabel lblLogo = new JLabel("logo");
		lblLogo.setForeground(new Color(128, 0, 0));
		lblLogo.setBackground(new Color(128, 0, 0));
		lblLogo.setIcon(new ImageIcon(Transaction.class.getResource("/images/logo.jpg")));
		lblLogo.setBounds(20, 10, 50, 64);
		frmAccount.getContentPane().add(lblLogo);

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JLabel lblAcctNum = new JLabel("Account Number:");
		lblAcctNum.setForeground(new Color(0, 0, 0));
		lblAcctNum.setHorizontalAlignment(SwingConstants.LEADING);
		lblAcctNum.setBounds(60, 90, 100, 23);
		frmAccount.getContentPane().add(lblAcctNum);

        JTextField txtAcctNum = new JTextField();
        txtAcctNum.setBorder(border);
		txtAcctNum.setHorizontalAlignment(SwingConstants.LEADING);
		txtAcctNum.setBounds(162, 90, 160, 24);
		frmAccount.getContentPane().add(txtAcctNum);
		txtAcctNum.setText(Home.acctnum);

        JLabel lblAcctName = new JLabel("Account Name:");
		lblAcctName.setForeground(new Color(0, 0, 0));
		lblAcctName.setHorizontalAlignment(SwingConstants.LEADING);
		lblAcctName.setBounds(60, 130, 86, 23);
		frmAccount.getContentPane().add(lblAcctName);

        JTextField txtAcctName= new JTextField();
        txtAcctName.setBorder(border);
		txtAcctName.setHorizontalAlignment(SwingConstants.LEADING);
		txtAcctName.setBounds(162, 130, 160, 24);
		frmAccount.getContentPane().add(txtAcctName);
		txtAcctName.setText(Home.acctname);

        JLabel lblContactNum = new JLabel("Contact Number:");
		lblContactNum.setForeground(new Color(0, 0, 0));
		lblContactNum.setHorizontalAlignment(SwingConstants.LEADING);
		lblContactNum.setBounds(60, 170, 96, 23);
		frmAccount.getContentPane().add(lblContactNum);

        JTextField txtContactNum = new JTextField();
        txtContactNum.setBorder(border);
		txtContactNum.setHorizontalAlignment(SwingConstants.LEADING);
		txtContactNum.setBounds(162, 170, 160, 24);
		frmAccount.getContentPane().add(txtContactNum);
		txtContactNum.setText(Home.contact);

        JLabel lblAddress = new JLabel("Present Address:");
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setHorizontalAlignment(SwingConstants.LEADING);
		lblAddress.setBounds(60, 210, 100, 23);
		frmAccount.getContentPane().add(lblAddress);

        JTextArea txtAddress = new 	JTextArea();
        txtAddress.setBorder(border);
        txtAddress.setLineWrap(true);
		txtAddress.setBounds(60, 240, 260, 50);
		frmAccount.getContentPane().add(txtAddress);
		txtAddress.setText(Home.address);

        JButton btnBack1 = new JButton("Back");
        btnBack1.setBackground(new Color(255, 255, 255));
        btnBack1.setBounds(60, 400, 89, 23);
        frmAccount.getContentPane().add(btnBack1);
        btnBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				Main.ActivityTransaction();
				frmAccount.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});

        JButton btnNext1 = new JButton("Next");
        btnNext1.setBackground(new Color(255, 255, 255));
        btnNext1.setBounds(230, 400, 89, 23);
        frmAccount.getContentPane().add(btnNext1);
        btnNext1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				Home.acctnum = txtAcctNum.getText().trim();
				Home.acctname = txtAcctName.getText().trim();
				Home.contact = txtContactNum.getText().trim();
				Home.address = txtAddress.getText().trim();
				Main.ActivityPayment();
				frmAccount.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});
		
	} //public void AccountGUI()
}//public class Account implements Runnable
