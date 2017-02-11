import java.util.Arrays;

/**
 * Created by Pranith on 2/11/17.
 */
public class Solution {

    public static String reverse(String string){
        String[] result=string.split(" ");
        StringBuffer sb=new StringBuffer();

        for(int i=result.length-1;i>=0;i--){
            if(!result.equals("")){
                sb.append(result[i]).append(" ");
            }

        }



        if(sb.length()==0) return "";

    return sb.substring(0,sb.length()-1);
    }

    public static void main(String[] args){
//        String str="hel'lo th:'is!@#$ is pranith";
//        /**using regular expressions and converting a string to character array*/
//        str=str.replaceAll("[^a-zA-Z0-9]","");
//        char[] ch=str.toCharArray();
//        System.out.println(Arrays.toString(ch));
//        /**[h, e, l, l, o, t, h, i, s, i, s, p, r, a, n, i, t, h]*/

        int string=345;
        System.out.println(String.valueOf(string));



    }

    public boolean isPalindrome(String s) {

        s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        char[] ch=s.toCharArray();

        for(int i=0;i<ch.length;i++){
            if(ch[i]!=ch[ch.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
