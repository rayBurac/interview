import java.util.ArrayList;
import java.util.List;

// 账单类，属记账类型，实现记账接口
public class StatementTotal implements Statement {

    protected FruitFactory fruitFactory;

    public StatementTotal(FruitFactory fruitFactory) {
        this.fruitFactory = fruitFactory;
    }

    private List<Fruit> consumer = new ArrayList<Fruit>(); // 账单上得所有商品


    public void buy(String name, int count) { // 购买商品
        consumer.add((fruitFactory.getFruit(name)).setCount(count));
    }

    public void clean() {
        consumer.clear();
    }

    @Override
    public Object clone() {
        StatementTotal total = null;
        try {
            total = new StatementTotal(fruitFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public int settleAccounts() { // 账单得结账方式
        return consumer.stream().map(Statement::settleAccounts).reduce(0,Integer::sum);
    }

}
