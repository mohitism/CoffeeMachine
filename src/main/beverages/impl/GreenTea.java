package main.beverages.impl;

import main.beverages.Beverage;
import main.ingredients.Ingredient;
import main.ingredients.impl.*;
import main.machine.CoffeeMachine;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreenTea extends Beverage {

    private static Logger logger = Logger.getLogger(GreenTea.class.getName());

    public GreenTea() {
        this.ingredients.add(new HotWater(100));
        this.ingredients.add(new GingerSyrup(30));
        this.ingredients.add(new SugarSyrup(50));
        this.ingredients.add(new TeaLeavesSyrup(30));
    }

    @Override
    public void prepareBeverage() throws InterruptedException {
        logger.log(Level.INFO,"Green tea is prepared");
        Thread.sleep(100);
    }
}
