package client.RMI;

import RMI.ObjectService;
import RMI.Employee;
import java.rmi.Naming;

public class RMIObjectTinhUoc {
    public static int solveEY(int s) {
        int n = 0;
        while (s != 0) {
            n += s % 10;
            s /= 10;
        }
        return n;
    }

    public static int solveUoc(int n) {
        int count = 0;

        for (int i = 1; i < Math.sqrt(n); ++i) {
            if (n % i == 0) {
                count += 2;
            }
        }
        if (n % Math.sqrt(n) == 0)
            count++;
        return count;
    }

    public static void main(String[] args) throws Exception {
        ObjectService service = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        Employee e = (Employee) service.requestObject("B22DCDT172", "ZPrSt5OW");
        System.out.println(e);

        double factor = (e.experienceYears + solveEY(e.experienceYears) + solveUoc(e.experienceYears)) / 100.0;
        e.finalSalary = e.baseSalary * (1 + factor);

        System.out.println(e);
        service.submitObject("B22DCDT172", "ZPrSt5OW", e);
    }
}
