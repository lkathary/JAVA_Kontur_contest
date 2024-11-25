package org.lkathary.cft;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        List<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            a.add(in.nextInt());
        }

        int res = 0;
        int cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(cnt, 0);
        for (int i = 0; i < n; ++i) {
            if (a.get(i) >= k) {
                ++cnt;
                map.put(cnt, i + 1);
            }

            int lf = cnt - q;

            res = Integer.max(res, i + 1 - map.getOrDefault(lf, 0));
        }

        System.out.println(res);
    }
}
