import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by 易媛 on 2017/7/27.
 */


public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int root) {
        this.root = new TreeNode(root);
    }

    public TreeNode getRoot() {
        return root;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     * @Title: CreateBinaryTree
     * @Description: 根据先序和中序序列构造二叉树
     * @Param: 子树根节点,先序序列,中序序列,先序序列左端点,先序序列右端点,中序序列左端点,中序序列右端点.
     * @Return: TreeNode
     **/

    public TreeNode CreateBinaryTree(TreeNode root, int pre[], int in[], int pleft, int pright, int inleft,int inright) {
        if(inleft>inright){
            root = null;
        }else{
            root = new TreeNode(pre[pleft]);
            //System.out.println(root.data);
            int mid = inleft;
            //寻找根节点在中序序列中的位置
            while(in[mid] != pre[pleft]){
                mid++;
            }
            root.setLeft(CreateBinaryTree(root.left, pre, in,pleft+1, mid - inleft + pleft, inleft,mid-1));
            root.setRight(CreateBinaryTree(root.right, pre, in,mid - inleft  + pleft + 1, pright,mid + 1, inright));
        }
        return root;
    }

    public BinaryTree CreateBinaryTree(int pre[], int in[], int n){
        TreeNode root = null;
        root = CreateBinaryTree(root, pre, in, 0, n-1, 0, n-1);
        BinaryTree bt = new BinaryTree(root);
        return bt;
    }

    /**
     * @Title: PreOrder
     * @Description: 先序遍历以root为根节点的二叉树
     * @Param: 子树根节点.
     * @Return: void
     **/

    public void PreOrder(TreeNode root) {
        if (root != null){
            System.out.print(root.data + "\t");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    /**
     * @Title: InOrder
     * @Description: 中序遍历以root为根节点的二叉树
     * @Param: 子树根节点.
     * @Return: void
     **/

    public void InOrder(TreeNode root){
        if (root != null){
            InOrder(root.left);
            System.out.print(root.data + "\t");
            InOrder(root.right);
        }
    }

    /**
     * @Title: PostOrder
     * @Description: 中序遍历以root为根节点的二叉树
     * @Param: 子树根节点.
     * @Return: void
     **/

    public void PostOrder(TreeNode root){
        if (root != null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + "\t");
        }
    }

    /**
     * @Title: LevelOrder
     * @Description: 层序遍历
     * @Param: null.
     * @Return: boolean
     **/

    public ArrayList LevelOrder(){
        Queue<TreeNode> q = new ArrayDeque<>();
        ArrayList<Integer> level= new ArrayList<>();
        TreeNode p;
        if (root != null){
            q.add(root);
        }
        while (!q.isEmpty()){
            p = q.poll();
            level.add(p.data);
            System.out.print(p.data + "\t");
            if(p.left!=null)
                q.add(p.left);
            if(p.right!=null)
                q.add(p.right);
        }
        System.out.println();
        return level;
    }

    /**
     * @Title: Destroy
     * @Description: 删除以r为根节点的二叉树
     * @Param: 子树根节点.
     * @Return: void
     **/

    public void Destroy(TreeNode r){
        if(r != null){
            Destroy(r.left);
            Destroy((r.right));
            root = null;
        }
    }

    /**
     * @Title: Find
     * @Description: 查找
     * @Param: 子树根节点, 节点值.
     * @Return: TreeNode
     **/

    public TreeNode Find(TreeNode root, int key){
        if(root !=null) {
            if (root.data == key) return root;

            TreeNode t;

            t = Find(root.left, key);
            if (t != null) return t;

            t = Find(root.right, key);
            if (t !=null) return t;
        }
        return null;
    }

    /**
     * @Title: InsertLeft
     * @Description: 插入节点到左子树
     * @Param: 子树根节点, 节点值.
     * @Return: boolean
     **/

    public boolean InsertLeft(TreeNode left,int e){
        if(left == null){
            return false;
        }else{
            TreeNode leftchild = new TreeNode(e);
            if(left.left != null){
                leftchild.left=left.left;
            }
            left.left = leftchild;
            return true;
        }
    }

    /**
     * @Title: InsertRight
     * @Description: 插入节点到右子树
     * @Param: 子树根节点, 节点值.
     * @Return: boolean
     **/

    public boolean InsertRight(TreeNode right,int e){
        if (right == null){
            return false;
        }else{
            TreeNode rightchild = new TreeNode(e);
            if(right.right != null){
                rightchild.right = right.right;
            }
            right.right = rightchild;
            return true;
        }
    }

    /**
     * @Title: getParent
     * @Description: 获取指定结点的父节点
     * @Param: 子树根节点, 指定节点.
     * @Return: TreeNode
     **/

    public TreeNode getParent(TreeNode root, TreeNode child){
        if(root != null) {
            if (root.left == child || root.right == child) {
                return root;
            } else {
                TreeNode p;
                p = getParent(root.left, child);
                if(p!=null) {
                    return p;
                }

                p = getParent(root.right, child);
                if(p!=null) {
                    return p;
                }
            }
        }
        return null;
    }

    /**
     * @Title: getLeftBrother
     * @Description: 获取指定结点的左兄弟节点
     * @Param: 指定节点.
     * @Return: TreeNode
     **/

    public TreeNode getLeftBrother(TreeNode p){
        TreeNode rt=getParent(root,p);
        if(rt != null){
            if (rt.right == p) return rt.left;
        }
        return null;
    }

    /**
     * @Title: getRightBrother
     * @Description: 获取指定结点的右兄弟节点
     * @Param: 指定节点.
     * @Return: TreeNode
     **/

    public TreeNode getRightBrother(TreeNode p){
        TreeNode rt=getParent(root,p);
        if(rt != null){
            if (rt.left == p) return rt.right;
        }
        return null;
    }

    /**
     * @Title: nodeCount
     * @Description: 获取二叉树的节点数
     * @Param: 子树根节点.
     * @Return: int
     **/

    public int nodeCount(TreeNode root){
        if (root != null){
            return nodeCount(root.left)+nodeCount(root.right)+1;
        }else{
            return 0;
        }
    }

    /**
     * @Title: Height
     * @Description: 树的高度
     * @Param: 子树根节点.
     * @Return: int
     **/

    public int Height(TreeNode root){
        if (root != null){
            int LH,RH;
            LH = Height(root.left);
            RH = Height(root.right);
            return Math.max(LH,RH)+1;
        }else{
            return 0;
        }
    }

    /**
     * @Title: Broad
     * @Description: 树的宽度
     * @Param: 子树根节点.
     * @Return: int
     **/

    public int Broad(TreeNode root){
        ArrayList<Integer> counts = new ArrayList<>();
        if (root == null){
            return 0;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        counts.add(1);
        int i=0;
        int m = counts.get(0);
        int count=0;
        while (m > 0){
            TreeNode p;
            p = q.poll();
            m = m - 1;
            if(p.left!=null) {
                count = count + 1;
                q.add(p.left);
            }
            if(p.right!=null) {
                count = count + 1;
                q.add(p.right);
            }
            if(m == 0) {
                counts.add(count);
                int size = counts.size();
                m = counts.get(size - 1);
                count = 0;
            }
        }
        int max = 0;
        for (Integer item:counts
             ) {
            if (item > max){
                max = item;
            }
        }
        return max;
    }

}
