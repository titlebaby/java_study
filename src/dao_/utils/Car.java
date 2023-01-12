package dao_.utils;

public class Car {
    public int age;
    public static void main(String[] args) {
        // 类是模板（抽象），对象是具体的
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());
        Class<? extends Car> aClass = car1.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader); //AppClassLoader
        System.out.println(classLoader.getParent()); //ExtClassLoader
        System.out.println(classLoader.getParent().getParent()); //null 1.不存在 2. java程序获取不到~
    }
}
