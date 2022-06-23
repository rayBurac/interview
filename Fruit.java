// 水果类，属于商品需记账，继承记账接口
public class Fruit implements Statement {

    private double price;

    private double count;

    public Fruit() {
    }

    public Fruit(int price) {
        this.price = price;
    }

    public Fruit(double price) {
        this.price = price;
    }

    public Fruit setCount(int count) {
        this.count = count;
        return this;
    }

    public Fruit setCount(double count) {
        this.count = count;
        return this;
    }

    @Override
    public int settleAccounts() { // 一般一类物品账单结算
        return (int) Math.round(price * count);
    }

}
