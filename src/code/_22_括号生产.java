package code;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生产 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);

    }

    static class Solution {
        public List<String> res = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            deep(0, 0, "", n);
            return res;
        }

        private void deep(int leftNum, int rightNum, String s, int n) {
            if (rightNum + leftNum == n * 2) {
                if (rightNum == leftNum) {
                    res.add(s);
                } else {
                    return;
                }
            } else {
                if (leftNum < n) {
                    deep(leftNum + 1, rightNum, s + "(", n);
                }
                if (rightNum < leftNum) {
                    deep(leftNum, rightNum + 1, s + ")", n);
                }
            }
        }
    }
}
