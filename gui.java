import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gui implements ActionListener {
	
	JTextField amtField = new JTextField(10);
	JTextField descField = new JTextField(50);
	JButton addBtn = new JButton("Add");
	
	public gui(){
		
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
		
		frame.add(panel);
		frame.pack();
        frame.setVisible(true);	
		
		addBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String amtIn = amtField.getText();
            Float amt = Float.parseFloat(amtIn);
			String desc = descField.getText();
        }
    }
	
	public static void main(String args[]){
		gui g = new gui();
	}
	
}