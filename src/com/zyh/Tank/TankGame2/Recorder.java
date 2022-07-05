package com.zyh.Tank.TankGame2;

import java.io.*;
import java.util.Vector;

/**
 * Author:zyh
 * Version:1.0
 * 记录游戏数据信息,IO交互
 */
public class Recorder {
    //我方坦克杀敌数
    private static int allKillEnemy = 0;
    //存储数据
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;
    //存档文件跟着工程走
    private static String filePath = "src\\tankGame.txt";
    public static String getFilePath() {
        return filePath;
    }

    public static int getAllKillEnemy() {
        return allKillEnemy;
    }

    public static void setAllKillEnemy(int allKillEnemy) {
        Recorder.allKillEnemy = allKillEnemy;
    }

    //杀敌数+1
    public static void addKillNum() {
        allKillEnemy++;
    }
    //读取数据
    private static BufferedReader bufferedReader = null;
    private static FileReader fileReader = null;

    private static Vector<Node> nodes = new Vector<>();
    public static Vector<Node> getInfo(){
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            //杀敌数
            allKillEnemy = Integer.parseInt(bufferedReader.readLine());
            //坦克信息,可能是多个
            String data = null;
            while((data= bufferedReader.readLine())!=null){
                String[] xyd = data.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }



    //获取敌方坦克集合
    private static Vector<EnemyTank> enemyTanks = null;
    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }
    //记录杀敌数和退出游戏时还存活着的坦克的位置
    public static void save() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //存储杀敌数
            bufferedWriter.write(allKillEnemy+"\r\n");
            //存储坦克信息
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank e = enemyTanks.get(i);
                if(e.isLive){
                    //bufferedWriter.write(e.getX()+" "+e.getY()+" "+e.getDirection()+"\n");
                    String data = e.getX()+" "+e.getY()+" "+e.getDirection();
                    bufferedWriter.write(data+"\r\n");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
