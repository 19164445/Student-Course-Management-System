package Code;

public class BuildingsString {
    Building[] str = new Building[132];

    public void initBuildingString() {
        for(int i=0;i<=131;i++){
            //突然想到的，仅供参考
            //如果不能做到一行的内容分个读取，可以尝试将一行的数据全部读取出来，先存入Str1中，
            // 然后用spilt方法，将串根据“\t”分割，再将分隔后字符串的各个内容转化为int等需要的数据类型
            /*this.str[0].Name = "北门";
            this.str[0].LogicX = 162;
            this.str[0].LogicY = 658;
            this.str[0].ActualX = 162;
            this.str[0].ActualY = 658;
            this.str[0].Upbuilding = -1;
            this.str[0].DownBuilding = 2;
            this.str[0].LeftBuilding = -1;
            this.str[0].RightBuilding = -1;*/


        }
    }
}
