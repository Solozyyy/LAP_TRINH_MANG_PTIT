package client.DSA;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class TongGapDoiTB {

    public static String solve(int[] a, int tb) {
        int l = 0, r = a.length - 1;
        int p = Integer.MAX_VALUE;
        int n1 = 0, n2 = 0;
        while (l < r) {
            int tmp = a[l] + a[r];
            int m = Math.abs(tb - tmp);
            if (m <= p) {
                n1 = a[l];
                n2 = a[r];
                p = m;
            }
            if (tmp > tb)
                --r;
            else
                ++l;
        }
        return Integer.toString(n1) + "," + Integer.toString(n2);
    }

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("203.162.10.109", 2207);
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintWriter pw = new PrintWriter(os, true);

        pw.println("B22DCDT172;...");
        pw.flush();

        char[] c = new char[4096];
        int n = br.read(c);
        // String s = new String(c, 0, n);
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(",");
        int tb = 0;
        for (String x : num) {
            tb += Integer.parseInt(x);
        }
        tb /= num.length;
        int[] t = new int[num.length];
        for (int i = 0; i < num.length; ++i) {
            t[i] = Integer.parseInt(num[i]);
        }
        Arrays.sort(t);
        String s = solve(t, tb * 2);
        System.out.println(s);
    }
}
