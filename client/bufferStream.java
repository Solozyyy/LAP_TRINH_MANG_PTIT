package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class bufferStream {
    public static String solve(String s) {
        int tmp = 0;
        String res = "";
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                tmp++;
            } else {
                res += s.charAt(i - 1);
                if (tmp != 0) {
                    res += (tmp + 1);
                }
                tmp = 0;
            }
        }
        if (s.charAt(s.length() - 1) == s.charAt(s.length() - 2)) {
            tmp++;
            res += s.charAt(s.length() - 1) + tmp;
        } else {
            res += s.charAt(s.length() - 1);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2208);
        String req = "B22DCDT172;92nK1iVB";
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        bw.write(req);
        bw.newLine();
        bw.flush();
        // Scanner sc = new Scanner(System.in);
        String[] s = br.readLine().split(" ");
        String res = "";
        for (String x : s) {
            StringBuilder sb = new StringBuilder(x);
            res += solve(sb.reverse().toString()) + " ";
        }
        System.out.println(res);
        bw.write(res);
        bw.flush();
        br.close();
        bw.close();
        client.close();
    }
}
