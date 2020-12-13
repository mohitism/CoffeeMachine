package main.machine;

import main.beverages.Beverage;
import main.beverages.BeveragesFactory;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoffeeDispenser implements Callable {

    private static Logger logger = Logger.getLogger(CoffeeMachine.class.getName());

    CoffeeMachine coffeeMachine;
    String beverageName;

    CoffeeDispenser(CoffeeMachine coffeeMachine,String beverageName){
        this.coffeeMachine = coffeeMachine;
        this.beverageName = beverageName;
    }

    /** Prepare beverage in the available thread from threadpool
     * **/
    @Override
    public Object call() throws Exception {

        Beverage beverage= BeveragesFactory.getBeverage(beverageName);

        String ingredientName = beverage.checkSufficientQuantity(coffeeMachine.ingredientsMap);
        if(ingredientName == null){
            beverage.reduceCoffeeMachineQuantity(coffeeMachine.ingredientsMap);
            beverage.prepareBeverage();
        }else{
            logger.log(Level.WARNING,beverageName+" cannot be prepared because "+ingredientName+" is not sufficient");
        }

        return beverage;
    }
}
