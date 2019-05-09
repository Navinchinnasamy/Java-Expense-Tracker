import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.util.Scanner;
import java.util.ArrayList;

public class Main implements ActionListener {

    boolean isAuthenticated = false;
    ArrayList<String> creds = new ArrayList<String>();

	JTextField unameField = new JTextField(10);
	JTextField pswdField = new JTextField(50);
	JButton loginBtn = new JButton("Login");
	JFrame frame = new JFrame("Expense Manager - Login");
	JLabel invalidMsg = new JLabel("");
	
	public Main(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JLabel unameLabel = new JLabel("Enter Username");		
		JLabel pswdLabel = new JLabel("Enter Password");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(invalidMsg);
		panel.add(Box.createVerticalGlue());
		panel.add(unameLabel);
		panel.add(unameField);
		panel.add(Box.createVerticalGlue());
		panel.add(pswdLabel);
		panel.add(pswdField);
		panel.add(Box.createVerticalGlue());
		panel.add(loginBtn);
		panel.add(Box.createVerticalGlue());
		
		frame.add(panel);
		frame.pack();
        frame.setVisible(true);	
		
		loginBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String unameIn = unameField.getText();
			String pswdIn = pswdField.getText();
			authenticate(unameIn, pswdIn);
        }
    }
		
    public static void main(String[] args) {
        Main obj = new Main();
        // obj.authenticate();
    }

    private void authenticate(String uname, String pswd){
        File txtFile = new File("credentials.et");
		ArrayList<String> creds = new ArrayList<String>();
		try{
			Scanner sc = new Scanner(txtFile);
			while(sc.hasNextLine()){
				String ln = sc.nextLine();
				creds.add(ln);
				// System.out.println(ln);
			}
			sc.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		for(String c : creds){
			String[] cred = c.split(":");
			System.out.println(cred[0]+" -> "+cred[1]);
			if(cred[0].equals(uname) && cred[1].equals(pswd)){
				new MyExpenses();
				frame.dispose();
			} else {
				invalidMsg.setText("Enter valid credentials");
				invalidMsg.setForeground(Color.RED);
			}
		}
    }
}
