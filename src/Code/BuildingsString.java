package Code;
//本类调用类Building，根据文件map.txt,创建、初始化一个顶点的数组

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuildingsString {
    Building[] buildings;

    public void initBuildingString() {
        this.buildings = new Building[132];// 一共132个顶点
        //读取Map.txt文件
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/张劭杰/Desktop/数据结构/学生课程管理系统/map/Map.txt"));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                String[] data = line.split("\t");
                Building building = new Building();
                building.Number = Integer.parseInt(data[0]);
                building.Name = data[1];
                building.LogicX = Integer.parseInt(data[2]);
                building.LogicY = Integer.parseInt(data[3]);
                building.ActualX = Integer.parseInt(data[4]);
                building.ActualY = Integer.parseInt(data[5]);
                building.UpBuilding = Integer.parseInt(data[6]);
                building.DownBuilding = Integer.parseInt(data[7]);
                building.LeftBuilding = Integer.parseInt(data[8]);
                building.RightBuilding = Integer.parseInt(data[9]);
                building.OtherFirst = Double.parseDouble(data[10]);
                building.OtherSecond = Integer.parseInt(data[11]);
                building.OtherThird = Integer.parseInt(data[12]);
                this.buildings[i] = building;
                i++;
                line = reader.readLine();
            }
            reader.close();
            // 输出测试
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getDistance(int start, int end) {//寻找两点之间逻辑位置的距离
        if (buildings[start].LogicX == buildings[end].LogicX) {//X坐标相同，取Y差值
            return Math.abs(buildings[start].LogicY - buildings[end].LogicY);
        } else if (buildings[start].LogicY == buildings[end].LogicY) {//Y坐标相同，取X差值
            return Math.abs(buildings[start].LogicX - buildings[end].LogicX);
        } else {
            System.out.println("两坐标不相邻");
            return -1;
        }
    }
}
