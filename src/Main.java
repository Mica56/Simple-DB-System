
public class Main {
    public static void main(String[]args) {
		ActivityMain();
	} //public static void main(String[]args)
	
	public static void ActivityMain() {
		Thread HomeGUI = new Thread(new Home());
		HomeGUI.start();
	} //public static void ActivityMain()
	
	public static void ActivityTransaction() {
		Thread TransactionGUI = new Thread(new Transaction());
		TransactionGUI.start();
	} //public static void ActivityTransaction()
	
	public static void ActivityAccount() {
		Thread AccountGUI = new Thread(new Account());
		AccountGUI.start();
	} //public static void ActivityAccount()
	
	public static void ActivityPayment() {
		Thread PaymentGUI = new Thread(new Payment());
		PaymentGUI.start();
	} //public static void ActivityPayment()
	
	public static void ActivitySuccess() {
		Thread SuccessGUI = new Thread(new Success());
		SuccessGUI.start();
	} //public static void ActivitySuccess()
	
	public static void ActivityAdmin() {
		Thread AdminGUI = new Thread(new AdminLogin());
		AdminGUI.start();
	} //public static void ActivityAdmin()

	public static void ActivityRecords() {
		Thread RecordsGUI = new Thread(new Records());
		RecordsGUI.start();
	} //public static void ActivityRecords()

}
