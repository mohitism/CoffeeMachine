package main.ingredients;

public abstract class Ingredient {
    protected int quantity;
    protected String name;


    public Ingredient(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
