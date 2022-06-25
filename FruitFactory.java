import java.util.HashMap;
import java.util.Map;

public class FruitFactory {

    private Map<String, Fruit> fruitMap = new HashMap<String, Fruit>();

    public void createFruit(String name, int price) {
        Fruit fruit = new Fruit(price);
        fruitMap.put(name, fruit);
    }

    public void discount(String name, double discountNum) { // 打折
        Fruit fruit = fruitMap.get(name);
        Fruit discountFruit = new FruitDiscountDecorator(fruit, discountNum);
        fruitMap.replace(name, discountFruit);
    }

    public void cancelDiscount(String name) { // 取消打折
        Fruit fruit = fruitMap.get(name);
        fruitMap.replace(name, ((FruitDiscountDecorator) fruit).cancelDiscount());
    }

    public Fruit getFruit(String name) {
        return fruitMap.get(name);
    }

}
