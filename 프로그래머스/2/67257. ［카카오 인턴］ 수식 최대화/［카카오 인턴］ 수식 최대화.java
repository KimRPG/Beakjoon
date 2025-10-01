import java.util.*;

class Solution {
    public char[][] oper = {
        {'+','-','*'},
        {'+','*','-'},
        {'-','+','*'},
        {'-','*','+'},
        {'*','-','+'},
        {'*','+','-'}
    };

    public long solution(String expression) {
        long answer = 0;

        List<Long> baseNums = new ArrayList<>();
        List<Character> baseOps = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                baseNums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                baseOps.add(c);
            }
        }
        baseNums.add(Long.parseLong(sb.toString()));
        for (char[] precedence : oper) {
            List<Long> nums = new ArrayList<>(baseNums);
            List<Character> ops = new ArrayList<>(baseOps);

            for (char op : precedence) {
                int i = 0;
                while (i < ops.size()) {
                    if (ops.get(i) == op) {
                        long a = nums.get(i);
                        long b = nums.get(i + 1);
                        long res = applyOp(a, b, op);

                        nums.set(i, res);
                        nums.remove(i + 1);
                        ops.remove(i);
                    } else {
                        i++;
                    }
                }
            }

            long val = Math.abs(nums.get(0));
            if (val > answer) answer = val;
        }

        return answer;
    }

    private long applyOp(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        throw new IllegalArgumentException("Unknown op: " + op);
    }

}
