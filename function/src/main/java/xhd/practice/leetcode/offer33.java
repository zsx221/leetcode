package xhd.practice.leetcode;

import lombok.val;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class offer33 {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    //初步思想，比i小的都在i的左边，比i大的都在i的右边，符合则是后序，不符合return false
    public static boolean verifyPostorder(int[] postorder) {
        //思路，从左往右迭代，依次成为当前结点
        //从当前节点往左看，碰到比它小的后，就不能碰到比它大的
        boolean sign=false;
        for(int i=0;i<postorder.length;i++){
            for(int j=i;j>=0;j--){
                if(postorder[j]<postorder[i]){
                    //出现了比当前小的
                    sign=true;
                }
                //出现了比当前结点大的且之前已经出现了比当前结点小的
                if(sign==true&&postorder[j]>postorder[i])return false;
            }
            sign=false;
        }
        return true;
    }
}
