import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {

    public static void main(String[] args) {
        BinaryTree bt =new BinaryTree();
        int []pre={1,2,3,4,5,6,7,8,9};
        int []in={3,2,5,4,1,7,8,6,9};
        bt = bt.CreateBinaryTree(pre,in,9);
        bt.PreOrder(bt.getRoot());
        System.out.println();
        bt.InOrder(bt.getRoot());
        System.out.println();
        bt.PostOrder(bt.getRoot());
        System.out.println();
        TreeNode p=bt.Find(bt.getRoot(),3);
        if(p == null){
            System.out.println("not find!");
        }else{
            System.out.println(p.getData());
        }
        TreeNode q=bt.Find(bt.getRoot(),8);
        TreeNode pa;
        pa = bt.getParent(bt.getRoot(),q);
        System.out.println(pa.getData());
        TreeNode rb;
        rb = bt.getRightBrother(pa);
        System.out.println(rb.getData());
        bt.InsertLeft(p,10);
        bt.PreOrder(bt.getRoot());
        System.out.println();
        bt.InsertRight(q,11);
        bt.PreOrder(bt.getRoot());
        System.out.println();
        bt.InOrder(bt.getRoot());
        System.out.println();
        bt.LevelOrder();
        System.out.println(bt.Height(bt.getRoot()));
        System.out.println(bt.Broad(bt.getRoot()));
    }
}
