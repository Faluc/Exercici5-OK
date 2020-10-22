package com.jobs.application;

import com.jobs.domain.Employee;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.domain.Volunteer;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Volunteer;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(EmployeeRepository repository){
		this.repository = repository;
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee empleado = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(empleado);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}
	
	
	public void payAllEmployeers() {
		List<AbsStaffMember> workers = new ArrayList<>();
		workers = repository.getAllMembers();
		for (AbsStaffMember e : workers) {
			e.pay();
		}
		
		
	}

	public String getAllEmployees() {
		String employee_list ="\n";
		List<AbsStaffMember> workers = new ArrayList<>();
		workers = repository.getAllMembers();
		for (AbsStaffMember e : workers){
			if ( e instanceof Employee) {
				employee_list = employee_list + e.getname() + "---Salary:" + ((Employee) e).getSalaryPerMonth() + " \n";
			} else if ( e instanceof Volunteer) {
				employee_list = employee_list + e.getname()  + "---" + ((Volunteer) e).getDescription() + " \n";
		
			}
		}
		return employee_list;
	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		Volunteer voluntario = new Volunteer(name, address, phone, "Sin salario");
		repository.addMember(voluntario);
		// TODO Auto-generated method stub
		
	}
	
	
	
}
