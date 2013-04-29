package com.bit.bitb.biz.entity;

// Generated Apr 29, 2013 8:09:40 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Donedeal generated by hbm2java
 */
@Entity
@Table(name = "donedeal", catalog = "test")
public class Donedeal implements java.io.Serializable {

	private int iddonedeal;
	private String buyer;
	private String seller;
	private String initiator;
	private Float price;
	private Float qty;
	private String note;
	private String idbuying;
	private String idselling;

	public Donedeal() {
	}

	public Donedeal(int iddonedeal) {
		this.iddonedeal = iddonedeal;
	}

	public Donedeal(int iddonedeal, String buyer, String seller,
			String initiator, Float price, Float qty, String note,
			String idbuying, String idselling) {
		this.iddonedeal = iddonedeal;
		this.buyer = buyer;
		this.seller = seller;
		this.initiator = initiator;
		this.price = price;
		this.qty = qty;
		this.note = note;
		this.idbuying = idbuying;
		this.idselling = idselling;
	}

	@Id
	@Column(name = "iddonedeal", unique = true, nullable = false)
	public int getIddonedeal() {
		return this.iddonedeal;
	}

	public void setIddonedeal(int iddonedeal) {
		this.iddonedeal = iddonedeal;
	}

	@Column(name = "buyer", length = 45)
	public String getBuyer() {
		return this.buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	@Column(name = "seller", length = 45)
	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	@Column(name = "initiator", length = 45)
	public String getInitiator() {
		return this.initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
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

	@Column(name = "note", length = 45)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "idbuying", length = 45)
	public String getIdbuying() {
		return this.idbuying;
	}

	public void setIdbuying(String idbuying) {
		this.idbuying = idbuying;
	}

	@Column(name = "idselling", length = 45)
	public String getIdselling() {
		return this.idselling;
	}

	public void setIdselling(String idselling) {
		this.idselling = idselling;
	}

}
