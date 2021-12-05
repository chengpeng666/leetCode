package code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20_有效的括号 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(()[]"));
    }

    private static class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>(16);
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            Map<Character, Character> map1 = new HashMap<>(16);
            map1.put(')', '(');
            map1.put(']', '[');
            map1.put('}', '{');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char curChar = s.charAt(i);
                if (map.containsKey(curChar)) {
                    stack.push(curChar);
                }else {
                    if(stack.empty()){
                        return false;
                    }else {
                        Character pop = stack.pop();
                        boolean equals = pop.equals(map1.get(curChar));
                        if(!equals){
                            return false;
                        }
                    }
                }
            }
            return stack.empty();
        }
    }
}
