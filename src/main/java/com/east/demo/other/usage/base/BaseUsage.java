package com.east.demo.other.usage.base;

import cn.hutool.core.util.HexUtil;
import com.east.demo.other.model.base.CommonClassA;
import com.east.demo.other.model.base.TheClassImpComparable;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @description: java基本知识
 * @author: east
 * @date: 2023/10/22
 */

public class BaseUsage {

    /**
     * 自动装箱和拆箱
     */
    public void testIntegerAndInt() {
        // 如果整型字面量的值在-128 到 127 之间，那么不会 new 新的 Integer对象，而是直接引用常量池中的 Integer 对象
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }

    /**
     * 字符常量
     */
    public void testStringIntern() {
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);
    }

    /**
     * 位移运算
     */
    public void testWeiYiYunSuan() {
        // 左移n位等于乘以2的n次方
        System.out.println(5 * 8 == 5 << 3);
        // 右移n位等于除以2的n次方
        System.out.println(24 / 8 == 24 >> 3);
    }

    /**
     * 数组length属性
     */
    public void testArrayLength() {
        int[] array = new int[3];
        // 数组没有length()方法：数组类型在Java中是特殊的数据结构，其长度是作为公共属性存在的。
        System.out.println(array.length);

        // 数组类型在Java中是特殊的数据结构，其长度是作为公共属性存在的。
        String[] stringArray = new String[3];
        System.out.println(stringArray.length);
    }

    /**
     * equals与hashCode
     */
    public void testEquals() {
        String s = "123";
        String s2 = "123";
    }

    /**
     * 参数传递形式
     * 当你传递一个对象作为参数时，实际上是传递了该对象的引用的值。这个引用指向内存中的对象。所以，虽然传递的是引用的值，你仍然操作的是原始对象。
     * 但需要注意，如果在方法内部将参数引用指向新的对象，那么这将不会影响原始对象，因为在方法内部你只是改变了引用的值，而不是原始对象的值。
     * demoClassA是值；@2133c8f8是引用
     */
    public void testPassParam1() {
        CommonClassA commonClassA = new CommonClassA("str1");

        testPassParam2(commonClassA);

        System.out.println(commonClassA.getString());
    }

    public void testPassParam2(CommonClassA commonClassA) {
        System.out.println(commonClassA);

        commonClassA = new CommonClassA("str2");

        System.out.println(commonClassA);

        commonClassA.setString("str3");
    }


    /**
     * 字符串特性
     * <p>
     * 字符串，字符串常量池，字符串对象初始化
     * ,常量池，堆,intern()方法
     * <p>
     * 初始化策略不同：复用常量池，节省内存
     * 常量池：节省内存
     * intern()方法：使用常量池
     */
    public void testStringConst() {
        // Java会首先检查字符串常量池中是否已经存在相同内容的字符串对象。如果存在，它会直接将引用指向已存在的对象，而不会创建新的对象
        String s1 = "Programming";
        // 它会强制创建一个新的字符串对象，无论字符串常量池中是否已经存在相同内容的字符串。
        // 因此，s2 会在堆内存中创建一个新的字符串对象，而不会与 s1 共享内存地址。
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        // 编译器在编译时便会将其组合起来，所以s5引用的是常量池中的对象
        String s5 = "Program" + "ming";
        // s3,s4在编译时无法确定，所以在运行时拼接，+号本质采用了new StringBuilder方式，所以在堆上
        String s6 = s3 + s4;
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
        System.out.println("s5: " + System.identityHashCode(s5));
        System.out.println("s6: " + System.identityHashCode(s6));
        // 当调用 s2.intern() 时，它会尝试将 s2 的内容放入字符串常量池。
        // 因为 s2 是一个通过 new 创建的字符串对象，它的内容不在字符串常量池中。
        // 因此，s2.intern() 会将 s2 的内容添加到字符串常量池，并返回对字符串常量池中的相同字符串的引用。
        System.out.println(System.identityHashCode(s2.intern()));
        // 参考上文，也是返回常量池中相同字符串的引用
        System.out.println(System.identityHashCode(s6.intern()));

        System.out.println(s1 == s2);
        System.out.println();
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }

    /**
     * 重载，重写
     * 编译；运行，子父类
     * 重载无法根据返回类型区分：无法确定调用的方法，返回类型不一定使用
     */
    public void testOverLoadOverRide() {
        String s = "123";
        String s2 = "123";
    }
//    /**
//     * 重载，重写
//     */
//    public int testOverLoadOverRide() {
//        String s = "123";
//        String s2 = "123";
//    }


    /**
     * 测试字符集,utf16编码,字节数组
     */
    public void testUtf16AndByteArray() {
        String s = "Ω";

        // 默认用的utf8
        System.out.println(HexUtil.encodeHexStr(s.getBytes()));

        byte[] bytes = HexUtil.decodeHex(HexUtil.encodeHexStr(s.getBytes()));

        System.out.println(new String(bytes, StandardCharsets.ISO_8859_1));
        System.out.println(new String(bytes, StandardCharsets.UTF_16));
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        System.out.println(HexUtil.encodeHexStr(s.getBytes(StandardCharsets.UTF_16)));
    }

    /**
     * 测试在finally内修改返回值
     */
    public void testCatchFinally() {
        System.out.println(testCatchFinally2());
    }

    public String testCatchFinally2() {
        String result = null;
        try {
            int i = 1 / 0;
            result = "string";
            return result;
        } catch (Exception e) {
            System.out.println("catch exception");
            result = "exception";
            return result;
        } finally {
            result = "finally modified" + result;
            System.out.println("result modified");
            // 不加return修改的结果不会返回
            return result;
        }
    }


    /**
     * 使用treeMap和treeSet存放需要排序的对象
     * treeSet的放入对象，treeMap的键：需要对象实现Comparable接口
     * <p>
     * 或通过Collections.sort进行排序：只需要new一个comparable接口即可，比上面限制小
     */
    public void testSortContainer() {
        ArrayList<TheClassImpComparable> theClassImpComparableList = new ArrayList<>();
        theClassImpComparableList.add(new TheClassImpComparable(20, "d"));
        theClassImpComparableList.add(new TheClassImpComparable(30, "c"));
        theClassImpComparableList.add(new TheClassImpComparable(40, "b"));
        theClassImpComparableList.add(new TheClassImpComparable(50, "a"));

        // treeSet和treeMap的使用
        TreeMap<TheClassImpComparable, String> nameMapTheClassImpComparableTreeMap = new TreeMap<>();
        TreeSet<TheClassImpComparable> theClassImpComparableSet = new TreeSet<>();
        for (TheClassImpComparable theClassImpComparable : theClassImpComparableList) {
            theClassImpComparableSet.add(theClassImpComparable);

            nameMapTheClassImpComparableTreeMap.put(theClassImpComparable, theClassImpComparable.getName());
        }
        theClassImpComparableSet.stream().forEach(x -> System.out.println(x));
        System.out.println("\n");
        nameMapTheClassImpComparableTreeMap.keySet().stream().forEach(x -> System.out.println(x));

        // Collections.sort的使用
        Collections.sort(theClassImpComparableList, new Comparator<TheClassImpComparable>() {
            @Override
            public int compare(TheClassImpComparable o1, TheClassImpComparable o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("\n");
        theClassImpComparableList.stream().forEach(x -> System.out.println(x));
    }

    /**
     * 获取类类型
     */
    public void testGetClass() {
        try {
            Class<? extends String> aClass = "123".getClass();
            Class<String> stringClass = String.class;
            Class<?> aClass1 = Class.forName("java.lang.String");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * test
     */
    public void test() {
        String s = "123";
    }

    public static void main(String[] args) {
        BaseUsage baseTest = new BaseUsage();
        baseTest.test();
    }

}
