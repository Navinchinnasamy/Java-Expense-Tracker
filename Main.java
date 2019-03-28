import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    protected static boolean isAuthenticated = false;
    protected static ArrayList<Expense> expenses = new ArrayList<>();

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
            addExpense();
        } else {
            isAuthenticated = false;
            System.out.println("Invalid credentials! Try with correct credentials!!");
            authenticate();
        }
    }

    private void addExpense(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter amount spent: ");
        String expAmt = scn.nextLine();
        System.out.print("Enter purpose of expense: ");
        String expDesc = scn.nextLine();

        Expense e = new Expense(Float.parseFloat(expAmt), expDesc);
        expenses.add(e);

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
        System.out.println("\n");
        System.out.println("###*********************$$$************************###");
        System.out.println("Added Expense:");
        for(Expense e : expenses){
            System.out.print(e.getDescription()+" \t - "+e.getAmout()+"\n");
        }
    }
}
