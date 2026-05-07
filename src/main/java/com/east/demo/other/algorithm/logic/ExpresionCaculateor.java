package com.east.demo.other.algorithm.logic;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 表达式计算
 *
 * @author: east
 * @date: 2026/5/5 10:31
 */
public class ExpresionCaculateor {

    /**
     * 写一个支持+ - *三种符号的运算器，
     * 其中优先级+ - 是一级，*更高一级 支持括号运算
     * <p>
     * 搞两个队列，一个放操作数，一个放操作符
     * <p>
     * 从前往后遍历
     * 遇到空格：跳过
     * (:加入操作符队列，等待）
     * ）：使用现有的操作数队列和操作符进行计算，直到遇到（
     * 数字：从当前位置往后取出整个数字放入操作数栈
     * +-*：放入操作符队列，放入前把栈内能算的都算掉（只有栈内运算符比当前运算符优先级更高或相等，才进行计算），直到没有操作或左括号，结果加入操作数队列
     *
     *
     */
    public int solve(String s) {
        // write code here

        HashMap<Character, Integer> opsPriority = new HashMap<>() {{
            put('+', 1);
            put('-', 1);
            put('*', 2);
        }};

        ArrayDeque<Integer> nums = new ArrayDeque<>();
        ArrayDeque<Character> ops = new ArrayDeque<>();

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                ops.addLast(charArray[i]);
            } else if (charArray[i] == ')') {
                // 开始计算括号内值遇到（为止
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        caculate(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                // 是否是数字
                if (Character.isDigit(charArray[i])) {
                    int j = i;
                    int num = 0;
                    // 提取整个数字
                    while (j < charArray.length && Character.isDigit(charArray[j])) {
                        num = num * 10 + Character.getNumericValue(charArray[j]);
                        j++;
                    }
                    nums.addLast(num);
                    i = j - 1;
                } else {
                    // 是符号:判断优先级决定是否计算
                    char curOps = charArray[i];

                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        Character preOps = ops.peekLast();
                        if (opsPriority.get(preOps) >= opsPriority.get(curOps)) {
                            caculate(nums, ops);
                        } else {
                            break;
                        }
                    }

                    ops.addLast(curOps);
                }
            }

        }
        while (!ops.isEmpty() && ops.peekLast() != '(') {
            caculate(nums, ops);
        }
        return nums.peekLast();
    }

    private void caculate(ArrayDeque<Integer> nums, ArrayDeque<Character> ops) {
        if (nums.size() < 2 || ops.isEmpty()) return;
        Integer i = nums.pollLast();
        Integer j = nums.pollLast();
        Character operater = ops.pollLast();

        Integer result = 0;
        if (operater == '-') result = i - j;
        else if (operater == '+') result = i + j;
        else if (operater == '*') result = i * j;

        nums.addLast(result);
    }

    public static void main(String[] args) {
        String e = "(1+2)*3";
        ExpresionCaculateor expresionCaculateor = new ExpresionCaculateor();
        System.out.println(expresionCaculateor.solve(e));
    }
}
