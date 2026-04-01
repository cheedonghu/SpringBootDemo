package com.east.demo.other.usage.special;

/**
 * 一些奇怪的地方
 *
 * @author: east
 * @date: 2023/12/1
 */
public class Strange {
    /**
     * 这段代码中的空指针异常（NullPointerException）是由三元运算符（? :）的类型推断行为引起的。
     * 这里的关键在于三元运算符尝试在其两个可能的返回值（a * b 和 c）之间找到一个共同的类型。
     */
    public static void sanMu() {
        Integer a = 1; // 局部变量数字用基本类型
        Integer b = 2;
        Integer c = null;
        Boolean flag = true;
//        Integer result=(flag? Integer.valueOf(a * b) :c);  // 为什么这样就行了？？
        Integer result = (flag ? a * b : c);
        System.out.println(result);
    }

    public static void main(String[] args) {
        sanMu();
    }
}
