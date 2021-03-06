// 结账优惠，归属属于账单计算，继承自账单， 该优惠方式为满则减得政策，如：满100减10
public class StatementTotalActivityDecorator extends StatementTotal {


    // 购物满 full 减 minus 块

    private int full;
    private int minus;

    public StatementTotalActivityDecorator(FruitFactory fruitFactory, int full, int minus) {
        super(fruitFactory);
        this.full = full;
        this.minus = minus;
    }

    @Override
    public Object clone() {
        StatementTotal total = null;
        try {
            total = new StatementTotalActivityDecorator(super.fruitFactory, full, minus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public int settleAccounts() { // 活动得结算方式
        int billCount = super.settleAccounts();
        return billCount - (billCount / full * minus);
    }

}
