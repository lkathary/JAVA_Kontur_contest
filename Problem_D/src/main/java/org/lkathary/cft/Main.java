package org.lkathary.cft;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        int u = in.nextInt();
        int v = in.nextInt();

        List<Long> xs = new ArrayList<>(u + 1);
        List<Long> ys = new ArrayList<>(v + 1);

        xs.add(0L);
        ys.add(0L);

        for (int i = 0; i < u; ++i) {
            xs.add(in.nextLong());
        }
        xs.sort(Long::compare);

        for (int i = 0; i < v; ++i) {
            ys.add(in.nextLong());
        }
        ys.sort(Long::compare);
        int q = in.nextInt();
        for (int it = 0; it < q; ++it) {
            long x0, y0, x1, y1;
            x0 = in.nextLong();
            y0 = in.nextLong();

            long xc0 = find(xs, x0);
            long yc0 = find(ys, y0);

            x1 = in.nextLong();
            y1 = in.nextLong();

            long xc1 = find(xs, x1);
            long yc1 = find(ys, y1);
            if (xc0 == xc1 && yc0 == yc1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static int find(List<Long> arr, long val) {
        int l = 0, r = arr.size();
        while (r - l > 1) {
            int m = (r + l) / 2;

            if (arr.get(m) < val) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }
}