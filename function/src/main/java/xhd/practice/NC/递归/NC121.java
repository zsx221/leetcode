package xhd.practice.NC.递归;

import lombok.val;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class NC121 {
//    char[] array ;
//    char[] head ;
//    ArrayList<String> list;
//    public ArrayList<String> Permutation(String str) {
//        /**
//         * 1、把str变成一个数组
//         * 2、让数组的一个指针指向现在的地方,然后跟其他数组的字符进行交换
//         * 3、一个指针往后走
//         */
//        array = str.toCharArray();
//        head=str.toCharArray();
//        int x=0;
//        list=new ArrayList<>();
//        list.add(str);
//        swap(x);
//        return list;
//    }
//   public  void swap(int x){
//        if (x==array.length) {
//            return;
//        }
//        char one=array[x];//a
//       for (int i=x+1;i<array.length;i++)
//       {
//           array=head;
//           array[x]=array[i];
//           array[i]=one;
//           list.add(String.valueOf(array));
//       }
//       swap(++x);
//   }
        public ArrayList<String> Permutation(String str) {
            StringBuilder buffer = new StringBuilder(str);
            ArrayList<String> list = PermutationHelp(buffer);
            ArrayList<String> list2 = new ArrayList<String>(new HashSet<String>(list));
            Collections.sort(list2);
            return list2;
        }
    public ArrayList<String> PermutationHelp(StringBuilder str){
        ArrayList<String> result = new ArrayList<>();
        if (str.length()==1){
            result.add(str.toString());
        }else {
            for (int i=0;i<str.length();i++){
                char temp = str.charAt(i);
                str.setCharAt(i,str.charAt(0));
                str.setCharAt(0,temp);
                ArrayList<String> arrayList = PermutationHelp(new StringBuilder(str.substring(1)));

                for (int j=0;j<arrayList.size();j++){
                    result.add(str.substring(0,1)+arrayList.get(j));
                }
                temp=str.charAt(0);

                str.setCharAt(0,str.charAt(i));
                str.setCharAt(i,temp);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        NC121 n=new NC121();
        System.out.println(n.Permutation("abc"));
    }
}

