package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String price;
	private String description;
	private String pathImage;

	@ManyToOne
	private Producer producer;

	@ManyToOne
	private Guarantee guarantee;

	@ManyToMany
	@JoinTable(name = "commodity_orders", joinColumns = @JoinColumn(name="commodity_id"), inverseJoinColumns = @JoinColumn(name="orders_id"))
	private List<Orders> orders = new ArrayList<Orders>();

	@ManyToMany
	@JoinTable(name = "commodity_discount", joinColumns = @JoinColumn(name = "commodity_id"),
			inverseJoinColumns = @JoinColumn(name="discount_id"))
	private List<Discount> discounts = new ArrayList<Discount>();

	@ManyToMany
	@JoinTable(name = "commodity_category", joinColumns = @JoinColumn(name = "commodity_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories = new ArrayList<Category>();

	@ManyToMany
	@JoinTable(name = "commodity_user", joinColumns = @JoinColumn(name="commodity_id"), inverseJoinColumns = @JoinColumn(name ="user_id"))
	private List<User> users = new ArrayList<User>();

	public Commodity() {
		// TODO Auto-generated constructor stub
	}

	public Commodity(String price, String name, String description, String pathImage) {
		super();
		this.price = price;
		this.name = name;
		this.description = description;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public Guarantee getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(Guarantee guarantee) {
		this.guarantee = guarantee;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public String getPathImage() {
		return pathImage;
	}

}
