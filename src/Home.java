import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Home implements Runnable {

    private JFrame frmHome;
    public static int refnum = 1;
    public static String custname;
	public static String transtype = "  ex. Bills Payment";
	public static String invoice;
	public static String biller;
	public static String stmdate = "  DD/MM/YYYY";
	public static String amtdue;
	public static String duedate = "  DD/MM/YYYY";
    public static String total;
    public static String acctnum;
    public static String acctname;
    public static String contact;
    public static String address;
    
    public void run() {
		try {
			Home window = new Home();
			window.frmHome.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		} //try
	} //public void run()

	Home() {
            HomeGUI();
    }  // Home() 

	public void HomeGUI() {
        frmHome = new JFrame();
        frmHome.setTitle("Home");
        frmHome.setBackground(new Color(128, 0, 0));
        frmHome.getContentPane().setBackground(new Color(255, 102, 0));
        frmHome.setBounds(100, 100, 400, 500);
        frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmHome.getContentPane().setLayout(null);
            
        JLabel lblLogo = new JLabel("BClogo");
		lblLogo.setForeground(new Color(128, 0, 0));
		lblLogo.setBackground(new Color(128, 0, 0));
		lblLogo.setIcon(new ImageIcon(Home.class.getResource("/images/home-logo.jpg")));
		lblLogo.setBounds(0, 0, 384, 160);
		frmHome.getContentPane().add(lblLogo);

        JLabel lblicon = new JLabel("admin");
		lblicon.setForeground(new Color(128, 0, 0));
		lblicon.setBackground(new Color(128, 0, 0));
		lblicon.setIcon(new ImageIcon(Home.class.getResource("/images/admin.jpg")));
		lblicon.setBounds(300, 386, 46, 35);
		frmHome.getContentPane().add(lblicon);

        JLabel lblQuestion = new JLabel("Would you like to make a transaction?");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(90, 230, 220, 35);
		frmHome.getContentPane().add(lblQuestion);

        JLabel lblCreatedBy = new JLabel("Created by:");
		lblCreatedBy.setForeground(new Color(255, 255, 255));
		lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedBy.setBounds(116, 390, 152, 36);
		frmHome.getContentPane().add(lblCreatedBy);
		
		JLabel lblCMicaela = new JLabel("Cerilla, Micaela T.");
		lblCMicaela.setForeground(new Color(255, 255, 255));
		lblCMicaela.setHorizontalAlignment(SwingConstants.CENTER);
		lblCMicaela.setBounds(116, 403, 152, 36);
		frmHome.getContentPane().add(lblCMicaela);

        JButton btnYes = new JButton("Yes");
        btnYes.setBackground(new Color(255, 255, 255));
        btnYes.setBounds(60, 280, 89, 23);
        frmHome.getContentPane().add(btnYes);
        btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
				Main.ActivityTransaction();
				frmHome.dispose();
			} //public void actionPerformed(ActionEvent objAE)
		});

        JButton btnNo = new JButton("No");
        btnNo.setBackground(new Color(255, 255, 255));
        btnNo.setBounds(230, 280, 89, 23);
        frmHome.getContentPane().add(btnNo);
        btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent objAE) {
                System.exit(0);
			} //public void actionPerformed(ActionEvent objAE)
		});

        lblicon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent objME) {
				Main.ActivityAdmin();
				frmHome.dispose();                		
			}  //public void mouseClicked(MouseEvent objME)
		}); //txtEmail.addMouseListener(new MouseAdapter()
	} //public void HomeGUI()
}//public class Home implements Runnable
