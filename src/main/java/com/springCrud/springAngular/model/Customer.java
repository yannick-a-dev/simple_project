package com.springCrud.springAngular.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "customer")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

	@Id
	@Column(name = "customer_id", length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@Column(name = "customer_name", length = 50)
	private String customerName;
	@Column(name = "customer_address", length = 60)
	private String customerAddress;
	@Column(name = "mobile", length = 12)
	private int mobile;
	

	public Customer(String customerName, String customerAddress, int mobile) {
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.mobile = mobile;
	}
}
