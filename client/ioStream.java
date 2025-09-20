package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class ioStream {
    public static String solve(Long[] arr, long mid) {
        int l = 0, r = arr.length - 1;
        String ans = "";
        long pivot = Integer.MAX_VALUE;
        while (l < r) {
            long tmp = (arr[l] + arr[r]) - mid;

            if (Math.abs(tmp) <= pivot) {
                pivot = tmp;
                ans = arr[l] + "," + arr[r];
            }
            if (tmp >= 0) {
                r--;
            } else {
                l++;
            }

        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2206);
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        String req = "B22DCDT172;l0fikN14";
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintWriter pw = new PrintWriter(os, true);// auto flush
        pw.println(req);

        char[] c = new char[1000000];
        int n = br.read(c);
        System.out.println(c);

        String s = new String(c, 0, n);
        System.out.println(s);
        long mid = 0, sum = 0;
        String[] tmp = s.split(",");
        Long[] arr = new Long[tmp.length];
        for (int i = 0; i < tmp.length; ++i) {
            sum += Long.parseLong(tmp[i]);
            arr[i] = Long.parseLong(tmp[i]);
        }
        Arrays.sort(arr);
        mid = (sum / tmp.length) * 2;
        String res = solve(arr, mid);
        System.out.println(res);
        pw.println(res);
        os.flush();
        is.close();
        os.close();
        client.close();

    }
}
