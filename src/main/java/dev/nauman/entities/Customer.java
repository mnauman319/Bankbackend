package dev.nauman.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name = "c_id")
	private int  cId;
	private String username;
	private String password;
	private boolean isManager;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CUST_ID")
	private List<Account> accounts = new ArrayList<Account>();
	
	public Customer(int cId, String username, String password) {
		this.cId = cId;
		this.username = username;
		this.password = password;
	}
	public Customer(int cId, String username, String password,boolean isManager) {
		this.cId = cId;
		this.username = username;
		this.password = password;
		this.isManager = isManager;
	}
	public Customer(int cId, String username, String password, List<Account> accounts) {
		this.cId = cId;
		this.username = username;
		this.password = password;
		this.accounts = accounts;
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
	
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
