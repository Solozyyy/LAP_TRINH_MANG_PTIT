package client.TCP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ByteStream {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("203.162.10.109", 2206);
        String req = "B22DCDT172;voiYunNq";
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        pw.println(req);
        char[] c = new char[1000009];
        int n = br.read(c);
        String s = new String(c, 0, n);
        System.out.println(s);
        int sum = 0;
        String[] str = s.split("\\|");
        for (String x : str) {
            System.out.println(x);
            sum += Integer.parseInt(x);
        }

        System.out.println(sum);
        pw.println(Integer.toString(sum));
        is.close();
        os.close();
        client.close();
    }
}
