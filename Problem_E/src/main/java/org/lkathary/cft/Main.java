package org.lkathary.cft;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> field = new ArrayList<>();
    private static final List<List<Integer>> ids = new ArrayList<>();
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int n;
    private static int m;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int q = in.nextInt();

        in.nextLine();
        for (int i = 0; i < n; ++i) {
            field.add(in.nextLine());
            List<Integer> line = new ArrayList<>(m);
            ids.add(line);
            for (int j = 0; j < m; ++j) {
                line.add(0);
            }
        }

        int id = 1;
        List<Integer> ships = new ArrayList<>(1);
        ships.add(0);
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                if (ids.get(r).get(c) == 0) {
                    int size = dfs(r, c, id);
                    if (size > 0) {
                        ships.add(size);
                        ++id;
                    }
                }
            }
        }

        for (int it = 0; it < q; ++it) {
            int r = in.nextInt();
            int c = in.nextInt();
            --r;
            --c;
            int idx = ids.get(r).get(c);
            if (idx == -1) {
                System.out.println("MISS");
                continue;
            }

            int v = ships.get(idx);
            --v;
            if (v == 0) {
                System.out.println("DESTROY");
            } else {
                System.out.println("HIT");
            }
            ships.set(idx, v);
        }

    }

    private static int dfs(int r, int c, int idx) {
        if (field.get(r).charAt(c) == '.') {
            ids.get(r).set(c, -1);
            return 0;
        } else {
            int size = 1;
            ids.get(r).set(c, idx);
            for (int i = 0; i < 4; ++i) {
                int rn = r + dx[i];
                int cn = c + dy[i];
                if (0 <= rn && rn < n && 0 <= cn && cn < m) {
                    if (ids.get(rn).get(cn) == 0) {
                        size += dfs(rn, cn, idx);
                    }
                }
            }
            return size;
        }
    }
}