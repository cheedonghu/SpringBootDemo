package com.east.demo.other.algorithm.others;

import java.util.ArrayList;

/**
 * 重复字符
 *
 * @author: east
 * @date: 2024/3/29
 */
public class SameLetter {
    public static ArrayList<ArrayList<Integer>> fun(char[] str) {
        int i = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (i < str.length) {
            char base = str[i];
            int j = i + 1;
            int sameLength = 1;
            ArrayList<Integer> tempRes = new ArrayList<>();
            tempRes.add(i);
            while (j < str.length && base == str[j]) {
                j++;
                sameLength++;
            }
            if (sameLength >= 3) {
                tempRes.add(j - 1);
                i = j;
                res.add(tempRes);
            } else {
                i++;
            }
        }
        return res;
    }
}
