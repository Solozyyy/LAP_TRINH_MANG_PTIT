package client.RMI;

import RMI.DataService;
import java.rmi.Naming;

public class RMIDataThamLam {
    public static void main(String[] args) throws Exception {
        DataService service = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
        int n = (Integer) service.requestData("B22DCDT172", "3e1yIIYe");
        int[] nums = { 1, 2, 5, 10 };
        System.out.println(n);
        String res = "";
        int count = 0;
        for (int i = 3; i >= 0; --i) {
            if (n == 0)
                break;
            while (n >= nums[i]) {
                int c = 0;
                c = n / nums[i];
                n -= (c * nums[i]);
                count += c;
                for (int j = 0; j < c; ++j) {
                    res += nums[i] + ",";
                }
            }
        }

        System.out.println(res);
        StringBuilder sb = new StringBuilder(res);
        sb.insert(0, Integer.toString(count) + "; ");
        service.submitData("B22DCDT172", "3e1yIIYe", sb.toString().substring(0, sb.length() - 1));
    }
}
