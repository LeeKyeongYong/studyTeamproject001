package com.foodshring.VO;

// 안전주소
public class t_safeVO {
	    // 주소 순번
	    private Double safeSeq;
	    // 주소
	    private String safeAddr;
	    // 중심지
	    private String safeCenter;
	    // 군구
	    private String safeGungu;
	    // 위도
	    private Double latitude;
	    // 경도
	    private Double longitude;
	    public Double getSafeSeq() {
	        return safeSeq;
	    }
	    public void setSafeSeq(Double safeSeq) {
	        this.safeSeq = safeSeq;
	    }
	    public String getSafeAddr() {
	        return safeAddr;
	    }
	    public void setSafeAddr(String safeAddr) {
	        this.safeAddr = safeAddr;
	    }
	    public String getSafeCenter() {
	        return safeCenter;
	    }
	    public void setSafeCenter(String safeCenter) {
	        this.safeCenter = safeCenter;
	    }
	    public String getSafeGungu() {
	        return safeGungu;
	    }
	    public void setSafeGungu(String safeGungu) {
	        this.safeGungu = safeGungu;
	    }
	    public Double getLatitude() {
	        return latitude;
	    }
	    public void setLatitude(Double latitude) {
	        this.latitude = latitude;
	    }
	    public Double getLongitude() {
	        return longitude;
	    }
	    public void setLongitude(Double longitude) {
	        this.longitude = longitude;
	    }
	    // TSafe 모델 복사

		public t_safeVO(Double safeSeq, String safeAddr, String safeCenter, String safeGungu, Double latitude,
				Double longitude) {
			super();
			this.safeSeq = safeSeq;
			this.safeAddr = safeAddr;
			this.safeCenter = safeCenter;
			this.safeGungu = safeGungu;
			this.latitude = latitude;
			this.longitude = longitude;
		}
	    
	}

