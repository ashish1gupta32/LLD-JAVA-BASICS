package lld.flyWeightDesignPattern;

public class Main {
    public static void main(String[] args) {
        IRobot humanoid1 = IRobotFactory.createRobot("HUMANOID");
        humanoid1.display(10,12);
        IRobot roboticDog1 = IRobotFactory.createRobot("ROBOTICDOG");
        roboticDog1.display(10,22);
        IRobot roboticDog2 = IRobotFactory.createRobot("ROBOTICDOG");
        roboticDog2.display(19,11);
        IRobot humanoid2 = IRobotFactory.createRobot("HUMANOID");
        humanoid2.display(12,22);
    }

}
