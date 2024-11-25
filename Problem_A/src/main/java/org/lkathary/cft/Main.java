package org.lkathary.cft;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<String> s = new ArrayList<>(n);

        in.nextLine();
        for (int i = 0; i < n; ++i) {
            s.add(in.nextLine());
        }

        int cnt = 0;
        String res = "";
        for (String ss : s) {
            HashSet<Character> set = new HashSet<>();
            for (char c : ss.toCharArray()) {
                set.add(c);
            }
            if (set.size() > cnt) {
                cnt = set.size();
                res = ss;
            }
        }
        System.out.println(cnt + " " + res);

    }
}