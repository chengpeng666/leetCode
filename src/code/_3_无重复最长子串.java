package code;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口法
 */
public class _3_无重复最长子串 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }

    /**
     * 滑动窗口
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>(16);
            int L_Index = 0;
            int maxLength = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    //判断左边的指针坐标，分三种情况
                    /**
                     * 1、c是滑动窗口坐标范围内的值：左坐标变为范围内相同值的坐标数+1
                     * 2、c是滑动窗口坐标范围外的值：直接舍弃继续保持左坐标值
                     */
                    L_Index = Math.max(L_Index, map.get(c) + 1);
                }
                map.put(c, i);
                maxLength = Math.max(maxLength, i + 1 - L_Index);
            }
            return maxLength;
        }
    }
}