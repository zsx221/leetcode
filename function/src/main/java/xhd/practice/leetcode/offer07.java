package xhd.practice.leetcode;


import java.util.Arrays;

public class offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length==0)
            return null;
        int index=0;
        for (int i=0;i<length; i++) {
            if (i==preorder[0]){
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(preorder[0]);
        root.left=buildTree(Arrays.copyOfRange(preorder,1,1+index),Arrays.copyOfRange(inorder,0,index));
        root.right=buildTree(Arrays.copyOfRange(preorder,1+index,length),Arrays.copyOfRange(inorder,index+1,length));
        return root;
    }

}
