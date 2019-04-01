import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    protected static boolean isAuthenticated = false;
    protected static ArrayList<Expense> expenses = new ArrayList<>();
    protected static MySQLDBCon conn = new MySQLDBCon();

    public static void main(String[] args) {
        Main obj = new Main();
        obj.authenticate();
    }

    private void authenticate(){
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
            displayExpenses();
            addExpense();
        } else {
            isAuthenticated = false;
            System.out.println("Invalid credentials! Try with correct credentials!!");
            authenticate();
        }
    }

    private void addExpense(){
        System.out.println("\n");
        System.out.println("###*********************$$$************************###");
        System.out.println("Add New Expense:");
        System.out.println("----------------");
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter amount spent: ");
        String expAmt = scn.nextLine();
        System.out.print("Enter purpose of expense: ");
        String expDesc = scn.nextLine();

        Expense e = new Expense(Float.parseFloat(expAmt), expDesc);
        conn.addNewExpense(e);

        System.out.print("Want to add more Expense [y/n]? ");
        char choice = scn.next().charAt(0);
        char yes = 'y';

        if(choice == yes){
            addExpense();
        } else{
            displayExpenses();
        }
    }

    protected void displayExpenses(){
        expenses = conn.getAllExpenses();
        System.out.println("\n");
        System.out.println("###*********************$$$************************###");
        System.out.println("Added Expense:");
        System.out.println("--------------");
        for(Expense e : expenses){
            System.out.print(e.getDescription()+" \t - "+e.getAmout()+"\n");
        }
    }
}
