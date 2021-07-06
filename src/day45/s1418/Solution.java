package day45.s1418;

import java.util.*;

/**
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * <p>
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <p>
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列
 */
public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> tables = new TreeMap<>();
        Set<String> dishNames = new TreeSet<>();
        for (List<String> order : orders) {
            Map<String, Integer> dishes = tables.computeIfAbsent(Integer.parseInt(order.get(1)), k -> new TreeMap<>());
            String dishName = order.get(2);
            Integer old = dishes.getOrDefault(dishName, 0);
            dishes.put(dishName, old + 1);
            dishNames.add(dishName);
        }

        List<List<String>> rs = new ArrayList<>(tables.size());
        List<String> title = new ArrayList<>(dishNames.size() + 1);
        title.add("Table");
        title.addAll(dishNames);
        rs.add(title);
        for (Map.Entry<Integer, Map<String, Integer>> entry : tables.entrySet()) {
            List<String> tableInfo = new ArrayList<>(dishNames.size() + 1);
            rs.add(tableInfo);
            tableInfo.add(String.valueOf(entry.getKey()));
            Map<String, Integer> orderDishes = entry.getValue();
            for (String dishName : dishNames) {
                Integer order = orderDishes.get(dishName);
                tableInfo.add(null == order ? "0" : String.valueOf(order));
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> orders = new LinkedList<>();
        orders.add(new LinkedList<>(Arrays.asList("David","3","Ceviche")));
        orders.add(new LinkedList<>(Arrays.asList("Corina","10","Beef Burrito")));
        orders.add(new LinkedList<>(Arrays.asList("David","3","Fried Chicken")));
        orders.add(new LinkedList<>(Arrays.asList("Carla","5","Water")));
        orders.add(new LinkedList<>(Arrays.asList("Carla","5","Ceviche")));
        orders.add(new LinkedList<>(Arrays.asList("Rous","3","Ceviche")));
        System.out.println(s.displayTable(orders));
    }
}
