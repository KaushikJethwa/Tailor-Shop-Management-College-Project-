package com.admin;

public class BlouseBillPojo {
   
	private String name;
	private String date;
	private String clothtype;
	private String shoulder;
	private String chest;
	private String waist;
	private String neck;
	private String lengthofblouse;
	private String lengthofhand;
	private int price;
	private String email;
	private int billNo;
	private int advance;
	private String deliveryDate;
	
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getAdvance() {
		return advance;
	}
	public void setAdvance(int advance) {
		this.advance = advance;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getClothtype() {
		return clothtype;
	}
	public void setClothtype(String clothtype) {
		this.clothtype = clothtype;
	}
	public String getShoulder() {
		return shoulder;
	}
	public void setShoulder(String shoulder) {
		this.shoulder = shoulder;
	}
	public String getChest() {
		return chest;
	}
	public void setChest(String chest) {
		this.chest = chest;
	}
	public String getWaist() {
		return waist;
	}
	public void setWaist(String waist) {
		this.waist = waist;
	}
	public String getNeck() {
		return neck;
	}
	public void setNeck(String neck) {
		this.neck = neck;
	}
	public String getLengthofblouse() {
		return lengthofblouse;
	}
	public void setLengthofblouse(String lengthofblouse) {
		this.lengthofblouse = lengthofblouse;
	}
	public String getLengthofhand() {
		return lengthofhand;
	}
	public void setLengthofhand(String lengthofhand) {
		this.lengthofhand = lengthofhand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
