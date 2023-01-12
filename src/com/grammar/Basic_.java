package com.grammar;

public class Basic_ {
    public static void main(String[] args) {
        String book1 = "天龙八部";
        String book2 = "笑傲江湖";
        System.out.println(book1 + book2);
        //
        char c1 = '男';
        char c2 = '女';
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(Integer.valueOf(c1));
        System.out.println(Integer.valueOf(c2));
        System.out.println(c1 + c2); // 得到的是 男字符码值 + 女 字符码 值

        double price1 = 123.56;
        double price2 = 100.56;
        System.out.println(price1 + price2);


        String name = "jack";
        int age = 20;
        double score = 80.9;
        char gender = '男';
        String hobby = "打篮球";
        System.out.println("姓名\t年龄\t成绩\t性别\n" +
                name + "\t" + age + "\t" + score + "\t" + gender);


        System.out.println("===============");
        System.out.println(10 / 4); // 2 int
        System.out.println(10.0 / 4); // 2.5 因为10.0是double （被自动换成最大的精度容量）
        double d = 10 / 4;
        System.out.println(d); // 2.0 因为int/int 还是int，又把int赋值给double，如double n = 2;

        // % 取模，取余
        // 在 % 的本质，看一个公式 a % b = a-a / b*b
        //

        System.out.println(10 % 3);
        System.out.println(-10 % 3); // -10-(-10)/3*3 = -10+9 =-1
        System.out.println(10 % -3); // 10-10/(-3)* (-3) =10-9= 1
        System.out.println(-10 % -3); // -1= (-10) -(-10)/ （-3） * （-3）

        System.out.println("========自增=======");

        int i = 10;
        i++; // 自增 等价于 i = i+1;
        ++i; // 自增 等价于 i = i+1;
        // 独立使用前++和后++ 都一样
        System.out.println(i);

        int j = 8;
        int k = ++j; // 等价于 j=j+1; k=j;
        System.out.println("k="+k + "j="+j);

        int jj = 8;
        int kk = jj++; // 等价于 kk = jj ; jj = jj +1;
        //作为表达式使用 ，前++ 优先级别大于赋值， 后++优先级小于赋值
        System.out.println("k="+kk + "j="+jj);

        int t =1;
        t = t++; //规则使用临时变量 （1）temp =t ; (2) t= t+1; (3) t= temp
        System.out.println(t);

        int v =1;
        v = ++v; //规则使用临时变量 （1) t= t+1; () temp =t ; (3) t= temp
        System.out.println(v);



    }
}
