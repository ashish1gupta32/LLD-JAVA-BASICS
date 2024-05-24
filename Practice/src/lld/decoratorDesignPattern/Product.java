package lld.decoratorDesignPattern;

public class Product {
    int price;
    Product(){}
    Product(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
}
