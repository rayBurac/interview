public class MainAccess {
    public static void main(String[] args) {

        /*1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
            现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
            请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
        */

        Fruit apple = new Fruit(8);
        Fruit strawberry = new Fruit(13);

        // 顾客A
        StatementTotal consumerA = new StatementTotal();
        consumerA.buy(apple, 5);
        consumerA.buy(strawberry, 1);
        System.out.println("A 购买 5 斤苹果，1斤草莓  总价为：" + consumerA.settleAccounts());


        /*2、超市增加了一种水果芒果，其定价为 20 元/斤。
            现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        Fruit mango = new Fruit(20);
        // 顾客B
        StatementTotal consumerB = new StatementTotal();
        consumerB.buy(apple, 1);
        consumerB.buy(strawberry, 3);
        consumerB.buy(mango, 6);
        System.out.println("B 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + consumerB.settleAccounts());


        /*3、超市做促销活动，草莓限时打 8 折。
            现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        // 打折活动开始
        strawberry = new Discount(strawberry, 0.8);
        // 顾客C
        StatementTotal consumerC = new StatementTotal();
        consumerC.buy(apple, 1);
        consumerC.buy(strawberry, 3);
        consumerC.buy(mango, 6);
        System.out.println("C 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + consumerC.settleAccounts());


        /*4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
            现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
            请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
         */
        StatementTotal consumerD = new StatementTotalActivity(100, 10);
        consumerD.buy(apple, 1);
        consumerD.buy(strawberry, 3);
        consumerD.buy(mango, 6);
        System.out.println("D 购买 1 斤苹果，3斤草莓，6斤芒果  总价为：" + consumerD.settleAccounts());


    }
}
