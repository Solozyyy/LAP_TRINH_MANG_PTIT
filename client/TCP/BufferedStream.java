package client.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedHashSet;

public class BufferedStream {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("203.162.10.109", 2208);
        String req = "B22DCDT172;Xu44SnP3";
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        bw.write(req);
        bw.newLine();
        bw.flush();

        String s = br.readLine().trim();
        System.out.println(s);
        String res = "";
        for (char x : s.toCharArray()) {
            if (x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z') {
                res += x;
            }
        }
        System.out.println(res);
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char x : res.toCharArray()) {
            set.add(x);
        }
        String ans = "";
        for (char x : set) {
            ans += x;
        }
        System.out.println(ans);
        bw.write(ans);
        bw.flush();
        br.close();
        bw.close();
        client.close();
    }
}
