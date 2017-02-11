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
        System.out.println(reverse(""));
    }
}
