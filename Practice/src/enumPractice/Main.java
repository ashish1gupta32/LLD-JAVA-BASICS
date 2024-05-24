package enumPractice;

public class Main {
    public static void main(String[] args) {
        Region re1=Region.RE1;
        Region re2=Region.RE2;
        Region re3=Region.RE3;
        Region re4=Region.RE4;
        Region re5=Region.RE5;
        Region region=Region.valueOf("RE2");
        System.out.println("...........");
        System.out.println(re1.getRegion());
        System.out.println("...........");
        System.out.println(re2.getRegion());
        System.out.println("...........");
        System.out.println(re3.getRegion());
        System.out.println("...........");
        System.out.println(re4.getRegion());
        System.out.println("...........");
        System.out.println(re5.getRegion());
        System.out.println("...........");
        System.out.println(region.getRegion());
        System.out.println("...........");
        Region.getRegionList();
        System.out.println("...........");
        System.out.println(Region.value);
        System.out.println("...........");
        System.out.println(Region.RE1);

    }
}
