package com.ba.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Customer.class)
public class Customer {
	public Customer() {
	}


	private String name;

	@Id
	private String id;

	public String getName() {
		return name;
	}

	public Customer setName(String name) {
		this.name = name;
		return this;
	}

	public String getId() {
		return id;
	}

	public Customer setId(String id) {
		this.id = id;
		return this;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"name='" + name + '\'' +
				", id='" + id + '\'' +
				'}';
	}
}
