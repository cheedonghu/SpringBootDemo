package com.east.demo.other.algorithm.others;

/**
 * CPU算力分配
 * <p>
 * 现有两组服务器A和B，每组有多个算力不同的CPU，其中 A[i] 是A组第i个CPU的运算能力，B[i]是 B组 第i个CPU的运算能力。
 * 一组服务器的总算力是各CPU的算力之和。
 * 为了让两组服务器的算力相等，允许从每组各选出一个CPU进行一次交换。 求两组服务器中，用于交换的CPU的算力，并且要求从A组服务器中选出的CPU，算力尽可能小。
 * <p>
 * assume sumA>sumB
 * <p>
 * sumA-x=sumB+y -> x+y = sumA-sumB ,同时x最小即可
 *
 * @author: east
 * @date: 2024/3/7 20:21
 */

public class CpuDistrubution {

}
