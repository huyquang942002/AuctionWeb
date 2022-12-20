package entity;



public class User {
	private int id;
	private String name;
	private String password;
	private String phone;
	private String address;
	private int bought_number;
	private int auction_number;
	private int admin;
	
	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBought_number() {
		return bought_number;
	}

	public void setBought_number(int bought_number) {
		this.bought_number = bought_number;
	}

	public int getAuction_number() {
		return auction_number;
	}

	public void setAuction_number(int auction_number) {
		this.auction_number = auction_number;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
