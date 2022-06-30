package com.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * * 8 * 8de 棋盘，马按走棋的规则（马走日字）进行移动，要求每个放个只进入一次，走遍棋盘上全部64个方格
 * 骑士周游问题 （算法优化的意思）
 * 1. 创建棋盘 chessBoard 是二维数组
 * 2. 将当前位置设置为已经访问，然后根据当前位置，极端马尔还能走哪些位置，并放入到一个集合中ArrayList 最多有8个，每走一步，使用step+1
 * 3. 遍历ArrayList 中存放的所有位置， 看看那个可以走， 如果可以走通， 就继续，走不通就回溯
 * 4. 判断马尔是否完成了任务，使用step和应该走的步数比较，如果没有达到数量，则表示没有完成任务，将整个棋盘设置为0
 */
public class HorseChessBoard {

    private static int X = 6;// 表示col 图上是8行8列 现在是6行6列
    private static int Y = 6;// 表示row

    private static int[][] chessBoard = new int[Y][X];
    private static boolean[] visited = new boolean[X * Y]; // 记录某个位置是否走过
    private static boolean finished = false; //记录马儿是否遍历完棋盘


    /**
     * @param args
     */
    public static void main(String[] args) {
        int row = 6;
        int col = 4;

        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard , row -1, col -1, 1);
        long end = System.currentTimeMillis();

        System.out.println("遍历耗时："+ (end - start));

        for (int[] rows : chessBoard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    // 写一个方法，对ps的各个位置，可以走的下一个位置的次数进行排序，把可能走的下一个位置从小到大排序
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() -  next(o2).size(); //size 升序排
            }
        });
    }


    // 编写最核心的算法，遍历棋盘，如果棋盘，如果遍历成功，就把finished 设置为true
    // 并且，将木耳走的每一步step ，记录到chessBoard

    public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step) {

        //先把step 记录到  chessBoard
        chessBoard[row][col] = step;
        //把这个位置设置为已访问
        visited[row * X + col] = true; // 棋盘中的第几个点
        //获取当前这个位置可以走的下一个位置
        ArrayList<Point> ps = next(new Point(col, row));
        sort(ps);
        //遍历
        while (!ps.isEmpty()) {
            // 取出一个位置点
            Point p = ps.remove(0);
            //判断该位置是否走过， 如果没有走过， 我们就递归遍历
            if (!visited[p.y * X + p.x]) {
                // 递归遍历
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }

        // 当退出while ，看看是否 遍历成功，就重置相应的值，然后进行回溯
        if (step < X * Y && !finished) {
            //重置
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }


    }

    /**
     * 编写方法，可以获取当前位置，可以走的下一步的多有位置（point表示 x,y）
     *
     * @param curPoint
     * @return ArrayList
     */
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<>();
        //创建一个point对象（点/位置），准备放入到ps
        Point p1 = new Point();
        //判断在 curPoint是否可以走如下位置，如果可以走，就将该点 point 放入到ps

        //判断是否可以走5的位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }

        //判断是否可以走6的位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断是否可以走7的位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断是否可以走0的位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断是否可以走1的位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断是否可以走2的位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断是否可以走3的位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断是否可以走4的位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;

    }

}
