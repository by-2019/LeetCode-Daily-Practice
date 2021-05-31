package day16.s690;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度和直系下属的 id 。
 *
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 */
public class Solution {
    Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee e = map.get(id);
        int total = e.importance;
        for (int subId : e.subordinates) {
            total += dfs(subId);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Employee> employees = new ArrayList<>();

        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = new ArrayList<>();
        employees.add(e1);


        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();
        e1.subordinates.add(e2.id);
        employees.add(e2);


        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();
        e1.subordinates.add(e3.id);
        employees.add(e3);

        System.out.println(s.getImportance(employees, 1));
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}