package main.beverages;

import main.ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Beverage {
    public List<Ingredient> ingredients = new ArrayList<>();

    public abstract void prepareBeverage() throws InterruptedException;

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }


    public String checkSufficientQuantity(Map<String, Ingredient> ingredientMap) {

        for(Ingredient ingredient : ingredients){

            if(ingredientMap.get(ingredient.getName()) == null || (ingredientMap.get(ingredient.getName()).getQuantity() < ingredient.getQuantity())){
                return ingredient.getName();
            }
        }
        return null;
    }


    public String reduceCoffeeMachineQuantity(Map<String, Ingredient> ingredientMap) {

        for(Ingredient ingredient : ingredients){

            int quantity = ingredientMap.get(ingredient.getName()).getQuantity();
            ingredientMap.get(ingredient.getName()).setQuantity(quantity-ingredient.getQuantity());
        }
        return null;
    }
}
