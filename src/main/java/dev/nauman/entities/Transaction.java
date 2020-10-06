package dev.nauman.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACC_ID")
	private Account account;
	private double prevBalance;
	private double finalBalance;
	private double amount;
	private Date date;
	
	
	public Transaction() {
		super();
	}
	
	public Transaction(int tId, Account account, double prevBalance, double finalBalance, double amount, Date date) {
		this.tId = tId;
		this.account = account;
		this.prevBalance = prevBalance;
		this.finalBalance = finalBalance;
		this.amount = amount;
		this.date = date;
	}
	public Transaction(int tId, Account account, double prevBalance, double finalBalance) {
		this.tId = tId;
		this.account = account;
		this.prevBalance = prevBalance;
		this.finalBalance = finalBalance;
		this.amount = finalBalance - prevBalance;
		this.date = new Date();
	}
	
	public Transaction(int tId, Account account, double prevBalance, double finalBalance, double amount) {
		this.tId = tId;
		this.account = account;
		this.prevBalance = prevBalance;
		this.finalBalance = finalBalance;
		this.amount = amount;
		this.date = new Date();
	}
	
	public Transaction(int tId, double prevBalance, double finalBalance, double amount) {
		this.tId = tId;
		this.prevBalance = prevBalance;
		this.finalBalance = finalBalance;
		this.amount = amount;
		this.date = new Date();
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getPrevBalance() {
		return prevBalance;
	}
	public void setPrevBalance(double prevBalance) {
		this.prevBalance = prevBalance;
	}
	public double getFinalBalance() {
		return finalBalance;
	}
	public void setFinalBalance(double finalBalance) {
		this.finalBalance = finalBalance;
	}
	@Override
	public String toString() {
		return "Transaction [tId=" + tId + ", account=" + account + ", prevBalance=" + prevBalance + ", finalBalance="
				+ finalBalance + ", amount=" + amount + ", date=" + date + ", getDate()=" + getDate() + ", gettId()="
				+ gettId() + ", getAccount()=" + getAccount() + ", getAmount()=" + getAmount() + ", getPrevBalance()="
				+ getPrevBalance() + ", getFinalBalance()=" + getFinalBalance() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
