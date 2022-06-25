public class StatementTotalFactory {

    private StatementTotal defaultStatementTotal;
    private FruitFactory fruitFactory;

    public StatementTotalFactory(FruitFactory fruitFactory) {
        this.fruitFactory = fruitFactory;
        defaultStatementTotal = new StatementTotal(fruitFactory);
    }

    public StatementTotal createStatementTotal() {
        StatementTotal total = (StatementTotal)defaultStatementTotal.clone();
        return total;
    }

    public void fullMinusActivity(int full, int minus) { // 满多少减多少的活动
        defaultStatementTotal = new StatementTotalActivityDecorator(fruitFactory, full, minus);
    }

    public void cancelActivity() { // 取消活动
        defaultStatementTotal = new StatementTotal(fruitFactory);
    }

}
