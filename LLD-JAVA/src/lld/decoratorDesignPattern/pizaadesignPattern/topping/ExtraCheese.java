package lld.decoratorDesignPattern.pizaadesignPattern.topping;

import lld.decoratorDesignPattern.pizaadesignPattern.BasePizza;

public class ExtraCheese extends ToppingDecorator{
    public ExtraCheese(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+30;
    }
}
