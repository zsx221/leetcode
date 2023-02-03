package xhd.practice.utils;

import cn.hutool.core.codec.Base64;
public class 时间戳验证 {
    //秘钥
    private static final String secret = "b1fb59a6950b4437af30e959a13af2b6";

    //时间格式
    private static final String TIME_STR = "FINANCE_%s_END";

    public static void main(String[] args) {
        String s = "FINANCE_20200405011211_END";
        System.out.println(enCode(s));
    }
//w5NLwrBiwpFgOT/CmsKHwrrCosKwwrzDgMKOYmOTEXfCsyJfNn0=
    public static String enCode(String s) {
        int[] arr = new int[256];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        byte[] sc = secret.getBytes();//秘钥字节数组
        char[] chars = new char[s.length()];
        char[] charArray = s.toCharArray();//需加密字符
        int t=0;
        for (int j = 0; j < arr.length; j++) {
             t = (j + arr[j] + sc[j % (sc.length - 1)]) % 256;
            arr[j] = t;
        }
        for (int i = 0, n = 0, m = 0; i < s.length(); i++,n++,m++) {
            n=(n+1)%256;
            m=(m+arr[n])%256;
            int temp=arr[n];
            arr[n]=arr[m];
            arr[m]=temp;
            chars[i] = (char) ((arr[n] + arr[m]) % 256);
            charArray[i] = (char) (charArray[i] ^ chars[i]);
        }
        return Base64.encode(new String(charArray));
    }
}
