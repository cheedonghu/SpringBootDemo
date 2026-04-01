package com.east.demo.other.usage.special;

/**
 * @author: east
 * @date: 2023/10/24
 */

public class SpecialUsage {
    public void getThreadFromCpu() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int singleCoreThreadCount = availableProcessors / 2; // Assuming hyper-threading is enabled

        System.out.println("Available Processors: " + availableProcessors);
        System.out.println("Single Core Thread Count (Approximate): " + singleCoreThreadCount);
    }

    public static void main(String[] args) {
        SpecialUsage specialUsage = new SpecialUsage();
        specialUsage.getThreadFromCpu();
    }
}
