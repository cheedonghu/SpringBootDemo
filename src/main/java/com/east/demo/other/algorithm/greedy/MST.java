package com.east.demo.other.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 最小生成树
 *
 * @author: east
 * @date: 2026/5/7 21:59
 */
public class MST {

    public static class Edge
            // implements Comparable<Edge>
    {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int getU() {
            return u;
        }

        public void setU(int u) {
            this.u = u;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * <p>The implementor must ensure
         * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
         * for all {@code x} and {@code y}.  (This
         * implies that {@code x.compareTo(y)} must throw an exception iff
         * {@code y.compareTo(x)} throws an exception.)
         *
         * <p>The implementor must also ensure that the relation is transitive:
         * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
         * {@code x.compareTo(z) > 0}.
         *
         * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
         * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
         * all {@code z}.
         *
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
         * class that implements the {@code Comparable} interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         *
         * <p>In the foregoing description, the notation
         * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
         * <i>signum</i> function, which is defined to return one of {@code -1},
         * {@code 0}, or {@code 1} according to whether the value of
         * <i>expression</i> is negative, zero, or positive, respectively.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified object's type prevents it
         *                              from being compared to this object.
         */
        // @Override
        // public int compareTo(Edge o) {
        //     return o.w;
        // }
    }

    /**
     * 并查集
     * find: 找到节点根
     * union: 合并，返回false则代表有环不能合并
     */
    public static class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 找到根
         * parent[find(parent[x])]含义：
         * parent[x]表示x的父节点（根节点）
         * find(parent[x])表示递归查找父节点的父节点
         * parent[ find(parent[x]) ] 表示最终父节点的父节点（其自己）
         */
        private int find(int x) {
            return parent[x] == x ? x : parent[find(parent[x])];
        }

        /**
         * 合并
         *
         * @param x 节点1
         * @param y 节点2
         * @return 结果 false：有环 true 成功
         */
        public boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);

            if (rx == ry) {
                // 同一个根，合并两节点会产生环
                return false;
            }

            // y挂到x下。（能优化：判断高度，挂到高的还是矮的来着？）
            parent[ry] = rx;

            return true;
        }
    }

    /**
     * Kruskal 算法：
     * 1. 将边排好序
     * 2. 依次获取边
     * 用并查集判断是否成环
     * 成环 跳过
     * 不成功 加入并查集
     * 依次处理n-1次即可
     * <p>
     * 已有的变，w=0即可
     *
     */
    public static void kruskal(List<Edge> edges) {
        Collections.sort(edges, Comparator.comparingInt(a -> a.w));
        int n = edges.size();
        DSU dsu = new DSU(n);

        int minCost = 0;
        // 已成边数量，达到n-1即可
        for (int i = 0; i < n; i++) {
            // 逐条边处理
            Edge edge = edges.get(i);
            // 加入并查集
            if (dsu.union(edge.u, edge.v)) {
                // 加入成功
                minCost += edge.w;
            } else {
                // 加入会形成环，放弃
            }
        }

        System.out.println(minCost);

    }

    public static void main(String[] args) {
        Edge edge1 = new Edge(0, 1, 3);
        Edge edge2 = new Edge(1, 2, 5);
        Edge edge3 = new Edge(0, 2, 1);

        ArrayList<Edge> edges = new ArrayList<>() {{
            add(edge1);
            add(edge2);
            add(edge3);
        }};

        kruskal(edges);
    }
}
