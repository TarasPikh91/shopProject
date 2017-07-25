package com.shop.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Guarantee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate startTime;
	private String guaranteeTime;
	private LocalDate endTime;

	@OneToMany(mappedBy = "guarantee")
	private List<Commodity> commodities = new ArrayList<Commodity>();

	public Guarantee() {
		// TODO Auto-generated constructor stub
	}

	public Guarantee(LocalDate startTime, String guaranteeTime, LocalDate endTime){
		this.startTime = startTime;
		this.guaranteeTime = guaranteeTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public String getGuaranteeTime() {
		return guaranteeTime;
	}

	public void setGuaranteeTime(String guaranteeTime) {
		this.guaranteeTime = guaranteeTime;
	}

}
