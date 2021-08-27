import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Transaction implements Runnable {

    private JFrame frmTransaction;

	private Connection objConn;
	private boolean boolConn2Db;
	private Statement objSQLQuery;
	private ResultSet objResultSet;
    
    public void run() {
		try {
			Transaction window = new Transaction();
			window.frmTransaction.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	Transaction() {
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
            TransactionGUI();
        }  //if (boolConn2Db)
    }  // Transaction() 

	public void TransactionGUI() {
        frmTransaction = new JFrame();
        frmTransaction.setTitle("Transaction Details");
        frmTransaction.setBackground(new Color(128, 0, 0));
        frmTransaction.getContentPane().setBackground(new Color(255, 102, 0));
        frmTransaction.setBounds(100, 100, 400, 500);
        frmTransaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTransaction.getContentPane().setLayout(null);

		JLabel lblLogo = new JLabel("logo");
		lblLogo.setForeground(new Color(128, 0, 0));
		lblLogo.setBackground(new Color(128, 0, 0));
		lblLogo.setIcon(new ImageIcon(Transaction.class.getResource("/images/logo.jpg")));
		lblLogo.setBounds(20, 10, 50, 64);
		frmTransaction.getContentPane().add(lblLogo);

		Border border = BorderFactory.createLineBorder(Color.BLACK);

        JLabel lblCustName = new JLabel("Customer Name:");
		lblCustName.setForeground(new Color(0, 0, 0));
		lblCustName.setHorizontalAlignment(SwingConstants.LEADING);
		lblCustName.setBounds(80, 80, 95, 23);
		frmTransaction.getContentPane().add(lblCustName);

        JTextField txtCustName = new JTextField("  Customer Name");
		txtCustName.setBorder(border);
		txtCustName.setHorizontalAlignment(SwingConstants.LEADING);
		txtCustName.setBounds(186, 80, 100, 24);
		frmTransaction.getContentPane().add(txtCustName);
		txtCustName.setText(Home.custname);

        JLabel lblTransType = new JLabel("Transaction Type:");
		lblTransType.setForeground(new Color(0, 0, 0));
		lblTransType.setHorizontalAlignment(SwingConstants.LEADING);
		lblTransType.setBounds(80, 120, 104, 23);
		frmTransaction.getContentPane().add(lblTransType);

        JTextField txtTransType = new JTextField();
		txtTransType.setBorder(border);
		txtTransType.setHorizontalAlignment(SwingConstants.LEADING);
		txtTransType.setBounds(186, 120, 100, 24);
		frmTransaction.getContentPane().add(txtTransType);
		txtTransType.setText(Home.transtype);

        JLabel lblInvoice = new JLabel("SOA/Invoice No.:");
		lblInvoice.setForeground(new Color(0, 0, 0));
		lblInvoice.setHorizontalAlignment(SwingConstants.LEADING);
		lblInvoice.setBounds(80, 160, 103, 23);
		frmTransaction.getContentPane().add(lblInvoice);

        JTextField txtInvoice = new JTextField();
		txtInvoice.setBorder(border);
		txtInvoice.setHorizontalAlignment(SwingConstants.LEADING);
		txtInvoice.setBounds(186, 160, 100, 24);
		frmTransaction.getContentPane().add(txtInvoice);
		txtInvoice.setText(Home.invoice);

        JLabel lblBiller = new JLabel("Company/Biller:");
		lblBiller.setForeground(new Color(0, 0, 0));
		lblBiller.setHorizontalAlignment(SwingConstants.LEADING);
		lblBiller.setBounds(80, 200, 95, 23);
		frmTransaction.getContentPane().add(lblBiller);

        JTextField txtBiller = new JTextField();
		txtBiller.setBorder(border);
		txtBiller.setHorizontalAlignment(SwingConstants.LEADING);
		txtBiller.setBounds(186, 200, 100, 24);
		frmTransaction.getContentPane().add(txtBiller);
		txtBiller.setText(Home.biller);

        JLabel lblStmDate = new JLabel("Statement Date:");
		lblStmDate.setForeground(new Color(0, 0, 0));
		lblStmDate.setHorizontalAlignment(SwingConstants.LEADING);
		lblStmDate.setBounds(80, 240, 102, 23);
		frmTransaction.getContentPane().add(lblStmDate);

        JTextField txtStmDate = new JTextField();
		txtStmDate.setBorder(border);
		txtStmDate.setHorizontalAlignment(SwingConstants.LEADING);
		txtStmDate.setBounds(186, 240, 100, 24);
		frmTransaction.getContentPane().add(txtStmDate);
		txtStmDate.setText(Home.stmdate);

        JLabel lblAmtDue = new JLabel("Amount Due:");
		lblAmtDue.setForeground(new Color(0, 0, 0));
		lblAmtDue.setHorizontalAlignment(SwingConstants.LEADING);
		lblAmtDue.setBounds(80, 280, 76, 23);
		frmTransaction.getContentPane().add(lblAmtDue);

        JTextField txtAmtDue = new JTextField();
		txtAmtDue.setBorder(border);
		txtAmtDue.setHorizontalAlignment(SwingConstants.LEADING);
		txtAmtDue.setBounds(186, 280, 100, 24);
		frmTransaction.getContentPane().add(txtAmtDue);
		txtAmtDue.setText(Home.amtdue);

        JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setForeground(new Color(0, 0, 0));
		lblDueDate.setHorizontalAlignment(SwingConstants.LEADING);
		lblDueDate.setBounds(80, 320, 64, 23);
		frmTransaction.getContentPane().add(lblDueDate);

        JTextField txtDueDate = new JTextField();
		txtDueDate.setBorder(border);
		txtDueDate.setHorizontalAlignment(SwingConstants.LEADING);
		txtDueDate.setBounds(186, 320, 100, 24);
		frmTransaction.getContentPane().add(txtDueDate);
		txtDueDate.setText(Home.duedate);

		try {
			String strSQLQuery = "SELECT * FROM tbltransaction ";
            String strData;
			int tempNum;
			objResultSet = objSQLQuery.executeQuery(strSQLQuery);
           
			while (objResultSet.next()) {
				strData = objResultSet.getString("Refnum").trim();  
                tempNum = Integer.parseInt(strData);
				if (tempNum == Home.refnum) {
					Home.refnum = tempNum + 1;
				}// if (tempNum == refNum)	
			}  //while (objResultSet.next()) 
		} catch (Exception objEx) {
			System.out.println("Problem retrieving information..");
			System.out.println(objEx);
		}// try
		System.out.println("Reference number: " + Home.refnum);

		txtTransType.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent objME) {
				txtTransType.setText(null);                		
			}  //public void mouseClicked(MouseEvent objME)
		}); //txtEmail.addMouseListener(new MouseAdapter()
		
		txtStmDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent objME) {
				txtStmDate.setText(null);                		
			}  //public void mouseClicked(MouseEvent objME)
		}); //txtEmail.addMouseListener(new MouseAdapter()

		txtDueDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent objME) {
				txtDueDate.setText(null);                		
			}  //public void mouseClicked(MouseEvent objME)
		}); //txtEmail.addMouseListener(new MouseAdapter()

        JButton btnBack = new JButton("Back");
        btnBack.setBackground(new Color(255, 255, 255));
        btnBack.setBounds(60, 400, 89, 23);
        frmTransaction.getContentPane().add(btnBack);
        btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				Main.ActivityMain();
				frmTransaction.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});

        JButton btnNext = new JButton("Next");
        btnNext.setBackground(new Color(255, 255, 255));
        btnNext.setBounds(230, 400, 89, 23);
        frmTransaction.getContentPane().add(btnNext);
        btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				Home.custname = txtCustName.getText().trim();
				Home.transtype = txtTransType.getText().trim();
				Home.invoice = txtInvoice.getText().trim();
				Home.biller = txtBiller.getText().trim();
				Home.stmdate = txtStmDate.getText().trim();
				Home.amtdue = txtAmtDue.getText().trim();
				Home.duedate = txtDueDate.getText().trim();
				Main.ActivityAccount();
				frmTransaction.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});
	} //public void TransactionGUI()
}//public class Transaction implements Runnable
