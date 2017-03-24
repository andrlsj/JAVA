package db.manager;

import java.util.Date;

public class Company {
	private String id;
	private String name;
	private String address;
	private String addressInEng;
	private String tel;
	private String fax;
	private String nation;
	private String eName;
	private String abbreviatedName;
	private Date datetime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEname() {
		return eName;
	}
	public void setEname(String ename) {
		this.eName = ename;
	}
	public String getAbbreviatedName() {
		return abbreviatedName;
	}
	public void setAbbreviatedName(String abbreviatedName) {
		this.abbreviatedName = abbreviatedName;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressInEng() {
		return addressInEng;
	}
	public void setAddressInEng(String addressInEng) {
		this.addressInEng = addressInEng;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address
				+ ", addressInEng=" + addressInEng + ", tel=" + tel + ", fax="
				+ fax + ", nation=" + nation + ", eName=" + eName
				+ ", abbreviatedName=" + abbreviatedName + ", datetime="
				+ datetime + "]";
	}
	
}
