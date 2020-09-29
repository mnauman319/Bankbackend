package dev.nauman.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id @GeneratedValue
	private int aId;
	@ManyToOne
	@JoinColumn(name = "cId")
	private int cId;
	private String name;
	private double balance;
	
	public Account() {
	}
	public Account(int aId, int cId, String name, double balance) {
		this.aId = aId;
		this.cId = cId;
		this.name = name;
		this.balance = balance;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [aId=" + aId + ", cId=" + cId + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
