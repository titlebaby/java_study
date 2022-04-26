package com.set;

import java.util.HashSet;
import java.util.Objects;

public class Hash_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        /**
         * hashset 底层是hashMap,第一次添加时，table数组扩容到16，临界值 threshold是 16*加载银子 loadFactor 是0.75 = 12
         * 如果table数组使用到了临界值 12 就会扩容到 16 * 2 = 32
         * 新的临界值就是 32 * 0.75 = 24 ,以此类推
         */
        HashSet<Object> hashSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            hashSet.add(i);
        }


        /**
         * 3. 在java8 中，如果一条链表的元素个数到到 8 ，并且 table 容量到达64 ，就会进行树化（红黑树）
         * 否则任然采用数组扩容
         */
        HashSet<Object> hashSet1 = new HashSet<>();
        for (int i = 0; i <= 12; i++) {
            hashSet1.add(new A(i));
        }
        System.out.println(hashSet1);

        /**
         * P 526 思考题
         */

    }
    static class A {
        private int n;

        public A(int n) {
            this.n = n;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            A a = (A) o;
//            return n == a.n;
//        }

        @Override
        public int hashCode() {
            return 100;
        }
    }
}
