package String.demo;

public class String2 {
    public static void main(String[] args) {
        //1. StringBuffer 的直接父类是 AbstractStringBuilder
        //2. StringBuffer 实现了serializable 即StringBuffer 的对象可以串行化
        //3. 在父类中 AbstractStringBuilder 有属性char[] value （存放在堆中,该value数组 存放 字符串内容，引出存放在堆中的） 不是final
        //4. StringBuffer 是一个final类 不能被继承
        //5. 因为 StringBuffer 字符内容是存在 char[] value， 所有在变化（增加、删除）不用每次都更换地址（即不创建对象）。string就是修改地址，所以效率比string高

        // ============string和StringBuffer 转化==========
        String str = "hello tom";
        //方式1 使用构造器
        // 注意 ：返回的才是 StringBuffer 对象， 对 str 本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式2 使用的是 append 方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);


        StringBuilder stringBuffer3 = new StringBuilder("中文");
        String s = stringBuffer3.toString();
        System.out.println(s);
        String ss = new String(stringBuffer3);

        //=============StringBuilder============
        // 1. 一个可变的字符串序列，此类提供一个与 StringBuilder 兼容的Api 但不保证同步 （StringBuilder 不是线程安全）
        // 用子啊字符串缓冲区被单个线程使用的时候，如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快

        // 2. StringBuilder 上的主要操作是append 和 insert 方法，课重载这些方法 ，以接受人一类型的数据

        //=====================string StringBuffer StringBuilder 比较 P480=====================
        /*
            0. StringBuffer 和 StringBuilder 非常类似，均代表可变的字符序列（char []），而且方法也一样
            1. string 不可变字符序列，效率低， 但是复用率高，（都在常量池，不会有重复的），要频繁修改字符串，不要使用string，少修改，被多个对象引用，用string
            2. StringBuffer 可变字符序列、效率较高（增删） 线程安全，看源码
            3. StringBuilder 可变字符序列、效率最高（增删） 线程不安全 （确定是单线程，优先选用，否则脏读 幻读）
         */


    }
}
