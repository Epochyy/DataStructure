public class Main {

    public static void main(String[] args) {
        Integer []v = {1,2,3,4,5};
        int [][]a={{0,0,0,1,0},
                   {1,0,0,0,1},
                   {0,0,1,0,0},
                   {0,0,1,1,0},
                   {1,0,0,0,0}};
        AdjMartixGraph am = new AdjMartixGraph(5,10, a, v);
        am.showMartix();
        am.DeleteArc(1,0);
        am.showMartix();
    }
}
