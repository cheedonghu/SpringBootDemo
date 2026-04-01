package com.east.demo.other.algorithm.backtrace.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * num:22
 *
 * @author: east
 * @date: 2024/1/15
 */
public class GenerateParentheses {

    /**
     * 排列组合？-> 回溯（另类穷举）：
     * 状态 : List<char>
     * 所有选择？ n对括号， 转换为{(,)}数组，只需要'(',')'即可，通过valid和n来限制合法
     * 结果 List<String>
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<Character> choices = new ArrayList<>();
        choices.add('(');
        choices.add(')');
//        for (int i = 0; i < n; i++) {
//            choices.add(')');
//            choices.add('(');
//        }
        backtrack(new ArrayList<Character>(), choices, res, n);
        return res;
    }

    public void backtrack(List<Character> state, List<Character> choices, List<String> res, int n) {
        if (isSolution(state, n, res)) {
            recordSolution(state, res);
            return;
        }

        for (int i = 0; i < choices.size(); i++) {
            if (isValid(state, choices.get(i), n)) {
                updateState(state, choices.get(i));
                backtrack(state, choices, res, n);
                undoChoice(state);
            }
        }

    }

    private void undoChoice(List<Character> state) {
        state.remove(state.size() - 1);
    }

    private void updateState(List<Character> state, Character s) {
        state.add(s);
    }

    /**
     * 剪枝, 校验当前选择是否合法：
     * 1. ( 和 )出现次数不能大于n
     * 2. 总数不大于2n
     * 3. 第一个不能是）
     * 4.
     */
    private boolean isValid(List<Character> originState, Character choice, int n) {
        ArrayList<Character> state = new ArrayList<>(originState);
        state.add(choice);
        boolean judge3 = state.get(0) == ')';

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) == '(') {
                count1++;
            } else {
                count2++;
            }
        }
        return !judge3 && state.size() <= 2 * n && count1 <= n && count2 <= n;
    }

    private void recordSolution(List<Character> state, List<String> res) {
        String string = state.stream().map(String::valueOf).collect(Collectors.joining());
        res.add(string);
    }

    /**
     * 校验当前状态是否是结果:
     * 1. state数量达到2*n
     * 2. state满足well-formed
     * 3. res不包含state(去重)
     *
     * @return
     */
    private boolean isSolution(List<Character> state, int n, List<String> res) {
        boolean judge1 = state.size() == n * 2;
//        boolean judge2=judgeWellFormed(state);
        String string = state.stream().map(String::valueOf).collect(Collectors.joining());
        boolean judge3 = !res.contains(string);

        return judge1 && judgeWellFormed(state) && judge3;
    }

    /**
     * 判断括号是否合法： 用双指针：找到第一个紧临的()，去掉，然后继续找，直到能全去掉
     */
    private boolean judgeWellFormed(List<Character> characters) {
//        List<Character> charArray = state.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
        ArrayList<Character> charArray = new ArrayList<>(characters);
        boolean findIt = true;

        do {
            for (int i = 0; i < charArray.size() - 1; i++) {
                char char1 = charArray.get(i);
                char char2 = charArray.get(i + 1);
                if (char1 == '(' && char2 == ')') {
                    charArray.remove(i);
                    charArray.remove(i);
                    findIt = true;
                    break;
                } else {
                    findIt = false;
                }
            }
        } while (findIt && !charArray.isEmpty());

        return charArray.isEmpty();

    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();

        // 测试合法括号
//        ArrayList<Character> characters = new ArrayList<>();
//        String state="()())(";
//        List<Character> charArray = state.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
//        boolean b = generateParentheses.judgeWellFormed(charArray);
//        System.out.println(b);

        // 测试contains
//        String state="()()()";
//        List<Character> charArray = state.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
//        List<String> res=new ArrayList<>();
//        res.add("()()()");
//        generateParentheses.isSolution(charArray,3,res);

        // 测试
        long start = System.currentTimeMillis();
        List<String> res = generateParentheses.generateParenthesis(3);
        System.out.println("耗时" + (System.currentTimeMillis() - start) / 1000 + "s");

        res.forEach(System.out::println);

    }
}
