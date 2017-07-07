/**
 * Created by 易媛 on 2017/7/7.
 */
public class Tuple {
    private int row;
    private int col;
    private int elem;

    public Tuple(int row, int col, int elem) {
        this.row = row;
        this.col = col;
        this.elem = elem;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

}
