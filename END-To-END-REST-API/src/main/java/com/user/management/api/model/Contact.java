package com.user.management.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONTACT_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq_gen")
	@SequenceGenerator(name = "contact_seq_gen", sequenceName = "contact_seq", allocationSize = 1, initialValue = 2001)
	@Column(name = "CONTACT_ID")
	private int contactId;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@OneToOne
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToOne(mappedBy = "contact")
	private UserDetails userDetails;

	public Contact(String phoneNumber, String emailId, Address address, UserDetails userDetails) {
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.address = address;
		this.userDetails = userDetails;
	}

}
