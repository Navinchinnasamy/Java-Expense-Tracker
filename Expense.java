public class Expense {
    private float amount;
    private String description;

    public Expense(float amt, String desc){
        this.amount = amt;
        this.description = desc;
    }

    public float getAmout(){
        return amount;
    }

    public String getDescription(){
        return description;
    }
}