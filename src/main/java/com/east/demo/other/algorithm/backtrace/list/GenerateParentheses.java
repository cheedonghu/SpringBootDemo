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

    /**
     * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
     * 组合->穷举回溯
     * 思路1：N叉树回溯
     * 公式
     * 可选集合: ["(",")"] * n
     * 是否是解：状态string的长度为2n且左右括号个数不超限制
     * 剪枝：用来保证组合合法->
     * 1. 不能)开头
     * 2. )的个数不能大于（
     * 3. (和)的个数可以直接加i
     * 3. 每个字符只能出现n次
     * <p>
     * <p>
     * 思路二：二叉树
     * 每次只有(,)两个分支
     * 采用中序遍历，
     *
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesis2(int n) {
        // write code here
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add("(");
        }
        for (int i = 0; i < n; i++) {
            strings.add(")");
        }
        String[] strings1 = strings.toArray(new String[0]);
        ArrayList<String> res = new ArrayList<>();
        myBacktrace2(strings1, res, "", 0, 0);
        return res;
    }

    public void myBacktrace2(String[] collect, List<String> res, String temp, int left, int right) {
        System.out.println("temp为： " + temp);
        if (temp.length() == collect.length && left <= collect.length / 2 && right <= collect.length / 2) {
            if (!res.contains(temp)) res.add(temp);
            return;
        }

        for (int i = 0; i < collect.length; i++) {
            if (temp.startsWith(")")) {
                return;
            } else if (left > collect.length / 2 || right > collect.length / 2) {
                return;
            } else if (right > left) {
                return;
            }

            temp = temp + collect[i];
            if (collect[i].equals("(")) {
                left += 1;
            } else {
                right += 1;
            }

            myBacktrace2(collect, res, temp, left, right);

            temp = temp.substring(0, temp.length() - 1);
            if (collect[i].equals("(")) {
                left -= 1;
            } else {
                right -= 1;
            }
        }


    }

    public ArrayList<String> generateParenthesis3(int n) {
        // write code here
        ArrayList<String> strings = new ArrayList<>();

        myBacktrace3(n, strings, "", 0, 0);
        return strings;
    }

    /**
     * 这题不能看作纯n叉树，看作二叉树处理，因为只有( 和 )两种选择
     * <p>
     * 且是中序，左根右：(代表左子树
     * 先左后右
     * <p>
     * 但还是有剪枝限制：
     * left<n时才能继续遍历左子树
     * right<left才能继续遍历右子树
     *
     * @param n
     * @param res
     * @param temp
     * @param left
     * @param right
     */
    public void myBacktrace3(int n, List<String> res, String temp, int left, int right) {
        if (left == n && right == n) {
            res.add(temp);
            return;
        }

        if (left < n) {
            myBacktrace3(n, res, temp + "(", left + 1, right);
        }
        if (right < left) {
            myBacktrace3(n, res, temp + ")", left, right + 1);
        }

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
        List<String> res = generateParentheses.generateParenthesis3(5);
        System.out.println("耗时" + (System.currentTimeMillis() - start) / 1000 + "s");

        res.forEach(System.out::println);

    }
}
