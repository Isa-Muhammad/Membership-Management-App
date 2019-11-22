package membershipmanagementsystem;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public abstract class Member {
    private int id;
    private String name;
    private int numOfBookings;
    private String payStatus;
    
    //Constructor
    public Member(){
    }
    
    //Accessor methods
    public int getId(){
       return id; 
    }
    
    public String getName(){
        return name;
    }
    
    
    public int getNumOfBookings(){
        return numOfBookings;
    }
    
    public String getPayStatus(){
        return payStatus;
    }
    
    //Mutator methods
    public void setId(int anId){
        id = anId;  
    }
    
    public void setName(String aName){
        name = aName;
    }
    
    public void setNumOfBookings(int theNumOfBookings){
        numOfBookings = theNumOfBookings;
    }
    
    public void setPayStatus(String thePayStatus){
        payStatus = thePayStatus;
    }
    
    public abstract String getInsertQuery();
}
