package com.demo;

import java.util.Arrays;
import java.util.Comparator;

public class SortObjectAtrr {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("红楼梦2", 9);
        books[2] = new Book("红楼梦33", 500);
        books[3] = new Book("红楼梦444", 30);
        // 1 price 从小到大
        Arrays.sort(books, new Comparator<Book>() {
            //这里的o1 o2 是book对象
            @Override
            public int compare(Book o1, Book o2) {

                double diffPrice =  o1.getPrice() - o2.getPrice(); // compare 相当于实现 冒泡排序的交换规则 if条件
                if(diffPrice > 0) {
                    return 1; // 返回大于0 的则交换,则第一数大(左边)的,变到的右边,则从小到大
                } else if (diffPrice < 0) {
                    return -1; //小于0 的则可
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));

        // 按照书名的长度来进行排序  从大到小
        Arrays.sort(books, new Comparator<Book>() {
            //这里的o1 o2 是book对象
            @Override
            public int compare(Book o1, Book o2) {

                 return o1.getName().length() - o2.getName().length(); //o1 o2 谁大谁交换,往做交换则由大到小,往右走就从小到大

            }
        });
        System.out.println(Arrays.toString(books));
    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
