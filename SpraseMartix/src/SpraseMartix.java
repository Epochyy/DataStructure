import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by 易媛 on 2017/7/7.
 */
public class SpraseMartix {
    private int rows;
    private int cols;
    private ArrayList<Tuple> triTuple;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getElemByRC(int row,int col){
        int elem=-1;
        boolean flag=false;
        for (Tuple item:
             triTuple) {
            flag=false;
            if(item.getRow()==row && item.getCol()==col){
                elem=item.getElem();
                flag=true;
                break;
            }
        }
        return flag==true?elem:-100000;
    }

    public ArrayList<Tuple> getTriTuple() {
        return triTuple;
    }

    public void setTriTuple(ArrayList<Tuple> triTuple) {
        this.triTuple = triTuple;
    }

    public SpraseMartix(int rows, int cols, int mat[][]){
        this.rows=rows;
        this.cols=cols;
        triTuple=new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]!=0){
                    triTuple.add(new Tuple(i,j,mat[i][j]));
                }
            }
        }

    }

    public SpraseMartix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        triTuple=new ArrayList<>();
    }

    public SpraseMartix transMartix(){
        SpraseMartix b=new SpraseMartix(rows,cols);
        for (Tuple item:
             triTuple) {
            Tuple t=new Tuple(item.getCol(),item.getRow(),item.getElem());
            b.getTriTuple().add(t);
        }
        return b;
    }

    public SpraseMartix addMartix(SpraseMartix b){
        int row=-1;
        int col=-1;
        int elem=-1;
        if(b.getRows()!=rows||b.getCols()!=cols){
            throw new NumberFormatException();
        }
        SpraseMartix c=new SpraseMartix(rows,cols);
        for (Tuple item:
                triTuple) {
            c.getTriTuple().add(item);
        }
        for (Tuple item:
             b.getTriTuple()) {
            boolean flag=false;
            for (Tuple item1:
                 triTuple) {
                if(item.getRow()==item1.getRow()){
                    if(item.getCol()==item1.getCol()){
                        row=item1.getRow();col=item1.getCol();elem=item1.getElem()+item.getElem();
                        Tuple t=new Tuple(row,col,elem);
                        c.getTriTuple().add(t);
                        flag=true;
                        break;
                    }
                }
            }
            if(flag==false) {
                Tuple t = new Tuple(item.getRow(), item.getCol(), item.getElem());
                c.getTriTuple().add(t);
            }
        }
        return c;
    }

    public void showMartix(){
        int [][]a=new int[rows][cols];
        for (Tuple item:
             triTuple) {
            a[item.getRow()][item.getCol()]=item.getElem();
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public SpraseMartix mutiplyMartix(SpraseMartix b){
        SpraseMartix c = new SpraseMartix(rows,b.getCols());
        if(b.getRows()!=cols){
            throw new NumberFormatException();
        }else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < b.getCols(); j++) {
                    int elem=0;
                    for (int k = 0; k < cols; k++) {
                        int s = getElemByRC(i, k);
                        int t = b.getElemByRC(k, j);
                        if (s != -100000 && t != -100000) {
                            elem += s * t;
                          //  System.out.println(s+":"+t);
                        }
                    }
                    c.getTriTuple().add(new Tuple(i,j,elem));
                }
            }
        }
        return c;
    }
}
