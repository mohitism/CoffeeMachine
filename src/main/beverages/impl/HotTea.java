package main.beverages.impl;

import main.beverages.Beverage;
import main.ingredients.Ingredient;
import main.ingredients.impl.*;
import main.machine.CoffeeMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotTea extends Beverage {

    private static Logger logger = Logger.getLogger(HotTea.class.getName());

    public HotTea(){
        this.ingredients.add(new HotWater(200));
        this.ingredients.add(new HotMilk(100));
        this.ingredients.add(new GingerSyrup(10));
        this.ingredients.add(new SugarSyrup(10));
        this.ingredients.add(new TeaLeavesSyrup(30));
    }

    @Override
    public void prepareBeverage() throws InterruptedException {

        logger.log(Level.INFO,"Hot tea is prepared");
        Thread.sleep(100);
    }
}
