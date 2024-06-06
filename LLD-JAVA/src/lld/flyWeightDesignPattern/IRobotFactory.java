package lld.flyWeightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class IRobotFactory {
    static private Map<String, IRobot> cache = new HashMap<>();

    public static IRobot createRobot(String type) {
        if (type.equalsIgnoreCase("Humanoid")) {
            return cache.computeIfAbsent(type.toUpperCase(), (key) -> new HumanoidRobot(type.toUpperCase(), new Sprites()));
        } else
            return cache.computeIfAbsent(type.toUpperCase(), (key) -> new RoboticDog(type.toUpperCase(), new Sprites()));
    }

}
