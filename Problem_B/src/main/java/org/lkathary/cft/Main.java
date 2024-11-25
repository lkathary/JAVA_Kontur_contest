package org.lkathary.cft;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int xt, yt;

        int x0 = in.nextInt(), y0 = in.nextInt();
        for (int i = 1; i < n; ++i) {
            xt = in.nextInt();
            yt = in.nextInt();
            if (xt < x0 || (xt == x0 && yt < y0)) {
                x0 = xt;
                y0 = yt;
            }
        }

        int x1 = in.nextInt(), y1 = in.nextInt();
        for (int i = 1; i < n; ++i) {
            xt = in.nextInt();
            yt = in.nextInt();
            if (xt < x1 || (xt == x1 && yt < y1)) {
                x1 = xt;
                y1 = yt;
            }
        }

        System.out.println((x1 - x0) + " " + (y1 - y0));

    }
}