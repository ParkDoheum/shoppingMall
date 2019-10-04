package kr.hkit.shoppingmall.model;

public class ProductVO {
	private int i_pi;
	private int i_product;
	private String nm;
	private int price;
	private String pic;
	private int qty;
	private int yn_sale;
	private String i_dt;
	private String info;
	private int i_member;
	private int i_basket;
	private int purchase_qty;
	private int purchase_price;
	private int i_purchase;
	private String r_dt;
	
	private int viewPageCnt;
	private String search;
	private int currentPage;
		
	
	public int getViewPageCnt() {
		return viewPageCnt;
	}
	public void setViewPageCnt(int viewPageCnt) {
		this.viewPageCnt = viewPageCnt;
	}	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public int getI_purchase() {
		return i_purchase;
	}
	public void setI_purchase(int i_purchase) {
		this.i_purchase = i_purchase;
	}
	public int getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}
	public int getPurchase_qty() {
		return purchase_qty;
	}
	public void setPurchase_qty(int purchase_qty) {
		this.purchase_qty = purchase_qty;
	}
	public int getI_basket() {
		return i_basket;
	}
	public void setI_basket(int i_basket) {
		this.i_basket = i_basket;
	}
	public int getI_member() {
		return i_member;
	}
	public void setI_member(int i_member) {
		this.i_member = i_member;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getI_dt() {
		return i_dt;
	}
	public void setI_dt(String i_dt) {
		this.i_dt = i_dt;
	}
	public int getI_pi() {
		return i_pi;
	}
	public void setI_pi(int i_pi) {
		this.i_pi = i_pi;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getYn_sale() {
		return yn_sale;
	}
	public void setYn_sale(int yn_sale) {
		this.yn_sale = yn_sale;
	}

}
