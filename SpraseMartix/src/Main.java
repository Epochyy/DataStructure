public class Main {

    public static void main(String[] args) {
        int [][]a={{0,1,2,0},
                   {1,0,0,3},
                   {0,2,0,0},
                   {2,0,0,3}};
        SpraseMartix sm=new SpraseMartix(4,4,a);
        int [][]b={{0,0,2,0},
                   {0,2,0,1},
                   {0,0,0,0},
                   {0,0,1,0}};
        SpraseMartix sm1=new SpraseMartix(4,4,b);
        sm=sm.addMartix(sm1);
        sm.showMartix();
        sm=sm.mutiplyMartix(sm1);
        sm.showMartix();
        sm=sm.transMartix();
        sm.showMartix();
        sm=sm.mutiplyMartix(sm1);
        sm.showMartix();
    }
}
