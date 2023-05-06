package Code;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        /*//计时功能测试
        SimulatedTimeSystem T = new SimulatedTimeSystem();
        T.setRate(20);

        Time alarmtime1 = new Time(0, 2, 10);*//*第0周，周2，10点*//*
        T.alarmQueue.addAlarm(alarmtime1, "快点动手数据结构课设");

        Time alarmtime2 = new Time(0, 5, 14);*//*第0周，周5，14点*//*
        T.alarmQueue.addAlarm(alarmtime2, "快点动手数电课设");

        Time alarmtime3 = new Time(1, 3, 16);*//*第1周，周3，16点*//*
        T.alarmQueue.addAlarm(alarmtime3, "快点动手计网课设");

        T.start();
        */

        /*//Navigation点对点寻找最短路径功能测试
        BuildingsString V = new BuildingsString();
        V.initBuildingString();//V是一个将文件中的地图信息以数组形式储存在数组中

        Navigation Graph = new Navigation(132, V);//初始化图

        Scanner cin = new Scanner(System.in);
        System.out.println("请输入起点：");
        int start = cin.nextInt();
        System.out.println("请输入终点：");
        int end = cin.nextInt();

        System.out.println("两点之间最短路径为：");
        int[] str = Graph.dijkstraWithPath(start, end);//寻找从start到end的最短路径，储存在str中

        for (int i = 0; i < str.length; i++) {//输出最短路径
            System.out.print(V.buildings[str[i]].Name + " ");
        }
        System.out.println("");
        */

        //Navigation多路寻找最短路径功能测试
        BuildingsString V = new BuildingsString();
        V.initBuildingString();//V是一个将文件中的地图信息以数组形式储存在数组中

        Navigation Graph = new Navigation(132, V);//初始化图

        Scanner cin = new Scanner(System.in);
        System.out.println("请输入起点：");
        int start = cin.nextInt();
        System.out.println("请输入所有目的地：");
        int[] des=new int[5];
        for (int i = 0; i < des.length; i++) {
            des[i]=cin.nextInt();
        }

        System.out.println("经过这些目的地，并最终回到起点的最短路径为：");
        int[] str = Graph.findPath(start, des);//寻找从start到end的最短路径，储存在str中

        for (int i = 0; i < str.length; i++) {//输出最短路径
            System.out.print(V.buildings[str[i]].Name + "\n");
        }
        System.out.println("");
    }
}
