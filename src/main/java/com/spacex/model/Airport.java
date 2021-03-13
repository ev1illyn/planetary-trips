package com.spacex.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Local address;
	
	private String street;
	
	private Double childDiscount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Local getAddress() {
		return address;
	}

	public void setAddress(Local address) {
		this.address = address;
	}
	
	public Airport() {
		
	}
	
	public Airport(String name, Local address, String street, Double childDiscount) {
		super();
		this.name = name;
		this.address = address;
		this.street = street;
		this.childDiscount = childDiscount;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((childDiscount == null) ? 0 : childDiscount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (childDiscount == null) {
			if (other.childDiscount != null)
				return false;
		} else if (!childDiscount.equals(other.childDiscount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	public Double getChildDiscount() {
		return childDiscount;
	}

	public void setChildDiscount(Double childDiscount) {
		this.childDiscount = childDiscount;
	}
	
}
