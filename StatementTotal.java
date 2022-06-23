import java.util.ArrayList;
import java.util.List;

// 账单类，属记账类型，实现记账接口
public class StatementTotal implements Statement {

    private List<Fruit> consumer = new ArrayList<Fruit>(); // 账单上得所有商品

    public void buy(Fruit fruit, int count) { // 购买商品
        consumer.add(fruit.setCount(count));
    }

    public void clean() {
        consumer.clear();
    }

    @Override
    public int settleAccounts() { // 账单得结账方式
        return consumer.stream().map(Statement::settleAccounts).reduce(0,Integer::sum);
    }

}
