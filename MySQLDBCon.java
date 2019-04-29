import java.sql.*;
import java.util.ArrayList;

public class MySQLDBCon {
    public Connection conn;
	private boolean isConnected;
	private ArrayList<Expense> expenses;

    public MySQLDBCon() {
		expenses = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_expenses", "room_exp", "12345");
			isConnected = true;
        } catch (Exception e) {
            // System.out.println(e);
			isConnected = false;
        }
    }

    public ArrayList<Expense> getAllExpenses() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT id, amount, description, purchased_at FROM expenses");
            while (res.next()) {
                Expense exp = new Expense(res.getFloat(2), res.getString(3));
                expenses.add(exp);
            }
        } catch (Exception e) {
            // System.out.println(e);
        }
        return expenses;
    }

    public int addNewExpense(Expense exp) {
        String sql = "INSERT INTO expenses (`description`, `amount`, `purchased_at`, `purchased_by`) VALUES (?,?,NOW(), 1)";
        int retID = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, exp.getDescription());
            stmt.setFloat(2, exp.getAmout());
            stmt.executeUpdate();

            ResultSet res = stmt.getGeneratedKeys();
            if (res.next()) {
                retID = res.getInt(1);
            }
        } catch (Exception e) {
            // System.out.println(e);
			if(!isConnected){
				expenses.add(exp);
			}
        }
        return retID;
    }

    public void closeConnexction() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
