package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String percent;

	@ManyToMany
	@JoinTable(name = "commodity_discount", joinColumns = @JoinColumn(name = "discount_id"),
	inverseJoinColumns = @JoinColumn(name="commodity_id"))
	private List<Commodity> commodities = new ArrayList<Commodity>();

	public Discount() {
		// TODO Auto-generated constructor stub
	}

	public Discount(String name, String percent){
		this.name = name;
		this.percent = percent;
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

	public String  getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	@Override
	public String toString() {
		return name;
	}
}
