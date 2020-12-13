package main.beverages;

import main.beverages.impl.BlackTea;
import main.beverages.impl.GreenTea;
import main.beverages.impl.HotCoffee;
import main.beverages.impl.HotTea;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BeveragesFactory {

    private static Logger logger = Logger.getLogger(BeveragesFactory.class.getName());

    public static Beverage getBeverage(String name){

        Beverage beverage  = null;

        if(name != null) {

            switch (name.toLowerCase()) {

                case "black tea":

                    return new BlackTea();
                case "green tea":

                    return new GreenTea();
                case "hot tea":

                    return new HotTea();
                case "hot coffee":

                    return new HotCoffee();
                default:
                    logger.log(Level.WARNING,"Beverage Name is Invalid");
            }
        }

        return beverage;
    }
}
