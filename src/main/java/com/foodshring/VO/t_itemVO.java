package com.foodshring.VO;

//아이템
public class t_itemVO {
	    // 아이템 순번
	    private int itemSeq;
	    // 아이템 이름
	    private String itemName;
	    // 아이템 가격
	    private int itemPrice;
	    // 아이템 카테고리
	    private String itemCate;
	    // 아이템 판매자
	    private String mbId;
	    // 아이템 마감시한
	    private String itemDeadline;
	    // 안전주소 순번
	    private int safeSeq;
	    // 등록 날짜
	    private String regString;
	    // 아이템 사진1
	    private String itemImg1;
	    // 아이템 사진2
	    private String itemImg2;
	    // 아이템 사진3
	    private String itemImg3;
	    // 아이템 설명
	    private String itemDesc;
	    public int getItemSeq() {
	        return itemSeq;
	    }
	    public void setItemSeq(int itemSeq) {
	        this.itemSeq = itemSeq;
	    }
	    public String getItemName() {
	        return itemName;
	    }
	    public void setItemName(String itemName) {
	        this.itemName = itemName;
	    }
	    public int getItemPrice() {
	        return itemPrice;
	    }
	    public void setItemPrice(int itemPrice) {
	        this.itemPrice = itemPrice;
	    }
	    public String getItemCate() {
	        return itemCate;
	    }
	    public void setItemCate(String itemCate) {
	        this.itemCate = itemCate;
	    }
	    public String getMbId() {
	        return mbId;
	    }
	    public void setMbId(String mbId) {
	        this.mbId = mbId;
	    }
	    public String getItemDeadline() {
	        return itemDeadline;
	    }
	    public void setItemDeadline(String itemDeadline) {
	        this.itemDeadline = itemDeadline;
	    }
	    public int getSafeSeq() {
	        return safeSeq;
	    }
	    public void setSafeSeq(int safeSeq) {
	        this.safeSeq = safeSeq;
	    }
	    public String getRegString() {
	        return regString;
	    }
	    public void setRegString(String regString) {
	        this.regString = regString;
	    }
	    public String getItemImg1() {
	        return itemImg1;
	    }
	    public void setItemImg1(String itemImg1) {
	        this.itemImg1 = itemImg1;
	    }
	    public String getItemImg2() {
	        return itemImg2;
	    }
	    public void setItemImg2(String itemImg2) {
	        this.itemImg2 = itemImg2;
	    }
	    public String getItemImg3() {
	        return itemImg3;
	    }
	    public void setItemImg3(String itemImg3) {
	        this.itemImg3 = itemImg3;
	    }
	    public String getItemDesc() {
	        return itemDesc;
	    }
	    public void setItemDesc(String itemDesc) {
	        this.itemDesc = itemDesc;
	    }
	    // TItem 모델 복사
		public t_itemVO(int itemSeq, String itemName, int itemPrice, String itemCate, String mbId,
				String itemDeadline, int safeSeq, String regString, String itemImg1, String itemImg2, String itemImg3,
				String itemDesc) {
			super();
			this.itemSeq = itemSeq;
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemCate = itemCate;
			this.mbId = mbId;
			this.itemDeadline = itemDeadline;
			this.safeSeq = safeSeq;
			this.regString = regString;
			this.itemImg1 = itemImg1;
			this.itemImg2 = itemImg2;
			this.itemImg3 = itemImg3;
			this.itemDesc = itemDesc;
		}
	    
	    
	}

