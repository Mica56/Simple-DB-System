import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class Records implements Runnable {

    private JFrame frmRecords;
    private String refnum;
    private String custname;
    private String transtype;
    private String transdate;
    private String invoicenum;
    private String paytype;
    private String total;

    private Connection objConn;
	private boolean boolConn2Db;
	private Statement objSQLQuery;
	private ResultSet objResultSet;

    DefaultTableModel model = new DefaultTableModel(0, 0);
    
    public void run() {
		try {
			Records window = new Records();
			window.frmRecords.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	Records() {
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
            RecordsGUI();
        }  //if (boolConn2Db)
    }  // Records() 

	public void RecordsGUI() {
        String column[] = { "Reference No.", "Customer Name", "Transaction Type", "Transaction Date", "Invoice No.", "Payment Type", "Total"};
        
        model.setColumnIdentifiers(column);

		frmRecords = new JFrame();
        frmRecords.setTitle("Record Log");
        frmRecords.setBackground(new Color(128, 0, 0));
        frmRecords.getContentPane().setBackground(new Color(255, 102, 0));
        frmRecords.setBounds(100, 100, 650, 500);
        frmRecords.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmRecords.getContentPane().setLayout(null);

        JScrollPane scpRecords = new JScrollPane();  // for scrollpane
        scpRecords.setBounds(65, 70, 500, 320);

        try {
            String strSQLQuery = "SELECT * FROM tbltransaction;"; 
            objResultSet = objSQLQuery.executeQuery(strSQLQuery);
            while (objResultSet.next()) {
            		refnum = objResultSet.getString("Refnum");
            		custname = objResultSet.getString("Custname");
            		transtype = objResultSet.getString("Transtype");
                    transdate = objResultSet.getString("Transdate");
                    invoicenum = objResultSet.getString("Invoicenum");
                    paytype = objResultSet.getString("Paytype");
                    total = objResultSet.getString("Total");
                    model.addRow(new Object[]{refnum, custname, transtype, transdate, invoicenum, paytype, total});
            } //while (objResultSet.next())
            
            objResultSet.close();      
            
		} catch (Exception objEx) {
           		 System.out.println("Problem retrieving information..");
           		 System.out.println(objEx);
		}// try

        JTable tblRecords = new JTable();//takes objRecords
        tblRecords.setModel(model);
        scpRecords.setViewportView(tblRecords);
        frmRecords.getContentPane().add(scpRecords);

        JButton btnHome = new JButton("Back to Home");
        btnHome.setBackground(new Color(255, 255, 255));
        btnHome.setBounds(250, 400, 120, 23);
        frmRecords.getContentPane().add(btnHome);
        btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				Main.ActivityMain();
				frmRecords.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});
	} //public void RecordsGUI()
}//public class Records implements Runnable
