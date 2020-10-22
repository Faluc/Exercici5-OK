package com.jobs.view;

import com.jobs.application.JobsController;
import com.jobs.application.PaymentFactory;
import com.jobs.domain.*;
import com.jobs.persistence.EmployeeRepository;

public class Main {

	
	private static com.jobs.persistence.EmployeeRepository employee_list = new EmployeeRepository();
	private static JobsController controller=new JobsController(employee_list);
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666", "no salary");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 80.0);
		controller.createEmployee("Laura Employee2", "Dirección molona 3", "625266666", 45.0);
		
		controller.payAllEmployeers();
		
		String employee_list=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + employee_list + " \n");
		
	}

}
