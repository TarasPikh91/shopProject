package com.shop.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class User implements UserDetails {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		private String firstName;
		private String lastName;
		private String userLogin;
		private String password;
		private String email;
		private String age;
		private String phoneNumber;
		private String pathImage;

		private boolean enable;
		private String uuid;

		@Enumerated
		private Role role;

		@ManyToMany
		@JoinTable(name = "commodity_user", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name ="commodity_id"))
		private List<Commodity> commodities = new ArrayList<Commodity>();

		@OneToMany(mappedBy = "user")
		private List<Orders> orders = new ArrayList<Orders>();

		public User() {
			// TODO Auto-generated constructor stub
		}

		public User(String firstName, String lastName, String userLogin, String password, String email, String age, String phoneNumber) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.userLogin = userLogin;
			this.email = email;
			this.password = password;
			this.age = age;
			this.phoneNumber = phoneNumber;
		}

	public User(String userLogIn, String password) {
			this.password=password;
			this.userLogin=userLogIn;
	}

	public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserLogin() {
			return userLogin;
		}

		public void setUserLogin(String userLogin) {
			this.userLogin = userLogin;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEmail() {
			return email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public List<Commodity> getCommodities() {
			return commodities;
		}

		public void setCommodities(List<Commodity> commodities) {
			this.commodities = commodities;
		}

		public List<Orders> getOrders() {
			return orders;
		}

		public void setOrders(List<Orders> orders) {
			this.orders = orders;
		}

		public void setRole(Role role) {
		this.role = role;
	}

		public Role getRole() {
		return role;
	}

		public boolean isEnable() {
			return enable;
		}

		public void setEnable(boolean enable) {
			this.enable = enable;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getPathImage() {
			return pathImage;
		}

		public void setPathImage(String pathImage) {
			this.pathImage = pathImage;
		}

	@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(role.name()));
			return authorities;
		}


		@Override
		public String getUsername() {
			return String.valueOf(id);
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return enable;
		}
}
