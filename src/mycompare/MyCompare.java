package mycompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyCompare {
    public static void main(String[] args) {
        //  Java的比较方法
        /**
         * 1、 ==   用于基本数据类型的比较，返回值是布尔类型 boolean
         * 2.3.4 用于对象的比较:
         * 2、 equals()  返回值值是布尔类型
         * 3、 compareTo()   返回值值是整数， =0 相等， <0 代表    ； >0 代表
         * 至于是正负多少，看所不同的字符在编码表中的差距
         * 4、Comparator.comparing(A::getage) 通常用排序中使用
         */

        System.out.println("=========1、基本数据类型的比较==========");
        // 1、基本数据类型的比较
        int a = 1;
        int b = 2;

        if (a == b) {
            System.out.println(a + "和" + b + "相等！");
        } else {
            System.out.println(a + "和" + b + "不相等！");
        }


        //2、对象的比较
        System.out.println("=========2、对象的比较之equals==========");
        String s1 = "abc";
        String s2 = "abc";
        if (s1.equals(s2)) {
            System.out.println("s1 和 s2 相等");
        } else {
            System.out.println("s1 和 s2 不等");
        }


        System.out.println("=========3、对象的比较之compareTo==========");
        //3、要比较出来谁大谁小：常用于数据库查询到数据与配置数据（apollo）
        //比较是ASCII值，如果 a.compareTo(b) < 0 则 a < b
        //如果 a.compareTo(b) > 0 则 a > b
        Double amount1 = new Double(3000);
        Double amount2 = new Double(1000);
        if (amount1.compareTo(amount2) == 0) {
            System.out.println("amount1 和 amount2 相等");
        } else if (amount1.compareTo(amount2) < 0) {
            System.out.println("amount1 小于 amount2");
        } else {
            System.out.println("amount1 大于 amount2");
        }

        System.out.println("=========4、 Comparator.comparing()的用法==========");
        //4、Comparator.comparing()的用法
        // 默认返回的是升序，即小的在前，大的在最后
        List<Person> people = new ArrayList<>();
        people.add(new Person("张三", 18, 5000));
        people.add(new Person("李四", 28, 3000));
        people.add(new Person("王二麻子", 30, 8000));


        //我要拿到薪资最高的那个人的信息
        List<Person> result = people.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).collect(Collectors.toList());
        System.out.println("薪水最高的人是：" + result.get(0).getName() + "\n他的薪水是：" + result.get(0).getSalary());
    }
}
