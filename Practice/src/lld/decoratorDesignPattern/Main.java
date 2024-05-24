package lld.decoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Product product1=new CouponDiscount(new HalfDiscount(new Product(100)),20);
        Product product2=new HalfDiscount(new HalfDiscount(new CouponDiscount(new Product(100), 20)));
        System.out.println(product1.getPrice());
        System.out.println(product2.getPrice());
    }
}
