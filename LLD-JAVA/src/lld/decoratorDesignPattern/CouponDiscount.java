package lld.decoratorDesignPattern;

public class CouponDiscount extends Product{
    Product product;
    int percentage;
    CouponDiscount(Product product,int per){
        this.product=product;
        this.percentage =per;
    }
    public int getPrice(){
        int price=product.getPrice();
        return price-(price*percentage/100);
    }
}
