package com.east.demo.other.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author: east
 * @date: 2026/5/5 9:57
 */
public class Temp {


    public static void main(String[] args) {
        ArrayList<String> flagA = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            flagA.add(s);
        }

        flagA.stream().sorted().forEach(System.out::println);
    }
}
