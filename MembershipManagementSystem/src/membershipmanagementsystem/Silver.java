/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membershipmanagementsystem;

/**
 *
 * @author user
 */
public class Silver extends Member{
    
    private String sMembership;
    //Constructor
    public Silver(){
    }
    
    public String getSMembership(){
        return sMembership;
    }
    
    public void setSMembership(String theSMembership){
        sMembership = theSMembership;
    }
    
    @Override
    public String toString() {
        return "\n Member Id no: " + getId() + "name: "
                        + getName()
                        + "numOfBookings" + getNumOfBookings() + "Membership: " + getSMembership() + ";\n";
    }
    
    @Override
    public String getInsertQuery() {
        return "INSERT INTO MEMBER VALUES (" + getId()
                            + ", '" + getName() + "' , '"
                            + getSMembership() + "', "
                            + getNumOfBookings() + ")";
    }
}
