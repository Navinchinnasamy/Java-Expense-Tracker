import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;

public class MyExpenses implements ActionListener {
	boolean isAuthenticated = false;
    ArrayList<Expense> expenses = new ArrayList<>();

	JFrame frame = new JFrame("Expense Manager");
	JFrame frameList = new JFrame("Expense List");
	JTextField amtField = new JTextField(10);
	JTextField descField = new JTextField(50);
	JButton addBtn = new JButton("Add");
	JButton viewBtn = new JButton("View");
	JButton addNewBtn = new JButton("Add New");
	
	public MyExpenses(){
		frame.setSize(350,180);
		frame.setLocation(500,280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		JMenu createMenu = new JMenu("Add Expense");
		JMenu listMenu = new JMenu("List Expenses");
		menubar.add(createMenu);
		menubar.add(listMenu);
		
		JLabel amtLabel = new JLabel("Enter Amount");		
		amtLabel.setBounds(10,20,110,25);
		JLabel descLabel = new JLabel("Enter Description");
		descLabel.setBounds(10,50,110,25);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		amtField.setBounds(120,20,180,25);
		descField.setBounds(120,50,180,25);
		addBtn.setBounds(120,80,70,25);
		viewBtn.setBounds(200,80,70,25);
		
		panel.add(amtLabel);
		panel.add(amtField);
		panel.add(descLabel);
		panel.add(descField);
		panel.add(addBtn);
		panel.add(viewBtn);
		
		frame.getContentPane().add(panel);
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
			//ViewExpenses ve = new ViewExpenses();
			showExpenses();
			frame.dispose();
        }
		if(e.getSource() == addNewBtn){
			MyExpenses();
			frameList.dispose();
		}
    }
	
	public void clearInputs(){
		amtField.setText("");
		descField.setText("");
	}
	
	protected void displayExpenses(){
        System.out.println("\n");
        System.out.println("###*********************$$$************************###");
        System.out.println("Added Expense:");
        for(Expense e : expenses){
            System.out.print(e.getDescription()+" \t - "+e.getAmout()+"\n");
        }
    }
		
	public void showExpenses() {
		JTable expenseTable;
		frameList.setSize(350,180);
		frameList.setLocation(500,280);
		frameList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelList = new JPanel();
		panelList.setLayout(null);
		addNewBtn.setBounds(10,20,90,25);
		panelList.add(addNewBtn);
		
		String[] columns = new String[] {
            "Description", "Amount"
        };
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		for(Expense e : expenses){
			Float amt = e.getAmount();
			String dsc = e.getDescription();
			Object[] data = { dsc, amt };
			tableModel.add(data);
		}
		
		expenseTable = new JTable(tableModel);
		panelList.add(expenseTable);
		
		frameList.getContentPane().add(panelList);
        frameList.setVisible(true);	
		addNewBtn.addActionListener(this);
	}
	
	public static void main(String[] args){
		new MyExpenses();
	}
}