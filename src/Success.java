import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Success implements Runnable {

    private JFrame frmSuccess;
    
    public void run() {
		try {
			Success window = new Success();
			window.frmSuccess.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	Success() {
            SuccessGUI();
    }  // Success() 

	public void SuccessGUI() {
        frmSuccess = new JFrame();
        frmSuccess.setTitle("Successful Transaction!");
        frmSuccess.setBackground(new Color(128, 0, 0));
        frmSuccess.getContentPane().setBackground(new Color(255, 102, 0));
        frmSuccess.setBounds(100, 100, 400, 500);
        frmSuccess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSuccess.getContentPane().setLayout(null);

        JLabel lblLogo = new JLabel("logo");
		lblLogo.setForeground(new Color(128, 0, 0));
		lblLogo.setBackground(new Color(128, 0, 0));
		lblLogo.setIcon(new ImageIcon(Transaction.class.getResource("/images/logo.jpg")));
		lblLogo.setBounds(20, 10, 50, 64);
		frmSuccess.getContentPane().add(lblLogo);

		JPanel pnlReceipt = new JPanel();
		pnlReceipt.setBounds(64, 110, 260, 220);
		pnlReceipt.setLayout(null);
		pnlReceipt.setBackground(Color.white);  

        JLabel lblRefnum = new JLabel("Reference No.: " + Home.refnum);
		lblRefnum.setForeground(new Color(0, 0, 0));
		lblRefnum.setHorizontalAlignment(SwingConstants.LEADING);
		lblRefnum.setBounds(20, 10, 200, 24);
		pnlReceipt.add(lblRefnum);

        JLabel lblBiller = new JLabel("Biller: " + Home.biller);
		lblBiller.setForeground(new Color(0, 0, 0));
		lblBiller.setHorizontalAlignment(SwingConstants.LEADING);
		lblBiller.setBounds(20, 30, 200, 24);
		pnlReceipt.add(lblBiller);

        JLabel lblAcctnum = new JLabel("Account No.: " + Home.acctnum);
		lblAcctnum.setForeground(new Color(0, 0, 0));
		lblAcctnum.setHorizontalAlignment(SwingConstants.LEADING);
		lblAcctnum.setBounds(20, 50, 200, 24);
		pnlReceipt.add(lblAcctnum);

        JLabel lblAcctname = new JLabel("Account Name: " + Home.acctname);
		lblAcctname.setForeground(new Color(0, 0, 0));
		lblAcctname.setHorizontalAlignment(SwingConstants.LEADING);
		lblAcctname.setBounds(20, 70, 200, 24);
		pnlReceipt.add(lblAcctname);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();

        JLabel lblTransdate = new JLabel("Transaction Date: " + formatter.format(date));
		lblTransdate.setForeground(new Color(0, 0, 0));
		lblTransdate.setHorizontalAlignment(SwingConstants.LEADING);
		lblTransdate.setBounds(20, 90, 200, 24);
		pnlReceipt.add(lblTransdate);

        JLabel lblAmount = new JLabel("Amount: " + Home.total);
		lblAmount.setForeground(new Color(0, 0, 0));
		lblAmount.setHorizontalAlignment(SwingConstants.LEADING);
		lblAmount.setBounds(20, 110, 120, 24);
		pnlReceipt.add(lblAmount);

		frmSuccess.add(pnlReceipt);

        JButton btnHome = new JButton("Back to Home");
        btnHome.setBackground(new Color(255, 255, 255));
        btnHome.setBounds(230, 400, 120, 23);
        frmSuccess.getContentPane().add(btnHome);
        btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				Main.ActivityMain();
				frmSuccess.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});		
	} //public void SuccessGUI()
}//public class Success implements Runnable
