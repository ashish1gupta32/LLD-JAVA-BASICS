package lld.decoratorDesignPattern.pizaadesignPattern.topping;

import lld.decoratorDesignPattern.pizaadesignPattern.BasePizza;

public class Paneer extends ToppingDecorator{
    public Paneer(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+65;
    }
}
