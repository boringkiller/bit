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
 * Buying generated by hbm2java
 */
@Entity
@Table(name = "buying", catalog = "test")
public class Buying implements java.io.Serializable {

	private String idbuying;
	private String iduser;
	private String memo;
	private String price;
	private String quantity;
	private Date validFrom;
	private Date validTo;
	private Date createTs;
	private Date modifyTs;
	private String buyer;
	private String note;

	public Buying() {
	}

	public Buying(String idbuying) {
		this.idbuying = idbuying;
	}

	public Buying(String idbuying, String iduser, String memo, String price,
			String quantity, Date validFrom, Date validTo, Date createTs,
			Date modifyTs, String buyer, String note) {
		this.idbuying = idbuying;
		this.iduser = iduser;
		this.memo = memo;
		this.price = price;
		this.quantity = quantity;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.createTs = createTs;
		this.modifyTs = modifyTs;
		this.buyer = buyer;
		this.note = note;
	}

	@Id
	@Column(name = "idbuying", unique = true, nullable = false, length = 45)
	public String getIdbuying() {
		return this.idbuying;
	}

	public void setIdbuying(String idbuying) {
		this.idbuying = idbuying;
	}

	@Column(name = "iduser", length = 45)
	public String getIduser() {
		return this.iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	@Column(name = "memo", length = 45)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "price", length = 100)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "quantity", length = 100)
	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "validFrom", length = 19)
	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "validTo", length = 19)
	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_ts", length = 19)
	public Date getCreateTs() {
		return this.createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_ts", length = 19)
	public Date getModifyTs() {
		return this.modifyTs;
	}

	public void setModifyTs(Date modifyTs) {
		this.modifyTs = modifyTs;
	}

	@Column(name = "buyer", length = 45)
	public String getBuyer() {
		return this.buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	@Column(name = "note", length = 45)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
