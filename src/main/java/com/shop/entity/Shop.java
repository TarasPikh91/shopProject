package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;

	@OneToMany(mappedBy = "shop")
	private List<Staff> staff = new ArrayList<Staff>();

	@ManyToOne
	private Address address;

	@OneToMany(mappedBy = "shop")
	private List<Producer> producers = new ArrayList<Producer>();

	@OneToMany(mappedBy = "shop")
	private List<Category> categories = new ArrayList<Category>();

	public Shop() {
		// TODO Auto-generated constructor stub
	}

	public Shop(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Producer> getProducers() {
		return producers;
	}

	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
