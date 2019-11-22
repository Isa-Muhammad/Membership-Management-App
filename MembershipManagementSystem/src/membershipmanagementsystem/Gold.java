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
public class Gold extends Member{
    
    private String membership;
    
    //constructor
    public Gold(){
    }
    
    public String getMembership(){
        return membership;
    }
    
    public void setMembership(String theMembership){
        membership = theMembership;
    }
    
        @Override
    public String toString() {
        return "\n Member Id no: " + getId() + "name: "
                        + getName()
                        + "numOfBookings" + getNumOfBookings() + "Membership: " + getMembership() + ";\n";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO MEMBER VALUES (" + getId()
                            + ", '" + getName() + "' , '"
                            + getMembership() + "', "
                            + getNumOfBookings() + ")";
    }
}
