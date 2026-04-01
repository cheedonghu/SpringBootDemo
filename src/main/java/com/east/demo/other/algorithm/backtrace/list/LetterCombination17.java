package com.east.demo.other.algorithm.backtrace.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: east
 * @date: 2024/1/24   --16:20
 */
public class LetterCombination17 {
    public void backtrace(String state, List<String> res, List<List<Character>> choices, int previousIndex) {
        if (isSolution(state, choices.size())) {
            recordSolution(res, state);
            return;
        }

        // 最麻烦的就是所有选择的遍历，先确定第几个数组，然后确定数组的第几个元素
        // 数组自动往后移动一位就不用担心同数组的值会重复选
        for (int count = previousIndex + 1; count < choices.size(); count++) {
            List<Character> characters = choices.get(count);
            for (int i = 0; i < characters.size(); i++) {
                if (isValid(state, characters.get(i), choices.size())) {
                    state = updateState(state, characters.get(i));
                    backtrace(state, res, choices, count);
                    state = undo(state);
                }
            }

        }

    }

    private void recordSolution(List<String> res, String state) {
        res.add(state);
    }

    private boolean isSolution(String state, int size) {
        return state.length() == size;
    }

    private String undo(String state) {
        if (state.isEmpty()) {
            return state;
        }
        return state.substring(0, state.length() - 1);
    }

    private String updateState(String state, Character character) {
        return state + character;
    }

    /**
     * 剪枝：校验当前选择是否合法
     *
     * @param state     当前状态
     * @param character 字符
     * @return 结果
     */
    private boolean isValid(String state, Character character, int size) {
//        return state.length()+1<=size;
        return true;
    }


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, List<Character>> digitMapChars = new HashMap<>();
        digitMapChars.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        digitMapChars.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        digitMapChars.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        digitMapChars.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        digitMapChars.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        digitMapChars.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        digitMapChars.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        digitMapChars.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        List<List<Character>> choices = new ArrayList<>();

        for (Character c : digits.toCharArray()) {
            choices.add(digitMapChars.get(c));
        }

        String state = "";
        ArrayList<String> res = new ArrayList<>();
        backtrace(state, res, choices, -1);
        return res;
    }

    public static void main(String[] args) {
        LetterCombination17 letterCombination17 = new LetterCombination17();
        List<String> strings = letterCombination17.letterCombinations("");
        strings.forEach(System.out::println);
    }
}
