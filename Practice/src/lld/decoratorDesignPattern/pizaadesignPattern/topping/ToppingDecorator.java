package lld.decoratorDesignPattern.pizaadesignPattern.topping;

import lld.decoratorDesignPattern.pizaadesignPattern.BasePizza;

public abstract class ToppingDecorator implements BasePizza {
    BasePizza basePizza;
    ToppingDecorator(BasePizza basePizza){
        this.basePizza=basePizza;
    }

}
