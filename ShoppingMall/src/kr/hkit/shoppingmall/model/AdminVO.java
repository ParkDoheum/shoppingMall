package kr.hkit.shoppingmall.model;

public class AdminVO {
	private int i_admin;
	private String mid;
	private String mpw;
	private String nm;	
		
	public int getI_admin() {
		return i_admin;
	}
	public void setI_admin(int i_admin) {
		this.i_admin = i_admin;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	@Override
	public String toString() {
		return String.format("i_admin: %d / mid: %s / mpw: %s / nm: %s\n", 
				i_admin, mid, mpw, nm);
	}
}
