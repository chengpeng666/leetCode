package code;

import java.util.Arrays;

public class _5_最长回文子串 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("aaca"));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            Boolean[][] dp = new Boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
            int maxLen = 0;
            int lIndex = 0;
            int rIndex = 0;
            for (int i = 0; i < len; i++) {
                for (int j = len - 1; j > i; j--) {
                    if (dp[i][j] != null && dp[i][j]) {
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            lIndex = i;
                            rIndex = j;
                            break;
                        }
                    }
                }
            }
            return s.substring(lIndex, rIndex + 1);
        }
    }
}
