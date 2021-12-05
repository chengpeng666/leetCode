package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _17_电话号码的组合 {
    //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
    //这里也可以用map，用数组可以更节省点内存
    //最终输出结果的list
    List<String> res = new ArrayList<>();
    String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        //注意边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }


    //递归函数
    void iterStr(String str, StringBuilder letter, int index) {
        //递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
        //动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
        //而用index记录每次遍历到字符串的位置，这样性能更好
        if (index == str.length()) {
            res.add(letter.toString());
            return;
        }
        //获取index位置的字符，假设输入的字符是"234"
        //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
        //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
        char c = str.charAt(index);
        //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
        int pos = c - '0';
        String map_string = letter_map[pos];
        //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
        for (int i = 0; i < map_string.length(); i++) {
            //调用下一层递归，用文字很难描述，请配合动态图理解
            letter.append(map_string.charAt(i));
            //如果是String类型做拼接效率会比较低
            //iterStr(str, letter+map_string.charAt(i), index+1);
            iterStr(str, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }

    public List<String> letterCombinations_duilie(String digits) {
        //注意边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Queue<String> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < letter_map[Integer.valueOf(digits.charAt(0) + "")].length(); i++) {
            list.add(letter_map[Integer.valueOf(digits.charAt(0) + "")].charAt(i) + "");
        }
        for (int i = 0; i < digits.length(); i++) {
            String curLetter = letter_map[Integer.valueOf(digits.charAt(i) + "")];
            while (!queue.isEmpty()) {
                String s = queue.poll();
                for (int j = 0; j < curLetter.length(); j++) {
                    list.add(s + curLetter.charAt(j));
                }
            }
            list.forEach(l -> queue.add(l));
            if (i == digits.length() - 1) {
                res = list;
            }else {
                list.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _17_电话号码的组合 c = new _17_电话号码的组合();
        System.out.println(c.letterCombinations_duilie("23"));
    }
}
