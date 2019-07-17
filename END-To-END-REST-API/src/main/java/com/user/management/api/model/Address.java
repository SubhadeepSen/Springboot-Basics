package com.user.management.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADDRESS_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_gen")
	@SequenceGenerator(name = "address_seq_gen", sequenceName = "address_seq", allocationSize = 1, initialValue = 3001)
	@Column(name = "ADDRESS_ID")
	private int addressId;

	@Column(name = "FIRSTLINE")
	private String firstLine;

	@Column(name = "SECONDLINE")
	private String secondLine;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@OneToOne(mappedBy = "address")
	private Contact contact;

	public Address(String firstLine, String secondLine, String city, String state, String country, String zipCode,
			Contact contact) {
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.contact = contact;
	}

}
