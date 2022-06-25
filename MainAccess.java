public class MainAccess {
    public static void main(String[] args) {

        FruitFactory fruitFactory = new FruitFactory();
        StatementTotalFactory statementTotalFactory = new StatementTotalFactory(fruitFactory);

        /*1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
            现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
            请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        */

        fruitFactory.createFruit("apple", 8);
        fruitFactory.createFruit("strawberry", 13);

        // 顾客A
        StatementTotal consumerA = statementTotalFactory.createStatementTotal();
        consumerA.buy("apple", 5);
        consumerA.buy("strawberry", 1);
        System.out.println("A 购买 5 斤苹果，1斤草莓  总价为：" + consumerA.settleAccounts());
        System.out.println("对照组：A 购买 5 斤苹果，1斤草莓  总价为：" + (5*8+1*13));


        /*2、超市增加了一种水果芒果，其定价为 20 元/斤。
            现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        fruitFactory.createFruit("mango", 20);
        // 顾客B
        StatementTotal consumerB = statementTotalFactory.createStatementTotal();
        consumerB.buy("apple", 1);
        consumerB.buy("strawberry", 3);
        consumerB.buy("mango", 6);
        System.out.println("B 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + consumerB.settleAccounts());
        System.out.println("对照组：B 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + (1 * 8 + 3 * 13 + 6 * 20));


        /*3、超市做促销活动，草莓限时打 8 折。
            现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        // 打折活动开始
        fruitFactory.discount("strawberry", 0.8); // 开始打折
        // 顾客C
        StatementTotal consumerC = statementTotalFactory.createStatementTotal();
        consumerC.buy("apple", 1);
        consumerC.buy("strawberry", 3);
        consumerC.buy("mango", 6);
        System.out.println("C 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + consumerC.settleAccounts());
        System.out.println("对照组：C 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + (int)(1 * 8 + 3 * 13*0.8 + 6 * 20));


        /*4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
            现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        statementTotalFactory.fullMinusActivity(100, 10); // 开始活动，满100减10
        StatementTotal consumerD = statementTotalFactory.createStatementTotal();
        consumerD.buy("apple", 1);
        consumerD.buy("strawberry", 3);
        consumerD.buy("mango", 6);
        System.out.println("D 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + consumerD.settleAccounts());
        System.out.println("对照组：D 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + ((int)(1*8+3*13*0.8+6*20) - ((int)(1*8+3*13*0.8+6*20)/100*10)));


    }
}
