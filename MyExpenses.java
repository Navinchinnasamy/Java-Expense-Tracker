import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyExpenses extends Frame implements ActionListener {
	private Label amtLabel;
	private Label descLabel;
	private TextField amtInput;
	private TextField descInput;
	private Button addBtn;
	private ArrayList<Expense> expenses;
	
	public MyExpenses(){
		setLayout(new FlowLayout());
		
		amtLabel = new Label("Amount: ");
		add(amtLabel);
		amtInput = new TextField(10);
		add(amtInput);
		
		descLabel = new Label("Description: ");
		add(descLabel);
		descInput = new TextField(50);
		add(descInput);
		
		addBtn = new Button("Add");
		add(addBtn);
		
		addBtn.addActionListener(this);
		
		setTitle("My Expense Tracker");
		setSize(600, 400);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new MyExpenses();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Float amt = Float.parseFloat(amtInput.getText());
		String desc = descInput.getText();
		Expense exp = new Expense(amt, desc);
		expenses.add(exp);
		System.out.println(amt + " for "+ desc);
	}
}