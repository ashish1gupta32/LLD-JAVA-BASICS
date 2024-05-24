package lld.decoratorDesignPattern;

public class HalfDiscount extends Product{
    Product product;
    HalfDiscount(Product product){
        this.product=product;
    }
    public int getPrice() {
        int price=product.getPrice();
        return price/2;
    }
}
