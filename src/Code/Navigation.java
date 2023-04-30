package Code;

import java.util.*;


public class Navigation {
    /*内部类*/
    private static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static class Node {//用于实现dijkstra()的一个类
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }



    private int verticesNum;
    private List<List<Edge>> adjacencyList;//储存图的边的邻接表

    /*根据V，创建、初始化adjacencyList。*/
    public Navigation(int verticesNum, BuildingsString V) {
        /*读入该行 结点的编号（即第一个数字），储存在source中*/
        this.verticesNum = verticesNum;
        this.adjacencyList = new ArrayList<>(verticesNum);

        for (int i = 0; i < verticesNum; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < 132; i++) {//在V.buildings中读入132次数据，每行对应一个结点的邻接链表
            int destination = -1;
            for (int j = 0; j < 4; j++) {
                /*读取该节点的上(j=0)下(j=1)左(j=2)右(j=3)的结点编号，储存在des中，若该方向上有边，则addEdge*/
                switch (j) {//设置终点
                    case 0:
                        destination = V.buildings[i].UpBuilding;
                        break;
                    case 1:
                        destination = V.buildings[i].DownBuilding;
                        break;
                    case 2:
                        destination = V.buildings[i].LeftBuilding;
                        break;
                    case 3:
                        destination = V.buildings[i].RightBuilding;
                        break;
                }

                if (destination != -1) {
                    /*该方向上有边，计算距离，再addEdge*/
                    addEdge(i, destination, V.getDistance(i, destination));
                }
            }
        }

    }

    /*添加一条从source到destination，边权为weight的边（有向边。*/
    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        this.adjacencyList.get(source).add(edge);

    }

    /*寻找source和destinatino之间的最短路径，返回值为一个数组，数组中储存的是最短路径经过的节点*/
    public int[] dijkstraWithPath(int source, int destination) {
        // 初始化距离数组和已访问节点集合
        int[] distances = new int[verticesNum];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[verticesNum];

        // 记录每个节点的前驱节点
        int[] prev = new int[verticesNum];
        Arrays.fill(prev, -1);

        // 将起点的距离初始化为0，并加入已访问节点集合中
        distances[source] = 0;
        visited[source] = true;

        // 构造优先队列，用于存储待访问节点及其从源节点到达的距离的信息
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        pq.offer(new Node(source, 0));

        // 直到优先队列为空或者找到了目标节点为止
        while (!pq.isEmpty()) {
            // 取出当前未访问节点集合中距离源节点最近的节点
            Node curr = pq.poll();
            visited[curr.vertex] = true;

            // 如果已经找到了目标节点，则跳出循环
            if (curr.vertex == destination) {
                break;
            }

            // 遍历当前节点的所有邻居节点
            for (Edge edge : adjacencyList.get(curr.vertex)) {
                int neighbor = edge.destination;
                if (!visited[neighbor]) {
                    // 更新从源节点到达当前邻居节点的最短距离
                    int newDistance = distances[curr.vertex] + edge.weight;
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        prev[neighbor] = curr.vertex;
                        pq.offer(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // 如果目标节点没有被访问过，则说明从源节点无法到达目标节点
        if (!visited[destination]) {
            return new int[0];
        }

        // 构造记录路径经过的所有节点的数组
        List<Integer> path = new ArrayList<>();
        int curr = destination;
        while (curr != -1) {
            path.add(curr);
            curr = prev[curr];
        }
        Collections.reverse(path);

        // 将路径转换为int数组并返回
        int[] result = new int[path.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = path.get(i);
        }

        return result;
    }


}
/*测试寻找两点之间的最短路径
public class test {
    public static void main(String[] args) {

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
    }
}
*/