package client.WS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ObjectService {
    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
     * to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this
     * template
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<EmployeeY> ls = (List<EmployeeY>) port.requestListEmployeeY("B22DCDT172", "2SGj9dqt");
        for (EmployeeY e : ls) {
            System.out.println(e);
        }

        Collections.sort(ls, new Comparator<EmployeeY>() {

            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                if (o1.getStartDate().compare(o2.getStartDate()) == 0) {
                    return 0;
                } else
                    return o1.getStartDate().compare(o2.getStartDate());
            }

        });

        System.out.println("-------------------");
        for (EmployeeY e : ls) {
            System.out.println(e);
        }
        port.submitListEmployeeY("B22DCDT172", "2SGj9dqt", ls);
    }

}
