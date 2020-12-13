package main;

import main.machine.CoffeeMachine;
import main.machine.CoffeeMachineBuilder;

public class CoffeeMachineApplicationTest {

    public static void main(String[] args){

        CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().buildCoffeeMachine();

        int count = 0;
        coffeeMachine.prepareBeverage("Black Tea");
        coffeeMachine.prepareBeverage("Green Tea");
        coffeeMachine.prepareBeverage("Hot Coffee");
        coffeeMachine.prepareBeverage("Hot Tea");

        coffeeMachine.refillIngredient("");

        coffeeMachine.prepareBeverage("Hot Tea");
        coffeeMachine.prepareBeverage("Hot Tea");
        coffeeMachine.prepareBeverage("Green Tea");
    }
}
