package lld.decoratorDesignPattern.pizaadesignPattern;

import lld.decoratorDesignPattern.pizaadesignPattern.topping.ExtraCheese;
import lld.decoratorDesignPattern.pizaadesignPattern.topping.Mushroom;
import lld.decoratorDesignPattern.pizaadesignPattern.topping.Paneer;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new Mushroom(new Paneer(new Farmhouse())));
        System.out.println(STR."cost : \{pizza.cost()}");

        BasePizza pizza2 = new Paneer(new Mushroom(new VegDelight()));
        System.out.println(STR."cost : \{pizza2.cost()}");
    }
}
