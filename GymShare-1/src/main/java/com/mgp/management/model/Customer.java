package com.mgp.management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="admissionNumber" )
	private long admissionNumber;
	
	@Column(name="userId")
	private String userId;
	
	@Column(name="userName")
	private String name;
	
	@Column(name="userPhone")
	private String phone;
	
	@Column(name="gymName")
	private String gymName;
	
	@Column(name="gymPackage")
	private String gymPackage;
	
	@Column(name="dayPreference")
	private int dayPreference;
	
	public Customer() { }
	

	@Override
	public String toString() {
		return "Customer [admissionNumber="+admissionNumber + ", userId=" + userId + ", name=" + name + ", phone=" + phone + ", gymName=" + gymName
				+ ", gymPackage=" + gymPackage + ", dayPreference=" + dayPreference + "]";
	}

	public Customer(String userId, String name, String phone, String gymName, String gymPackage, int dayPreference) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.gymName = gymName;
		this.gymPackage = gymPackage;
		this.dayPreference = dayPreference;
	}

	
	public long getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(long admissionNumber) {
		this.admissionNumber = admissionNumber;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getGymPackage() {
		return gymPackage;
	}

	public void setGymPackage(String gymPackage) {
		this.gymPackage = gymPackage;
	}

	public int getDayPreference() {
		return dayPreference;
	}

	public void setDayPreference(int dayPreference) {
		this.dayPreference = dayPreference;
	}
	
	

}
