/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
package membershipmanagementsystem;

import java.util.ArrayList;
import java.sql.*;
//import membershipmanagementsystem.Repo;

public class MemberRepoImpl implements Repo {

    private ArrayList<Member> members;

    //@Override
    public ArrayList read(Connection conn) {
        System.out.println("Reading from database....");
        ArrayList list = new ArrayList();
        try {
            Statement st = conn.createStatement();

            ResultSet rs = null;
            String sql = "SELECT * FROM MEMBER";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String payStatus = rs.getString("PAYSTATUS");
                int numOfBookings = rs.getInt("NO.OFBOOKINGS");
                if (numOfBookings > 9) {
                    Gold mem = new Gold();
                    mem.setId(rs.getInt("ID"));
                    mem.setName(rs.getString("NAME"));
                    mem.setNumOfBookings(rs.getInt("NUMOFBOOKINGS"));
                    mem.setMembership("Gold");
                    list.add(mem);
                } else if (numOfBookings < 10) {
                    Silver mem = new Silver();
                    mem.setId(rs.getInt("ID"));
                    mem.setName(rs.getString("NAME"));
                    mem.setNumOfBookings(rs.getInt("NUMOFBOOKINGS"));
                    mem.setSMembership("Silver");
                    list.add(mem);
                }
                if (payStatus.equals("PAID")) {
                    Platinum mem = new Platinum();
                    mem.setId(rs.getInt("ID"));
                    mem.setName(rs.getString("NAME"));
                    mem.setNumOfBookings(rs.getInt("NUMOFBOOKINGS"));
                    mem.setPMembership("Platinum");
                    list.add(mem);
                }

                System.out.println(rs.getInt("ID")
                        + "\t" + rs.getString("NAME")
                        + "\t" + rs.getString("MEMBERSHIP")
                        + "\t" + rs.getString("NUMOFBOOKINGS"));

            }//stop edit

            rs.close();
            st.close();

        } catch (SQLException ex) {
            System.out.println("SQLException failed !");
        }
        members = list;
        return members;
    }

    //@Override
    public void write(Connection conn, ArrayList members) {
        System.out.println("Writing to database....");
        System.out.println("record size:" + members.size());
        Statement st = null;

        try {
            st = conn.createStatement();
            String sql = "DELETE FROM MEMBER";
            st.executeUpdate(sql);

            //st.close();
        } catch (SQLException ex) {
            System.out.println("Delete SQLException error....");
            ex.printStackTrace();
        } finally {
            //if(st!=null)
            // st.close();
        }

        for (int i = 0; i < members.size(); i++) {

            Member member = (Member) members.get(i);
            try {
                st = conn.createStatement();
                String sql = member.getInsertQuery();
                st.execute(sql);
                st.close();
            } catch (SQLException ex) {
                System.out.println("Insert SQLException error... ");
                //ex.printStackTrace();
            }
        }//end for
    }
}
