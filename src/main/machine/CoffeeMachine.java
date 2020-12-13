package main.machine;

import main.constants.CoffeeConstants;
import main.constants.CoffeeConstants.*;
import main.ingredients.Ingredient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

import static main.constants.CoffeeConstants.*;

public class CoffeeMachine {

    private static Logger logger = Logger.getLogger(CoffeeMachine.class.getName());

    public static Integer NUMBER_OF_SLOTS = 3;
    public static final int HOT_MILK_CAPACITY = 500;
    public static final int HOT_WATER_CAPACITY = 500;
    public static final int GINGER_SYRUP_CAPACITY = 100;
    public static final int SUGAR_SYRUP_CAPACITY = 100;
    public static final int GINGER_MIXTURE_CAPACITY = 100;
    public static final int LEAVES_SYRUP_CAPACITY = 100;

    volatile Map<String, Ingredient> ingredientsMap = new HashMap<>();
    ExecutorService slotsExecutorService;


    public void prepareBeverage(String beverageName){
        try {
            this.slotsExecutorService.submit(new CoffeeDispenser(this,beverageName));
        }catch (Exception e){
            logger.log(Level.SEVERE,"beverage cannot be prepared");
        }
    }

    public void refillIngredient(String name){

        if(name != null){

            switch (name){
                case HOT_WATER:
                    this.ingredientsMap.get("hot water").setQuantity(HOT_WATER_CAPACITY);
                    break;
                case HOT_MILK:
                    this.ingredientsMap.get("hot milk").setQuantity(HOT_MILK_CAPACITY);
                    break;
                case GINGER_SYRUP:
                    this.ingredientsMap.get("ginger_syrup").setQuantity(GINGER_SYRUP_CAPACITY);
                    break;
                case GINGER_MIXTURE:
                    this.ingredientsMap.get("ginger_mixture").setQuantity(GINGER_MIXTURE_CAPACITY);
                    break;
                case SUGAR_SYRUP:
                    this.ingredientsMap.get("sugar_syrup").setQuantity(SUGAR_SYRUP_CAPACITY);
                    break;
                case LEAVES_SYRUP:
                    this.ingredientsMap.get("tea_leaves_syrup").setQuantity(LEAVES_SYRUP_CAPACITY);
                    break;
                default:
                    logger.log(Level.WARNING,"Ingredient Name is Invalid");
            }
        }
    }




}
