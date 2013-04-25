package com.bit.bitb.dal.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 会员DO.
 * 
 * @author simple56
 * 
 */
@Entity
@Table(name = "member")
public class MemberDO implements Serializable {
	private static final long serialVersionUID = -5531674844807774471L;
	private String identity;
	private String name;
	private Character sex;
	private Integer age;
	private String phone;
	private Float moneybalance;
	private Float btcbalance;
	private String note;

	public MemberDO() {
	}

	public MemberDO(String identity) {
		this.identity = identity;
	}

	public MemberDO(String identity, String name, Character sex, Integer age,
			String phone, Float moneybalance, Float btcbalance, String note) {
		this.identity = identity;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.moneybalance = moneybalance;
		this.btcbalance = btcbalance;
		this.note = note;
	}

	@Id
	@Column(name = "identity", unique = true, nullable = false, length = 50)
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", length = 1)
	public Character getSex() {
		return this.sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "moneybalance", precision = 12, scale = 0)
	public Float getMoneybalance() {
		return this.moneybalance;
	}

	public void setMoneybalance(Float moneybalance) {
		this.moneybalance = moneybalance;
	}

	@Column(name = "btcbalance", precision = 12, scale = 0)
	public Float getBtcbalance() {
		return this.btcbalance;
	}

	public void setBtcbalance(Float btcbalance) {
		this.btcbalance = btcbalance;
	}

	@Column(name = "note", length = 200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
