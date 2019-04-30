import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Main implements ActionListener {

    boolean isAuthenticated = false;
    ArrayList<Expense> expenses = new ArrayList<>();

	JTextField amtField = new JTextField(10);
	JTextField descField = new JTextField(50);
	JButton addBtn = new JButton("Add");
	JButton viewBtn = new JButton("View");
	
	public Main(){
		JFrame frame = new JFrame("Expense Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		JMenu createMenu = new JMenu("Add Expense");
		JMenu listMenu = new JMenu("List Expenses");
		menubar.add(createMenu);
		menubar.add(listMenu);
		
		JLabel amtLabel = new JLabel("Enter Amount");		
		JLabel descLabel = new JLabel("Enter Description");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(amtLabel);
		panel.add(amtField);
		panel.add(Box.createVerticalGlue());
		panel.add(descLabel);
		panel.add(descField);
		panel.add(Box.createVerticalGlue());
		panel.add(addBtn);
		panel.add(Box.createVerticalGlue());
		panel.add(viewBtn);
		
		frame.add(panel);
		frame.pack();
        frame.setVisible(true);	
		
		addBtn.addActionListener(this);
		viewBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String amtIn = amtField.getText();
            Float amt = Float.parseFloat(amtIn);
			String desc = descField.getText();
			Expense exp = new Expense(amt, desc);
			expenses.add(exp);
			clearInputs();
        }
		if (e.getSource() == viewBtn) {
            displayExpenses();
        }
    }
	
	public void clearInputs(){
		amtField.setText("");
		descField.setText("");
	}
	
    public static void main(String[] args) {
        Main obj = new Main();
        // obj.authenticate();
    }

    /* private void authenticate(){
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter User Name: ");
        String username = scn.nextLine();
        System.out.print("Enter Password: ");
        String password = scn.nextLine();

        String c_uname = "navin";
        String c_pswd = "navin123";
        if(username.equals(c_uname) && password.equals(c_pswd)){
            isAuthenticated = true;
            System.out.println("You are authenticated successfully!");
            System.out.println("###*********************$$$************************###");
            addExpense();
        } else {
            isAuthenticated = false;
            System.out.println("Invalid credentials! Try with correct credentials!!");
            authenticate();
        }
    } */

    protected void displayExpenses(){
        System.out.println("\n");
        System.out.println("###*********************$$$************************###");
        System.out.println("Added Expense:");
        for(Expense e : expenses){
            System.out.print(e.getDescription()+" \t - "+e.getAmout()+"\n");
        }
    }
}
