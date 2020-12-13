package main.machine;

import main.ingredients.Ingredient;
import main.ingredients.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class CoffeeMachineBuilder {

    public CoffeeMachine buildCoffeeMachine(){

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        addIngredientsToCofeeMachine(coffeeMachine);

        coffeeMachine.slotsExecutorService = Executors.newFixedThreadPool(CoffeeMachine.NUMBER_OF_SLOTS);

        return coffeeMachine;
    }

    private void addIngredientsToCofeeMachine(CoffeeMachine coffeeMachine) {

        Map<String, Ingredient> ingredientsMap = coffeeMachine.ingredientsMap;

        HotWater hotWater = new HotWater(CoffeeMachine.HOT_WATER_CAPACITY);
        ingredientsMap.put(hotWater.getName(),hotWater);

        HotMilk hotMilk = new HotMilk(CoffeeMachine.HOT_MILK_CAPACITY);
        ingredientsMap.put(hotMilk.getName(),hotMilk);

        GingerSyrup gingerSyrup = new GingerSyrup(CoffeeMachine.GINGER_SYRUP_CAPACITY);
        ingredientsMap.put(gingerSyrup.getName(),gingerSyrup);

        SugarSyrup sugarSyrup = new SugarSyrup(CoffeeMachine.SUGAR_SYRUP_CAPACITY);
        ingredientsMap.put(sugarSyrup.getName(),sugarSyrup);

        TeaLeavesSyrup teaLeavesSyrup = new TeaLeavesSyrup(CoffeeMachine.LEAVES_SYRUP_CAPACITY);
        ingredientsMap.put(teaLeavesSyrup.getName(),teaLeavesSyrup);

        GreenMixture greenMixture = new GreenMixture(CoffeeMachine.GINGER_MIXTURE_CAPACITY);
        ingredientsMap.put(greenMixture.getName(),greenMixture);
    }
}
