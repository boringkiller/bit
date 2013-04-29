package com.bit.bitb.biz.entity;

// Generated Apr 29, 2013 8:09:40 PM by Hibernate Tools 3.4.0.CR1

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
	private String buyer;
	private Float price;
	private Float qty;
	private Date validFrom;
	private Date validTo;
	private String note;

	public Buying() {
	}

	public Buying(String idbuying) {
		this.idbuying = idbuying;
	}

	public Buying(String idbuying, String buyer, Float price, Float qty,
			Date validFrom, Date validTo, String note) {
		this.idbuying = idbuying;
		this.buyer = buyer;
		this.price = price;
		this.qty = qty;
		this.validFrom = validFrom;
		this.validTo = validTo;
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

	@Column(name = "buyer", length = 45)
	public String getBuyer() {
		return this.buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "qty", precision = 12, scale = 0)
	public Float getQty() {
		return this.qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
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

	@Column(name = "note", length = 45)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Buying [idbuying=" + idbuying + ", buyer=" + buyer + ", price="
				+ price + ", qty=" + qty + ", validFrom=" + validFrom
				+ ", validTo=" + validTo + ", note=" + note + "]";
	}

}
