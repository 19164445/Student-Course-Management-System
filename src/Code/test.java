package Code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        BuildingsString V = new BuildingsString();
        V.initBuildingString();
        Navigation Graph = new Navigation(132, V);//初始化图

        Scanner cin = new Scanner(System.in);
        System.out.println("请输入起点：");
        int start = cin.nextInt();
        System.out.println("请输入终点：");
        int end = cin.nextInt();

        System.out.println("两点之间最短路径为：");
        int[] str=Graph.dijkstraWithPath(start,end);
        for (int i = 0; i < str.length; i++) {
            System.out.print(V.buildings[str[i]].Name+" ");
        }
        System.out.println("");
    }
}
