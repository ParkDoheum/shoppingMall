package kr.hkit.shoppingmall.model;

public class MemberVO {
	private int i_member;
	private String mid;
	private String mpw;
	private String nm;
	private String r_date;
	
	public int getI_member() {
		return i_member;
	}
	public void setI_member(int i_member) {
		this.i_member = i_member;
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
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	
	@Override
	public String toString() {
		return String.format("i_member: %d / mid: %s / mpw: %s / nm: %s / r_date: %s\n", 
				i_member, mid, mpw, nm, r_date);
	}
}
