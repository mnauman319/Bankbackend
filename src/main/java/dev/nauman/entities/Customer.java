package dev.nauman.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id @GeneratedValue @Column(name = "c_id")
	private int  cId;
	private String username;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUST_ID")
	private Set<Account> accounts = new HashSet<Account>();
	
	public Customer(int cId, String username, String password) {
		this.cId = cId;
		this.username = username;
		this.password = password;
	}
	public Customer(int cId, String username, String password, Set<Account> accounts) {
		this.cId = cId;
		this.username = username;
		this.password = password;
//		this.accounts = accounts;
	}
	public Customer() {
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public Set<Account> getAccounts() {
//		return accounts;
//	}
//	public void setAccounts(Set<Account> accounts) {
//		this.accounts = accounts;
//	}
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
