package lld.vendingMachine;

import lld.vendingMachine.state.*;

public enum StateType {
    IDLESTATE(new IdleState()), HASMONEYSTATE(new HasMoneyState()),
    SELECTIONSTATE(new SelectionState()), DISPENSESTATE(new DispenseState());

    State state;

    StateType(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
