
/**
 * @Name: AdjMartixGraph
 * @Desciption: 邻接矩阵
 * @Author: 易媛
 * @Date: 2017/07/28
 */

public class AdjMartixGraph {
    private int vecNum;
    private int vecMaxNum;
    private int acrNum;
    private int [][]arcs;
    private Integer []vertexes;
    private int []tag;

    public AdjMartixGraph(int vecNum, int vecMaxNum, Integer[] vertexes) {
        if(vecMaxNum < 0){
            throw new NumberFormatException("顶点数不得小于零!");
        }
        if (vecMaxNum < vecNum){
            throw  new NumberFormatException("顶点数目不得大于允许的最大顶点数!");
        }
        this.vecNum = vecNum;
        this.vecMaxNum = vecMaxNum;
        this.vertexes = vertexes;
        tag = new int[vecNum];
    }

    public AdjMartixGraph(int vecNum, int vecMaxNum, int[][] arcs, Integer[] vertexes) {
        this.vecNum = vecNum;
        this.vecMaxNum = vecMaxNum;
        this.arcs = arcs;
        this.vertexes = vertexes;
        tag = new int[vecNum];
    }

    /**
     * @Title: getOrder
     * @Description: 获取顶点d的序号
     * @Param: int d
     * @Return: int
     **/

    public int getOrder(int d){
        for (int v=0;v<vecNum;v++){
            if (vertexes[v] == d){
                return v;
            }
        }
        return -1;
    }

    /**
     * @Title: getElem
     * @Description: 获取序号为v的顶点
     * @Param: int v
     * @Return: int
     **/

    public int getElem(int v){
        if (v < 0 || v >= vecNum){
            return -1;
        }else{
            return vertexes[v];
        }
    }

    /**
     * @Title: setElem
     * @Description: 设置序号为v的顶点的值
     * @Param: int v, int d
     * @Return: int
     **/

    public boolean setElem(int v, int d){
        if (v < 0 || v >= vecNum){
            return false;
        }else{
            vertexes[v] = d;
            return true;
        }
    }

    /**
     * @Title: firstAdjVex
     * @Description: 顶点v的第1个邻接点的序号
     * @Param: int v, int d
     * @Return: int
     **/

    public int firstAdjVex(int v){
        if (v < 0 || v > vecNum){
            throw  new NumberFormatException("v is illegal!");
        }
        for (int u=0;u<vecNum;u++){
            if (arcs[v][u] != 0){
                return u;
            }
        }
        return -1;
    }

    /**
     * @Title: setElem
     * @Description: 顶点v1的相对于v2的下一个邻接点
     * @Param: int v1, int v2
     * @Return: int
     **/

    public int nextAdjVex(int v1, int v2){

        if (v1 < 0 || v1 >= vecNum)
            throw new NumberFormatException("v1不合法!");	// 抛出异常
        if (v2 < 0 || v2 >= vecNum)
            throw new NumberFormatException("v2不合法!");	// 抛出异常
        if (v1 == v2)
            throw new NumberFormatException("v1不能等于v2!");		// 抛出异常

        for (int u = v2 + 1; u < vecNum; u++)
            if (arcs[v1][u] != 0)
                return u;
        return -1;
    }

    /**
     * @Title: InsertVex
     * @Description: 插入值为d的顶点
     * @Param: int d
     * @Return: void
     **/

    public void InsertVex(int d){
        if (vecNum == vecMaxNum){
            throw new NumberFormatException("顶点数不得超过允许的最大顶点数!");
        }
        vertexes[vecNum]=d;

        tag[vecNum]=0;
        for (int v=0;v<vecNum;v++){
            arcs[vecNum][v]=0;
            arcs[v][vecNum]=0;
        }
        vecNum+=1;
    }

    /**
     * @Title: DeleteVex
     * @Description: 删除值为d的顶点
     * @Param: int d
     * @Return: void
     **/

    public void DeleteVex(int d){
        if (vecNum == 0){
            throw new NumberFormatException("无法删除空图!");
        }
        int v=0;
        for(v=0;v<vecNum;v++){
            if (vertexes[v] == d){
                break;
            }
        }
        if (v == vecNum){
            throw new NumberFormatException("不存在要删除的顶点!");
        }
        for (int u=0; u<vecNum;u++){
            if (arcs[v][u]==1){
                arcs[v][u] = 0;
                arcs[u][v] = 0;
                acrNum -= 2;
            }
        }
        vecNum -= 1;
        if (v < vecNum){
            vertexes[v]=vertexes[vecNum];
            tag[v]=tag[vecNum];
            for(int u=0; u <= vecNum; u++){
                arcs[u][v]=arcs[u][vecNum];
                arcs[v][u] = arcs[vecNum][u];
            }
        }
    }

    /**
     * @Title: DeleteVex
     * @Description: 删除顶点v1和v2之间的弧
     * @Param: int v1,int v2
     * @Return: void
     **/

    public void DeleteArc(int v1, int v2){
        if (v1 < 0 || v1 >= vecNum)
            throw new NumberFormatException("v1不合法!");	// 抛出异常
        if (v2 < 0 || v2 >= vecNum)
            throw new NumberFormatException("v2不合法!");	// 抛出异常
        if (v1 == v2)
            throw new NumberFormatException("v1不能等于v2!");		// 抛出异常

        if (arcs[v1][v2]!=0){
            acrNum -= 1;
            arcs[v1][v2] = 0;
        }
    }

    /**
     * @Title: getTag
     * @Description: 获取顶点v的标志
     * @Param: int v
     * @Return: int
     **/

    public int getTag(int v){
        if (v < 0 || v >= vecNum)
            throw new NumberFormatException("v1不合法!");	// 抛出异常
        return tag[v];
    }

    /**
     * @Title: setTag
     * @Description: 获取顶点v的标志
     * @Param: int v
     * @Return: int
     **/

    public void setTag(int v,int s){
        if (v < 0 || v >= vecNum)
            throw new NumberFormatException("v1不合法!");	// 抛出异常
        tag[v] = s;
    }

    public void showMartix(){
        System.out.println(vecNum);
        for (int v=0;v<vecNum;v++){
            for (int u=0;u<vecNum;u++){
                System.out.print(arcs[v][u]);
            }
            System.out.println();
        }
    }

    public int getVecNum() {
        return vecNum;
    }

    public void setVecNum(int vecNum) {
        this.vecNum = vecNum;
    }

    public int getVecMaxNum() {
        return vecMaxNum;
    }

    public void setVecMaxNum(int vecMaxNum) {
        this.vecMaxNum = vecMaxNum;
    }

    public int getAcrNum() {
        return acrNum;
    }

    public void setAcrNum(int acrNum) {
        this.acrNum = acrNum;
    }

    public Integer[] getVertexes() {
        return vertexes;
    }

    public void setVertexes(Integer[] vertexes) {
        this.vertexes = vertexes;
    }

    public int[] getTag() {
        return tag;
    }

    public void setTag(int[] tag) {
        this.tag = tag;
    }
}
