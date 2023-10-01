package com.gym.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
@Entity
@Table(name="member")
public class Member {

	@Id
	@Column(name="memno")
	private int memno;
	
	@Column(name="memnm")
	private String memnm;
	
	@Column(name="age")
	private int age;
	
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobno")
	private String mobno;
	
	@Column(name="city")
	private String city;

	@Column(name="upto")
	private Date upto;

	public int getMemno() {
		return memno;
	}

	public void setMemno(int memno) {
		this.memno = memno;
	}

	public String getMemnm() {
		return memnm;
	}

	public void setMemnm(String memnm) {
		this.memnm = memnm;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getUpto() {
		return upto;
	}

	public void setUpto(Date upto) {
		this.upto = upto;
	}
	
	
}
