package code;

import com.sun.deploy.util.ArrayUtil;
import org.junit.Test;

import java.util.*;

public class _15_三数之和 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return res;
            }
            Set<String> exist = new HashSet<>(16);
            for (int i = 0; i < nums.length; i++) {
                int firstNum = nums[i];
                this.find(nums, i + 1, nums.length - 1, 0 - firstNum, res, exist);
            }
            return res;
        }

        public void find(int[] nums, int start, int end, int sum, List<List<Integer>> res, Set<String> exist) {
            while (start < end) {
                int h = nums[start] + nums[end];
                if (h == sum) {
                    List<Integer> c = new ArrayList<>(3);
                    c.add(-sum);
                    c.add(nums[start]);
                    c.add(nums[end]);
                    String cStr = -sum + "" + nums[start] + "" + nums[end];
                    if (!exist.contains(cStr)) {
                        res.add(c);
                        exist.add(cStr);
                    }
                    start++;
                    end--;
                } else if (h < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
    }
}
