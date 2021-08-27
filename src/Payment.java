import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Payment implements Runnable {

    private JFrame frmPayment;
    private String paytype;
    private float fltAmtdue;
    private float fltTotal;
    private int intInvoice;
    private int intAcctnum;

    private Connection objConn;
	private boolean boolConn2Db;
	private Statement objSQLQuery;
    
    public void run() {
		try {
			Payment window = new Payment();
			window.frmPayment.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	Payment() {
	    String strDriver = "com.mysql.cj.jdbc.Driver";
        String strConn = "jdbc:mysql://localhost:3307/improject";
        String strUser = "micay";
        String strPass = "password123";

        boolConn2Db = false;

        try {        
            Class.forName(strDriver);
            objConn = DriverManager.getConnection(strConn, strUser, strPass);   
            objSQLQuery = objConn.createStatement(); 
             
            boolConn2Db = true;
        } catch (Exception objEx) {
            System.out.println("Problem retrieving information..");
            System.out.println(objEx);
        }  //try

        if (boolConn2Db) {
            PaymentGUI();
        }  //if (boolConn2Db)
    }  // Payment() 

	public void PaymentGUI() {
        frmPayment = new JFrame();
        frmPayment.setTitle("Payment Details");
        frmPayment.setBackground(new Color(128, 0, 0));
        frmPayment.getContentPane().setBackground(new Color(255, 102, 0));
        frmPayment.setBounds(100, 100, 400, 500);
        frmPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPayment.getContentPane().setLayout(null);

        JLabel lblLogo = new JLabel("logo");
		lblLogo.setForeground(new Color(128, 0, 0));
		lblLogo.setBackground(new Color(128, 0, 0));
		lblLogo.setIcon(new ImageIcon(Transaction.class.getResource("/images/logo.jpg")));
		lblLogo.setBounds(20, 10, 50, 64);
		frmPayment.getContentPane().add(lblLogo);

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JLabel lblPaymentType = new JLabel("Payment Type:");
		lblPaymentType.setForeground(new Color(0, 0, 0));
		lblPaymentType.setHorizontalAlignment(SwingConstants.LEADING);
		lblPaymentType.setBounds(60, 90, 100, 23);
		frmPayment.getContentPane().add(lblPaymentType);

        JRadioButton rbtnCash = new JRadioButton("Cash");
        rbtnCash.setBounds(160, 90, 60, 23);
		frmPayment.getContentPane().add(rbtnCash);

        JRadioButton rbtnCheck = new JRadioButton("Check");
        rbtnCheck.setBounds(226, 90, 68, 23);
		frmPayment.getContentPane().add(rbtnCheck);

        JRadioButton rbtnCredit = new JRadioButton("Credit Card");
        rbtnCredit.setBounds(160, 120, 100, 23);
		frmPayment.getContentPane().add(rbtnCredit);

        ButtonGroup rbuttons = new ButtonGroup();
        rbuttons.add(rbtnCash);
        rbuttons.add(rbtnCheck);
        rbuttons.add(rbtnCredit);

        JLabel lblAmount = new JLabel("Enter Amount:");
		lblAmount.setForeground(new Color(0, 0, 0));
		lblAmount.setHorizontalAlignment(SwingConstants.LEADING);
		lblAmount.setBounds(190, 180, 90, 23);
		frmPayment.getContentPane().add(lblAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setBorder(border);
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setBounds(180, 210, 100, 30);
		frmPayment.getContentPane().add(txtAmount);

        JButton btnClear = new JButton("Clear");
        btnClear.setBackground(new Color(255, 255, 255));
        btnClear.setBounds(100, 214, 68, 23);
        frmPayment.getContentPane().add(btnClear);
        btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				txtAmount.setText(null);
			} //public void actionPerformed(ActionEvent objAE)
		});

        JButton btnBack2 = new JButton("Back");
        btnBack2.setBackground(new Color(255, 255, 255));
        btnBack2.setBounds(60, 300, 89, 23);
        frmPayment.getContentPane().add(btnBack2);
        btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				Main.ActivityAccount();
				frmPayment.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(new Color(255, 255, 255));
        btnConfirm.setBounds(230, 300, 89, 23);
        frmPayment.getContentPane().add(btnConfirm);
        btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
                Home.total = txtAmount.getText().trim();
                fltTotal = Float.parseFloat(Home.total);
                fltAmtdue = Float.parseFloat(Home.amtdue);
                intInvoice = Integer.parseInt(Home.invoice.trim());
                intAcctnum = Integer.parseInt(Home.acctnum);

                if(rbtnCash.isSelected()){    
                    paytype = "Cash";
                    System.out.println(paytype);    
                }    
                if(rbtnCheck.isSelected()){    
                    paytype = "Check"; 
                    System.out.println(paytype);  
                }  
                if(rbtnCredit.isSelected()){    
                    paytype = "Credit Card";
                    System.out.println(paytype);   
                }

                try {
                    String strSQLInsert = "INSERT INTO tbltransaction " + "(Refnum, Custname, Transtype, Transdate, Invoicenum, Paytype, Total) " + 
							"VALUES " + "(" + Home.refnum + ", '" + Home.custname + "', '" + Home.transtype + "', CURDATE(), " + 
                            intInvoice + ", '" + paytype + "', " + fltTotal + ");"; 
            
					objSQLQuery.executeUpdate(strSQLInsert);
					System.out.println("Rows inserted on the table..");
				} catch (Exception objEx) {
					System.out.println("Problem adding information..");
					System.out.println(objEx);

				} 
                
                try {    
                    String strSQLInsert = "INSERT INTO tblinvoice " + "(Invoicenum, Acctnum, Biller, Stmdate, Duedate, Amtdue) " + 
							"VALUES " + "(" + intInvoice + ", " + intAcctnum + ", '" + Home.biller + "', STR_TO_DATE('" +
                            Home.stmdate + "', '%d/%m/%Y'), " + "STR_TO_DATE('" + Home.duedate + "', '%d/%m/%Y'), " + fltAmtdue + ");"; 
            
					objSQLQuery.executeUpdate(strSQLInsert);

					System.out.println("Rows inserted on the table..");
				} catch (Exception objEx) {
					System.out.println("Problem adding information..");
					System.out.println(objEx);

				} 
                
                try {
                    String strSQLInsert = "INSERT INTO tblaccount " + "(Acctnum, Acctname, Address, Contact) " + 
							"VALUES " + "(" + intAcctnum + ", '" + Home.acctname + "', '" + Home.address + "', '" + Home.contact + "');"; 
            
					objSQLQuery.executeUpdate(strSQLInsert);

					System.out.println("Rows inserted on the table..");
				} catch (Exception objEx) {
					System.out.println("Problem adding information..");
					System.out.println(objEx);

				} finally {
					if (objConn != null) {
						try {
							objConn.close();
						} catch (Exception objEx) {
							System.out.println("Problem closing the database!");
							System.out.println(objEx.toString());
						}  //try
					}  //if (objConn != null)
				}  //try

				Main.ActivitySuccess();
				frmPayment.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});
		
	} //public void PaymentGUI()
}//public class Payment implements Runnable

