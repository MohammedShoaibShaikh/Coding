package Trees;
import java.util.ArrayList;
import java.util.Vector;
public class TreeNode<T> {
    T data;
    Vector<TreeNode> Child = new Vector<>();
    TreeNode(T data){
        this.data = data;
    }

}
