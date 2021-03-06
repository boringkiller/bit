package com.bit.bitb.biz.entity;

// Generated 2013-5-11 23:15:46 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "test")
public class User implements java.io.Serializable {

	private String iduser;
	private String username;
	private Character gender;
	private Integer age;
	private String phone;
	private String moneybalance;
	private String btcbalance;
	private String memo;
	private String address;
	private Date birthday;
	private String email;
	private String mobilephone;
	private String qq;
	private String realname;
	private String weibo;
	private String idcard;
	private String moneyfreeze;
	private String btcfreeze;
	private String password;
	private String tradepwd;
	private String alipayaccount;
	private String bitcoinaccount;
	private String type;

	public User() {
	}

	public User(String iduser) {
		this.iduser = iduser;
	}

	@Id
	@Column(name = "iduser", unique = true, nullable = false, length = 50)
	public String getIduser() {
		return this.iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	@Column(name = "username", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "gender", length = 1)
	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
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

	@Column(name = "moneybalance", length = 100)
	public String getMoneybalance() {
		return this.moneybalance;
	}

	public void setMoneybalance(String moneybalance) {
		this.moneybalance = moneybalance;
	}

	@Column(name = "btcbalance", length = 100)
	public String getBtcbalance() {
		return this.btcbalance;
	}

	public void setBtcbalance(String btcbalance) {
		this.btcbalance = btcbalance;
	}

	@Column(name = "memo", length = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday", length = 19)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobilephone", length = 20)
	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Column(name = "qq", length = 45)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "realname", length = 200)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "weibo", length = 45)
	public String getWeibo() {
		return this.weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	@Column(name = "idcard", length = 45)
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "moneyfreeze", length = 45)
	public String getMoneyfreeze() {
		return this.moneyfreeze;
	}

	public void setMoneyfreeze(String moneyfreeze) {
		this.moneyfreeze = moneyfreeze;
	}

	@Column(name = "btcfreeze", length = 45)
	public String getBtcfreeze() {
		return this.btcfreeze;
	}

	public void setBtcfreeze(String btcfreeze) {
		this.btcfreeze = btcfreeze;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "tradepwd", length = 20)
	public String getTradepwd() {
		return tradepwd;
	}

	public void setTradepwd(String tradepwd) {
		this.tradepwd = tradepwd;
	}

	@Column(name = "alipayaccount", length = 50)
	public String getAlipayaccount() {
		return alipayaccount;
	}

	public void setAlipayaccount(String alipayaccount) {
		this.alipayaccount = alipayaccount;
	}

	@Column(name = "bitcoinaccount", length = 50)
	public String getBitcoinaccount() {
		return bitcoinaccount;
	}

	public void setBitcoinaccount(String bitcoinaccount) {
		this.bitcoinaccount = bitcoinaccount;
	}
	
	@Column(name = "type", length = 20)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User(String iduser, String username, Character gender, Integer age,
			String phone, String moneybalance, String btcbalance, String memo,
			String address, Date birthday, String email, String mobilephone,
			String qq, String realname, String weibo, String idcard,
			String moneyfreeze, String btcfreeze, String password,
			String tradepwd, String alipayaccount, String bitcoinaccount,
			String type) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.moneybalance = moneybalance;
		this.btcbalance = btcbalance;
		this.memo = memo;
		this.address = address;
		this.birthday = birthday;
		this.email = email;
		this.mobilephone = mobilephone;
		this.qq = qq;
		this.realname = realname;
		this.weibo = weibo;
		this.idcard = idcard;
		this.moneyfreeze = moneyfreeze;
		this.btcfreeze = btcfreeze;
		this.password = password;
		this.tradepwd = tradepwd;
		this.alipayaccount = alipayaccount;
		this.bitcoinaccount = bitcoinaccount;
		this.type = type;
	}


}
