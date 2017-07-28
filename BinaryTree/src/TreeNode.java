/**
 * Created by 易媛 on 2017/7/27.
 */
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, int left, int right) {
        this.data = data;
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
