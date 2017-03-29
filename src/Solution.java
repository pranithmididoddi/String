import java.util.*;

/**
 * Created by Pranith on 2/11/17.
 */
public class Solution {

    public static String reverse(String string) {
        String[] result = string.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = result.length - 1; i >= 0; i--) {
            if (!result.equals("")) {
                sb.append(result[i]).append(" ");
            }

        }


        if (sb.length() == 0) return "";

        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
//        String str="hel'lo th:'is!@#$ is pranith";
//        /**using regular expressions and converting a string to character array*/
//        str=str.replaceAll("[^a-zA-Z0-9]","");
//        char[] ch=str.toCharArray();
//        System.out.println(Arrays.toString(ch));
//        /**[h, e, l, l, o, t, h, i, s, i, s, p, r, a, n, i, t, h]*/

        int string = 345;
        System.out.println(String.valueOf(string));


    }

    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != ch[ch.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public String reverseString(String s) {

        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public int romanToInt(String s) {

        if (s.length() == 0 || s == null) return 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();


        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        result = map.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i + 1)) <= map.get(s.charAt(i)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));

        }

        return result;
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }

        return sb.toString();
    }

    public int myAtoi(String str) {

        str = str.trim();
        if (str.length() == 0 || str == null) return 0;
        char flag = '+';

        int i = 0;
        double result = 0;

        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;


        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    public String validIPAddress(String IP) {
        if (IP.length() == 0) return "Neither";
        if (IPV4Check(IP)) return "IPv4";

        if (isIP6(IP)) return "IPv6";

        return "Neither";
    }

    public boolean IPV4Check(String str) {
        if (str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.') return false;
        String[] temp = str.split("\\.");
        if (temp.length != 4) return false;

        for (int i = 0; i < temp.length; i++) {
            try {
                if (temp[i].startsWith("0") && temp[i].length() > 1) return false;
                if (Integer.parseInt(temp[i]) > 255 || temp[i].charAt(0) == '-' || temp[i].charAt(0) == '+')
                    return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public boolean isIP6(String IP) {
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return false;
        String[] temp = IP.split(":");
        if (temp.length != 8) return false;
        for (int i = 0; i < 8; i++) {
            if (temp[i].length() > 4 || temp[i].length() == 0) return false;
            for (int j = 0; j < temp[i].length(); j++) {
                if ((temp[i].charAt(j) >= '0' && temp[i].charAt(j) <= '9') || (temp[i].charAt(j) >= 'a' && temp[i].charAt(j) <= 'f') || (temp[i].charAt(j) >= 'A' && temp[i].charAt(j) <= 'F')) {
                } else return false;
            }
        }
        return true;
    }

    public String reverseVowels(String s) {

        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');


        char[] my = s.toCharArray();

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (!list.contains(my[i])) {
                i++;
                continue;
            }

            if (!list.contains(my[j])) {
                j--;
                continue;
            }

            char temp = my[i];
            my[i] = my[j];
            my[j] = temp;

            i++;
            j--;


        }

        return new String(my);

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();

        for (int i = 1; i < 4 && i < length - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < length - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < length; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, length);

                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);

                    }
                }
            }
        }
        return result;
    }

    public boolean isValid(String string) {
        int length = string.length();

        if (length > 3 || length == 0 || (string.charAt(0) == '0' && length > 1) || Integer.parseInt(string) > 255)
            return false;

        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            array[magazine.charAt(i) - 'a']++;
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            if (--array[ransomNote.charAt(j) - 'a'] < 0) return false;
        }

        return true;
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = 0;

            if (i >= 0 && a.charAt(i) == '1') {
                sum++;
            }

            if (j >= 0 && b.charAt(j) == '1') {
                sum++;
            }

            sum += carry;

            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }

            sb.insert(0, (char) ((sum % 2) + '0'));

            i--;
            j--;
        }

        if (carry == 1)
            sb.insert(0, '1');

        return sb.toString();
    }

    public String addBinary(String a, String b) {

        StringBuffer sb = new StringBuffer();

        int pa = a.length() - 1;
        int pb = b.length() - 1;


        int flag = 0;

        while (pa >= 0 || pb >= 0) {
            int va = 0;
            int vb = 0;

            if (pa >= 0) {
                va = a.charAt(pa) == '0' ? 0 : 1;
                pa--;
            }

            if (pb >= 0) {
                vb = b.charAt(pb) == '0' ? 0 : 1;
                pb--;
            }

            int sum = va + vb + flag;

            if (sum >= 2) {
                sb.append(String.valueOf(sum - 2));
                flag = 1;
            } else {
                flag = 0;
                sb.append(String.valueOf(sum));

            }
        }
        if (flag == 1) {
            sb.append("1");
        }

        StringBuffer reverse = sb.reverse();

        return reverse.toString();
    }

    /**
     * Group Anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String result = new String(chars);

            if (map.containsKey(result)) {
                map.get(result).add(str);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(result, al);
            }
        }
        List<List<String>> list = new ArrayList<>();
        list.addAll(map.values());

        return list;
    }

    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[n1.length() + n2.length()];

        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            sb.append(mod);

        }
        sb.reverse();

        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }


    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();

        if (digits == null || digits.equals("")) {
            return result;
        }

        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();
        helper(map, digits, sb, result);

        return result;
    }

    private static void helper(Map<Character, char[]> map, String digits, StringBuilder sb, ArrayList<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(map, digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> string=new ArrayList<>();
        String s="";
        helper(string,s,n,n);

        return string;
    }

    public void helper(List<String> string, String s, int left, int right){
        if(left>right)
            return;

        if(left==0 && right==0){
            string.add(s);
            return;
        }

        if(left>0){
            helper(string,s+"(",left-1,right);
        }

        if(right>0){
            helper(string,s+")",left,right-1);
        }
    }

}
