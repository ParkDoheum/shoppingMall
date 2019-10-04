package kr.hkit.shoppingmall.model;

public class StatisticsVO {
	private String r_dt;
	private int i_product;
	private String nm;
	private int price;
	private int qty;
	private int totalPrice;
	
	private String pic;
	private String s_dt;
	private String e_dt;
	private String yearMon;
		
	public String getYearMon() {
		return yearMon;
	}
	public void setYearMon(String yearMon) {
		this.yearMon = yearMon;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getS_dt() {
		return s_dt;
	}
	public void setS_dt(String s_dt) {
		this.s_dt = s_dt;
	}
	public String getE_dt() {
		return e_dt;
	}
	public void setE_dt(String e_dt) {
		this.e_dt = e_dt;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public int getI_product() {
		return i_product;
	}
	public void setI_product(int i_product) {
		this.i_product = i_product;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
