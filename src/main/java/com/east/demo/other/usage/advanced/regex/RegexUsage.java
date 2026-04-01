package com.east.demo.other.usage.advanced.regex;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2025/8/30 9:30
 */
public class RegexUsage {


    private static void bugRecur() {
        // 模拟实际情况中的utf8字节数组
        byte[] bugBytes = new String("\r\n\r\n六1\r\n").getBytes(StandardCharsets.UTF_8);
        byte[] normalBytes = new String("\r\n\r\n普通字符123\r\n").getBytes(StandardCharsets.UTF_8);

        // 模拟业务需要，以iso8859-1编码将字节数组转回字符串（实际上上面和下面在实际业务的不同系统做的）
        String bugStr = new String(bugBytes, StandardCharsets.ISO_8859_1);
        String normalStr = new String(normalBytes, StandardCharsets.ISO_8859_1);

        // 进行正则匹配
        String patternStr = "\\r\\n\\r\\n(.*?)\\r\\n";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher bugMatcher = pattern.matcher(bugStr);
        Matcher normalMatcher = pattern.matcher(normalStr);

        System.out.println("问题字符匹配结果: " + bugMatcher.find());
        System.out.println("普通字符匹配结果: " + normalMatcher.find());
    }

    private static void deepReason() {
        // 模拟实际情况中的utf8字节数组
        byte[] bugBytes = new String("\r\n\r\n好公司123\r\n").getBytes(StandardCharsets.UTF_8);
        byte[] normalBytes = new String("\r\n\r\n普通字符123\r\n").getBytes(StandardCharsets.UTF_8);

        // 模拟业务需要，以iso8859-1编码将字节数组转回字符串（实际上上面和下面在实际业务的不同系统做的）
        String bugStr = new String(bugBytes, StandardCharsets.ISO_8859_1);
        String normalStr = new String(normalBytes, StandardCharsets.ISO_8859_1);


        System.out.println("错误编码后的问题字符串字节数组: " + Arrays.toString(bugStr.getBytes(StandardCharsets.ISO_8859_1)));
        System.out.println("错误编码后的问题字符串字节数组: " + Arrays.toString(normalStr.getBytes(StandardCharsets.ISO_8859_1)));
        // 这里是往控制台输出的结果，一般流会通过utf8编码传输，对分析函数内部行为没什么意义
        // System.out.println("错误编码后的问题字符串: "+bugStr);

        // 更关键的是看字符串在java内存中的utf16编码后的结果
        // System.out.println("错误编码后的问题字符串在java内存中的utf16编码字符数组: "+ Arrays.toString(bugStr.toCharArray())); // 这一行会输出失败
        System.out.println("错误编码后的问题字符串在java内存中的utf16编码字节数组: " + Arrays.toString(bugStr.getBytes(StandardCharsets.UTF_16)));
        // System.out.println("错误编码后的普通字符串在java内存中的utf16编码字符数组: "+ Arrays.toString(normalStr.toCharArray())); // 这一行会输出失败
        System.out.println("错误编码后的普通字符串在java内存中的utf16编码字节数组: " + Arrays.toString(normalStr.getBytes(StandardCharsets.UTF_16)));

        String patternStr = "\\r\\n\\r\\n(.*?)\\r\\n";
        Pattern pattern = Pattern.compile(patternStr);
        Pattern compatiblePattern = Pattern.compile(patternStr, Pattern.DOTALL);
        Matcher bugMatcher = pattern.matcher(bugStr);
        Matcher normalMatcher = pattern.matcher(normalStr);
        Matcher compatibleMatcher = compatiblePattern.matcher(bugStr);

        System.out.println("问题字符匹配结果: " + bugMatcher.find());
        System.out.println("普通字符匹配结果: " + normalMatcher.find());
        System.out.println("问题字符兼容匹配结果: " + compatibleMatcher.find());

    }


    /**
     * 找到所有中文用utf8编码后任意一个字节是0x85的情况
     */
    public static void wordWith0x75() {
        int count = 0;
        // CJK统一汉字基本区：U+4E00 ~ U+9FFF
        for (int codePoint = 0x4E00; codePoint <= 0x9FFF; codePoint++) {
            char ch = (char) codePoint;
            String s = String.valueOf(ch);

            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);

            // UTF-8 编码的汉字应该是 3 字节
            if (bytes.length == 3) {
                boolean has85 = false;
                for (byte b : bytes) {
                    // Java byte 范围是 -128~127，需要转成无符号
                    int unsigned = b & 0xFF;
                    if (unsigned == 0x85) {
                        has85 = true;
                        break;
                    }
                }
                if (has85) {
                    // 打印字符 + UTF-8字节的十六进制表示
                    System.out.printf("U+%04X %s -> %s%n", codePoint, ch, bytesToHex(bytes));
                    count++;
                }
            }
        }
        System.out.printf("基本中文共有%d个符合要求", count);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < bytes.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(String.format("0x%02X", bytes[i] & 0xFF));
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
//        bugRecur();
//        deepReason();
        wordWith0x75();
    }

}
