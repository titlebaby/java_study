package com.tankgame03;


import org.w3c.dom.Node;

import java.io.*;
import java.util.Vector;

/**
 * 用户记录相关信息，和文件的交互
 * 1. 该类记录我方击毁敌方坦克数
 * 2. 当游戏结束，将数据写入到文件（IO） myRecord.txt
 * 3. 退出游戏 记录敌方坐标和方向
 * 4. 将每个敌人信息，回复成Node对象 =>Vector
 */
@SuppressWarnings("all")
public class Recorder {
    //定义变量，记录我方击毁的敌人坦克数
    private static int allAEnemyTankNum = 0;
    //io对象，准备写数据到文件
    private static FileWriter fw = null;
    private static BufferedReader br = null;
    private static BufferedWriter bw = null;
    private static  String recordFile = "e:\\myRecord.txt";
//    private static  String recordFile = "src:\\myRecord.txt";

    private static Vector<EnemyTank> enemyTanks= null;

    private static Vector<Node> nodes = new Vector<>();



    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    /**
     * 回复原来坦克的位置
     * @return
     */
//    public static Vector<Node> getNodesAndEnemyTankRec(){
//        try {
//            br = new BufferedReader(new FileReader(recordFile));
//            allAEnemyTankNum = Integer.parseInt(br.readLine());
//            //循环读取文件，生成nodes集合
//            String line = ""; // 255 40 0
//            while ((line = br.readLine()) != null) {
//                String[] xyd = line.split(" ");
//                Node node = new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),
//                        Integer.parseInt(xyd[2]));
//                nodes.add(node);
//
//
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (br != null) {
//                    br.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

    //当游戏退出时 将数据保存在文件中
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allAEnemyTankNum+"\r\n");
            bw.newLine();
            //遍历敌人坦克的Vector
            //OOP 定义一个属性，然后通过set得到敌人坦克
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isLive) {
                    //保存该坦克的信息
                    String record = enemyTank.getX()+" "+ enemyTank.getX()+ ""+ enemyTank.getDirect();
                    bw.write(record+"\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static int getAllAEnemyTankNum(){
        return allAEnemyTankNum;
    }

    public static void setAllAEnemyTankNum(int allAEnemyTankNum) {
        Recorder.allAEnemyTankNum = allAEnemyTankNum;
    }

    public static void addAllAEnemyTankNum(){
        Recorder.allAEnemyTankNum++;
    }
}
