package com.foodshring.VO;

//리뷰
public class t_reviewVO {
	    // 리뷰 순번
	    private int reviewSeq;
	    // 아이템 순번
	    private int itemSeq;
	    // 리뷰 내용
	    private String reviewContent;
	    // 리뷰 작성일자
	    private String reviewString;
	    // 리뷰 작성자
	    private String mbId;
	    // 리뷰 평점
	    private int reviewRating;
	    public int getReviewSeq() {
	        return reviewSeq;
	    }
	    public void setReviewSeq(int reviewSeq) {
	        this.reviewSeq = reviewSeq;
	    }
	    public int getItemSeq() {
	        return itemSeq;
	    }
	    public void setItemSeq(int itemSeq) {
	        this.itemSeq = itemSeq;
	    }
	    public String getReviewContent() {
	        return reviewContent;
	    }
	    public void setReviewContent(String reviewContent) {
	        this.reviewContent = reviewContent;
	    }
	    public String getReviewString() {
	        return reviewString;
	    }
	    public void setReviewString(String reviewString) {
	        this.reviewString = reviewString;
	    }
	    public String getMbId() {
	        return mbId;
	    }
	    public void setMbId(String mbId) {
	        this.mbId = mbId;
	    }
	    public int getReviewRating() {
	        return reviewRating;
	    }
	    public void setReviewRating(int reviewRating) {
	        this.reviewRating = reviewRating;
	    }
	    // TReview 모델 복사
		public t_reviewVO(int reviewSeq, int itemSeq, String reviewContent, String reviewString, String mbId,
				int reviewRating) {
			super();
			this.reviewSeq = reviewSeq;
			this.itemSeq = itemSeq;
			this.reviewContent = reviewContent;
			this.reviewString = reviewString;
			this.mbId = mbId;
			this.reviewRating = reviewRating;
		}
	    
	}

