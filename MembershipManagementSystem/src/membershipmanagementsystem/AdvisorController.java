/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membershipmanagementsystem;

import java.util.*;

/**
 *
 * @author user
 */
public class AdvisorController {

    ArrayList list = new ArrayList();

    public ArrayList getMemList() {
        return list;
    }

    public void setMemList(ArrayList aList) {
        list = aList;
    }

    // Register new member
    public void register(int id, String name, int numOfBookings, String payStatus) {
        if (payStatus.equals("PAID")) {
            Platinum mem = new Platinum();
            mem.setId(id);
            mem.setName(name);
            //mem.setNumOfBookings(numOfBookings);
            mem.setPayStatus(payStatus);
            mem.setPMembership("Platinum");
            list.add(mem);
        } else {
            if (numOfBookings > (9)) {
                Gold mem = new Gold();
                mem.setId(id);
                mem.setName(name);
                mem.setNumOfBookings(numOfBookings);
                mem.setMembership("Gold");
                list.add(mem);
            } else if (numOfBookings < (10)) {
                Silver mem = new Silver();
                mem.setId(id);
                mem.setName(name);
                mem.setNumOfBookings(numOfBookings);
                mem.setSMembership("Silver");
                list.add(mem);
            }
        }
    }

    //View all memberships
    public String viewAll() {
        String data = "";

        for (int i = 0; i < list.size(); i++) {
            Member member = (Member) list.get(i);
            String str = member.toString();
            data = data + str;
            System.out.println(member.toString());
        }
        return data;
    }

    //Update member details
    public void updateDetails(int id, String name) {

        boolean found = false;
        int i = 0;
        while (i < list.size() && !found) {
            Member temp = (Member) list.get(i);
            if (id == temp.getId()) {
                temp.setName(name);

                found = true;
            }
            i++;
        }
    }

    //Delete membership details
    public void deleteDetails(int id) {
        ArrayList tempList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Member temp = (Member) list.get(i);
            if (id != temp.getId()) {
                tempList.add(temp);
            }
        }
        list = tempList;
    }

}
