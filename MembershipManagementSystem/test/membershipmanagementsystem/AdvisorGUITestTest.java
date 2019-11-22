/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membershipmanagementsystem;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author user
 */
public class AdvisorGUITestTest {
    
    @Test
	public final void testcase1() {
		AdvisorGUI advisorGUI = new AdvisorGUI();
		advisorGUI.setVisible(true);
		Assert.assertTrue(advisorGUI != null);
	}
	
	@Test
	public final void testcase2() {
		Member member = new Member();
		Assert.assertFalse(member.getMembership() == null); // false case 
	}
	
	@Test
	public final void testcase3() {

		MemberRepoImpl memRepo = new MemberRepoImpl();
		AdvisorController control = new AdvisorController();
		Connection conn;
		//sample code to the database connection and sql statements
		String connectionURL = "jdbc:derby://localhost:1527/MembershipManagement";
		String uName = "isa";
		String uPass = "isa";
		//ConnectionURL, username and password specified in getConnection
		try {
			conn = DriverManager.getConnection(connectionURL, uName, uPass);
			System.out.println("Connect to database...");
			if (conn != null) {
				ArrayList list = memRepo.read(conn);

				Assert.assertNotNull(list);
				control.setMemList(list);

				AdvisorGUI gui = new AdvisorGUI(control, conn);
				gui.setVisible(true);
			} else {
				Assert.assertNull("can not get connection ", conn);
			}
		} catch(SQLException ex) {
		}

	}
	
	@Test
	public final void testcase4() {
		viewMembershipForm form = new viewMembershipForm();
		form.setVisible(true);
		
		Assert.assertFalse(form == null);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	@Test
	public final void testcase5() {
		try {
			AdvisorController advisorController = new AdvisorController();
			Assert.assertNotNull("Member list s ", advisorController.getMemList());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    
}
