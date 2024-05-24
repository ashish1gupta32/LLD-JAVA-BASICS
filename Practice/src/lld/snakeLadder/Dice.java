package lld.snakeLadder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Dice {
    private final int diceCount;
    Dice(int diceCount){
        this.diceCount=diceCount;
    }
    Dice(){
        this.diceCount=1;
    }

    int rollDice(){
        return IntStream.range(0,diceCount).map((_)->
                ThreadLocalRandom.current().nextInt(6)).sum();
    }

}
