package lld.decoratorDesignPattern.pizaadesignPattern.topping;

import lld.decoratorDesignPattern.pizaadesignPattern.BasePizza;

public class Mushroom extends ToppingDecorator{
    public Mushroom(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+25;
    }
}
