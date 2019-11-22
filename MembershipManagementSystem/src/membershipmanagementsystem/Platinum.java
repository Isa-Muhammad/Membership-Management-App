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
public class Platinum extends Member {
    private String pMembership;
    
    //Constructor
    public Platinum(){
    }
    
    public String getPMembership(){
        return pMembership;
    }
    
    public void setPMembership(String thePMembership){
        pMembership = thePMembership;
    }
    
    @Override
    public String toString() {
        return "\n Member Id no: " + getId() + "name: "
                        + getName()
                        + "payStatus" + getPayStatus() + "Membership: " + getPMembership() + ";\n";
    }
    
    @Override
    public String getInsertQuery() {
        return "INSERT INTO MEMBER VALUES (" + getId()
                            + ", '" + getName() + "' , '"
                            + getPMembership() + "', "
                            + getNumOfBookings() + ")";
    }
}
