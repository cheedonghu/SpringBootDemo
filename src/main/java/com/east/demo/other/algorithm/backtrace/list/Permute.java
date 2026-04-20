package com.east.demo.other.algorithm.backtrace.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 全排列问题： 没有重复项数字的全排列
 *
 * @author: east
 * @date: 2026/4/15 15:35
 */
public class Permute {

    /**
     * 没有重复数字的全排列
     * 全排列—>回溯的经典模型
     * 公式：
     * 是否是解:状态长度为num.size
     * 所有情况: range(num.size,0)
     * 是否可以剪枝: state.contains(num[i]):这里其实是判断改字符出现次数不能大于1
     * 更新状态 state.add(num[i])
     * 继续递归
     * 回溯 state.remove.last
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> state = new ArrayList<>();
        mybacktrace(num, res, state);
        return res;
    }

    private void mybacktrace(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> state) {
        if (state.size() == num.length) {
            ArrayList<Integer> integers = new ArrayList<>(state);
            res.add(integers);
        }

        for (int i = 0; i < num.length; i++) {
            if (state.contains(num[i])) {
                continue;
            }
            state.add(num[i]);
            mybacktrace(num, res, state);
            state.remove(state.size() - 1);
        }
    }


    /**
     * 给出一组可能包含重复项的数字，返回该组数字的所有排列。输入[1,1,2]
     * 返回值：
     * [[1,1,2],[1,2,1],[2,1,1]]
     * <p>
     * 全排列问题->回溯
     * 基本模型
     * 公式:
     * 是否是解返回:~~state.size==length && !res.contains(state) ->这里判断是否重复太慢，在剪枝的地方判断，尽量在这里少判断都放到剪枝那里~~
     * state.size==length
     * 全部情况 range(num.length)
     * 是否可以剪枝
     * 单数字出现次数达上限：map.get(num[i])==state.count(num[i])
     * 当前元素和上一个元素一样时，剪枝，因为前一个已经递归搜索了一遍：
     * <p>
     * 更新状态 state.add(num[i])
     * 递归
     * 状态回溯
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // write code here
        // 对num排个序

        int[] array = Arrays.stream(num).sorted().toArray();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> state = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : num) {
            map.compute(i, (key, value) -> (value == null) ? 1 : value + 1);
        }
        mybacktrace2(array, res, state, map);
        return res;
    }


    private void mybacktrace2(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> state, HashMap<Integer, Integer> map) {
        if (state.size() == num.length) {
            res.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (map.get(num[i]) == findCount(state, num[i])) {
                continue;
            }
            // 当前元素不能和上一个相同
            if (i >= 1 && num[i] == num[i - 1]) {
                continue;
            }

            state.remove(state.size() - 1);

            state.add(num[i]);

            mybacktrace2(num, res, state, map);

            state.remove(state.size() - 1);
        }


    }

    /**
     * 这个好像括号问题？ 当前元素和前一个一样时：可以剪枝，因为已经递归了一遍
     * map(key,val) key: num的元素，val次数
     * num[]=[1,1,2] -> 1,2 -> 和()问题一样
     * visitmap: map=key:num，val实际次数
     * <p>
     * if(visitmap.get(i)<map.get(i))
     * state.add(num[i])
     * visit
     * backtrace(num,res,state,map,visitmap)
     * else continue;
     */
    private int length;

    public ArrayList<ArrayList<Integer>> permuteUnique3(int[] num) {
        // write code here
        length = num.length;
        Map<Integer, Integer> map = new TreeMap<>();
        HashMap<Integer, Integer> visitmap = new HashMap<>();
        int[] newarray = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            map.compute(num[i], (k, v) -> v == null ? 1 : v + 1);
            visitmap.put(num[i], 0);
        }
        Integer[] array1 = map.keySet().toArray(new Integer[0]);


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> state = new ArrayList<>();

        mybacktrace3(array1, res, state, map, visitmap);
        return res;
    }

    private void mybacktrace3(Integer[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> state, Map<Integer, Integer> map, HashMap<Integer, Integer> visitmap) {
        if (state.size() == length) {
            res.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (visitmap.get(num[i]) < map.get(num[i])) {
                state.add(num[i]);
                visitmap.compute(num[i], (k, v) -> v == null ? 1 : v + 1);
                mybacktrace3(num, res, state, map, visitmap);
                state.remove(state.size() - 1);
                visitmap.compute(num[i], (k, v) -> v - 1);
            }
        }


    }

    private int findCount(ArrayList<Integer> state, int i) {
        return (int) state.stream().filter(x -> x.equals(i)).count();
    }


    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] num = {-1, 0, 1};
        // ArrayList<ArrayList<Integer>> permute1 = permute.permute(num);

        ArrayList<ArrayList<Integer>> permute1 = permute.permuteUnique3(num);

        List<String> collect = permute1.stream().map(x -> x.stream().map(String::valueOf).collect(Collectors.joining())).collect(Collectors.toList());
        System.out.println(collect);


        // ArrayList<Integer> test = new ArrayList<>(List.of(3, 3, 1));
        // ArrayList<ArrayList<Integer>> permute1 = new ArrayList<>();
        // permute1.add(test);
        // ArrayList<Integer> test2 = new ArrayList<>(List.of(3, 2, 1));
        // System.out.println(permute.equals(permute1,test2));
    }
}
