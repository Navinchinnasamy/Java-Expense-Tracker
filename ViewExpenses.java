import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;

public class ViewExpenses implements ActionListener {
	JFrame frame = new JFrame("Expense Manager");
	JPanel panel = new JPanel();
	JButton addBtn = new JButton("Add New");
	JTable expenseTable;
	
	public ViewExpenses(){
		frame.setSize(350,180);
		frame.setLocation(500,280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		addBtn.setBounds(10,20,90,25);
		panel.add(addBtn);
		
		frame.getContentPane().add(panel);
		addBtn.addActionListener(this);
	}
	
	public static void main(String[] args){
		new ViewExpenses();
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            new MyExpenses();
			frame.dispose();
        }
    }
	
	public void showExpenses(ArrayList<Expense> expenses){
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
		panel.add(expenseTable);
		frame.getContentPane().add(panel);
        frame.setVisible(true);	
	}
}