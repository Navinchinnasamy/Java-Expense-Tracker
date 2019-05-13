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
	JTextField pswdField = new JTextField(10);
	JButton loginBtn = new JButton("Login");
	JFrame frame = new JFrame("Expense Manager - Login");
	JLabel invalidMsg = new JLabel("");
	
	public Main(){
		frame.setSize(350,180);
		frame.setLocation(500,280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JLabel unameLabel = new JLabel("Enter Username");	
		unameLabel.setBounds(10,20,110,25);
		JLabel pswdLabel = new JLabel("Enter Password");
		pswdLabel.setBounds(10,50,110,25);
		
		unameField.setBounds(120,20,180,25);
		pswdField.setBounds(120,50,180,25);
		loginBtn.setBounds(150,80,70,25);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
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
		
		frame.getContentPane().add(panel);
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
