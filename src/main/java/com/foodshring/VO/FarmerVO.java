package com.foodshring.VO;

public class FarmerVO {
	
	private String farmerseq;                 // 게시물번호
	private String product;                  //  게시물명
	private String price;                    //  돈
	private String endDay;                  //   마감일자
	private String endTime;                 //   종료시간
	private String category;                //   카테고리
	private String photo;                  //    사진
	private String tEmail;                 //    사용자이메일
	private String stateaddr;              //    거래장소
	private String regDate;               //     작성일자
	private String memberCount;           //     참가멤버
	private String let;                   //     위도
	private String lang;                  //     경도
	private String boxCount;              //     박스갯수
	private String pDetails;              //     상품게시내용
	
	public FarmerVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FarmerVO(String farmerseq, String product, String price, String endDay, String endTime, String category,
			String photo, String tEmail, String stateaddr, String regDate, String memberCount, String let, String lang,
			String boxCount, String pDetails) {
		super();
		this.farmerseq = farmerseq;
		this.product = product;
		this.price = price;
		this.endDay = endDay;
		this.endTime = endTime;
		this.category = category;
		this.photo = photo;
		this.tEmail = tEmail;
		this.stateaddr = stateaddr;
		this.regDate = regDate;
		this.memberCount = memberCount;
		this.let = let;
		this.lang = lang;
		this.boxCount = boxCount;
		this.pDetails = pDetails;
	}

	public String getFarmerseq() {
		return farmerseq;
	}

	public void setFarmerseq(String farmerseq) {
		this.farmerseq = farmerseq;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String getStateaddr() {
		return stateaddr;
	}

	public void setStateaddr(String stateaddr) {
		this.stateaddr = stateaddr;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(String memberCount) {
		this.memberCount = memberCount;
	}

	public String getLet() {
		return let;
	}

	public void setLet(String let) {
		this.let = let;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getBoxCount() {
		return boxCount;
	}

	public void setBoxCount(String boxCount) {
		this.boxCount = boxCount;
	}

	public String getpDetails() {
		return pDetails;
	}

	public void setpDetails(String pDetails) {
		this.pDetails = pDetails;
	}

	@Override
	public String toString() {
		return "FarmerVO [farmerseq=" + farmerseq + ", product=" + product + ", price=" + price + ", endDay=" + endDay
				+ ", endTime=" + endTime + ", category=" + category + ", photo=" + photo + ", tEmail=" + tEmail
				+ ", stateaddr=" + stateaddr + ", regDate=" + regDate + ", memberCount=" + memberCount + ", let=" + let
				+ ", lang=" + lang + ", boxCount=" + boxCount + ", pDetails=" + pDetails + "]";
	}
	
}
