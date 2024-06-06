package lld.flyWeightDesignPattern;

public class RoboticDog implements IRobot{
    //extrinsic data
    String type;
    private Sprites sprites;

    public RoboticDog(String type, Sprites sprites) {
        this.type = type;
        this.sprites = sprites;
    }

    @Override
    public void display(int x, int y) {
        System.out.println(STR."\{type} Robot coordinates x:\{x} , y:\{y}");
    }
}
