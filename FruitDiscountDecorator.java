// 打折类水果，属水果继承自水果
public class FruitDiscountDecorator extends Fruit {

    private Fruit fruit;

    private double discountNum; // 这里使用小数记录打折，8则为0.8

    public FruitDiscountDecorator(Fruit fruit, double discountNum) {
        this.fruit = fruit;
        this.discountNum = discountNum;
    }

    public Fruit cancelDiscount() {
        return fruit;
    }

    @Override
    public int settleAccounts() { // 打折类水果得结账方式
        return (int) Math.round(fruit.settleAccounts() * discountNum);
    }
    
}
