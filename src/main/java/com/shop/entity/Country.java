package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String pathImage;

	@OneToMany(mappedBy = "country")
	private List<City> cities = new ArrayList<City>();

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(String name, String pathImage) {
		super();
		this.name = name;
		this.pathImage = pathImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public String getPathImage() {
		return pathImage;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}

}
