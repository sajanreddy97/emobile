package com.emobile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	
	public User() {
		
	} 

	public User(long requestId, String firstName, String lastName, String email, String mobileNumber, String address,
			String city, String state, long zipCode, String documentList, String status, String assignedNumber) {
		this.requestId = requestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.documentList = documentList;
		this.status = status;
		this.assignedNumber = assignedNumber;
	}
	@Id
    @Column(name = "request_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long requestId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private long zipCode;
    @Column(name = "documentList")
    private String documentList;
    @Column(name = "status")
    private String status;
    @Column(name = "assignedNumber")
    private String assignedNumber;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
