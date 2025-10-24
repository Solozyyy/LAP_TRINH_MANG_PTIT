package client.RMI;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import client.WS.DataService;

public class RMIDataToHopChapKCuaNPtu {
    public static int l, k;
    public static ArrayList<Integer> data = new ArrayList<>();
    public static List<List<Integer>> ans = new ArrayList<>();

    public static void solve(int i, ArrayList<Integer> ls) {
        if (ls.size() == k) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        if (i >= l)
            return;
        ls.add(data.get(i));
        solve(i + 1, ls);
        ls.remove(ls.size() - 1);

        solve(i + 1, ls);

    }

    public static void main(String[] args) throws Exception {
        DataService service = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        String res = (String) service.requestData("B22DCDT172", "yRS38Pse");
        System.out.println(res);

        String[] s = res.split(" ");

        String tmp = "";
        for (String x : s) {
            tmp += x;
        }

        String[] s1 = tmp.split(";");
        k = Integer.parseInt(s1[1]);
        System.out.println(k);

        String[] num = s1[0].trim().split(",");
        l = num.length;
        for (int i = 0; i < num.length; ++i) {
            data.add(Integer.parseInt(num[i]));
            System.out.println(data.get(i));
        }
        solve(0, new ArrayList<Integer>());
        for (List<Integer> x : ans) {
            System.out.println(x);
        }
        service.submitData("B22DCDT172", "yRS38Pse", ans);
    }
}
