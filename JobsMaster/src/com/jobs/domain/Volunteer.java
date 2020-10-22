package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	

	private String description;


	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.description = description;
		//TODO
	}
	public String getDescription() {
		return description;
	
	}
	
	@Override
	public void pay() {
		totalPaid = 0;//TODO
		
	}

}
