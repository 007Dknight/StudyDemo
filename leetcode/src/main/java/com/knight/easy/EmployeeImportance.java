package com.knight.easy;

import java.util.*;

/**
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

 For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

 Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

 Example 1:

 Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 Output: 11
 Explanation:
 Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.

 */

/**
 * 应该是Employee.importance + subordinates -> Employee ，的importance
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;

    public Employee() {
    }

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}
public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        List<Integer> subordinates = new ArrayList<Integer>();
        for(Employee e : employees){
            if(e.id == id){
                importance = e.importance;
                subordinates = e.subordinates;
                for(Integer i : subordinates)
                    importance = importance + getImportance(employees,i);
                break;
            }

        }
        return importance;
    }

    public void getMap(Map<Integer,List<Integer>> map,int id){

        while (map.get(id) != null && map.get(id).size() >= 1){
            System.out.println("id是:"+id);
            List<Integer> list = map.get(id);
            int temp = id;
            for(int i:list){
                temp = i;
                System.out.println("for里面的"+i);
            }
            id = temp;
            System.out.println("id是:"+id);
            System.out.println("while");
        }
    }








    public static void main(String[] args) {
        EmployeeImportance importance = new EmployeeImportance();
        List<Employee> employees =new ArrayList<Employee>();
        //[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
        //[[1,5,[2,3]],[2,3,[4]],[3,4,[]],[4,1,[]]] 1
        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        Employee aE = new Employee(1,5,a);
        employees.add(aE);
        List<Integer> b = new ArrayList<Integer>();
        b.add(4);
        Employee bE = new Employee(2,3,b);
        Employee cE = new Employee(3,4,new ArrayList<Integer>());
        Employee dE = new Employee(4,1,new ArrayList<Integer>());
        employees.add(aE);
        employees.add(bE);
        employees.add(cE);
        employees.add(dE);

        System.out.println("结果："+importance.getImportance(employees,1));
//        System.out.println(importance.b(employees,1));
//        System.out.println(importance.getAll(employees,1));
//        test(10);

    }


    //[[1,81,[2,5]],[2,58,[3]],[3,89,[4]],[4,68,[]],[5,79,[]]] 2

    public void test(Map<Integer,List<Integer>> map,int id){
       List<Integer> list = map.get(id);
       int l = list.size();
       for (int i:list){
           System.out.println("list里的:"+i);
       }
       for(int i = 0;i<l;i++){
           if(map.get(list.get(i)) != null && map.get(list.get(i)).size() >=1){
               System.out.println(list.get(i)+":"+map.get(list.get(i)));
               list.addAll(map.get(list.get(i)));
           }
           map.put(id,list);
       }
        System.out.println("id："+map.get(id));
    }



}
