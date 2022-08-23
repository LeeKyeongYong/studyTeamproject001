package com.foodshring.VO;
		//회원 테이블 
public class t_memberVO {

	    // 회원 아이디 
	    private String mbId;

		// 회원 비밀번호 
	    private String mbPw;

	    // 회원 이름 
	    private String mbName;

	    // 회원 전화 
	    private String mbPhone;

	    // 회원 생년월일 
	    private String mbBirthdate;

	    // 회원 성별 
	    private String mbGender;

	    // 회원 구분 
	    private String mbGubun;

	    // 회원 주소 
	    private String mbAddr;

	    // 회원 가입일자 
	    private String mbJoindate;

	    // 관리자 여부 
	    private String adminYn;

	    public t_memberVO(String mbId, String mbPw, String mbName, String mbPhone, String mbBirthdate, String mbGender,
				String mbGubun, String mbAddr, String mbJoindate, String adminYn) {
		
			this.mbId = mbId;
			this.mbPw = mbPw;
			this.mbName = mbName;
			this.mbPhone = mbPhone;
			this.mbBirthdate = mbBirthdate;
			this.mbGender = mbGender;
			this.mbGubun = mbGubun;
			this.mbAddr = mbAddr;
			this.mbJoindate = mbJoindate;
			this.adminYn = adminYn;
		}

	    public t_memberVO(String mbId, String mbPw) {
			this.mbId = mbId;
			this.mbPw = mbPw;
		}

		public String getMbId() {
	        return mbId;
	    }

	    public void setMbId(String mbId) {
	        this.mbId = mbId;
	    }

	    public String getMbPw() {
	        return mbPw;
	    }

	    public void setMbPw(String mbPw) {
	        this.mbPw = mbPw;
	    }

	    public String getMbName() {
	        return mbName;
	    }

	    public void setMbName(String mbName) {
	        this.mbName = mbName;
	    }

	    public String getMbPhone() {
	        return mbPhone;
	    }

	    public void setMbPhone(String mbPhone) {
	        this.mbPhone = mbPhone;
	    }

	    public String getMbBirthdate() {
	        return mbBirthdate;
	    }

	    public void setMbBirthdate(String mbBirthdate) {
	        this.mbBirthdate = mbBirthdate;
	    }

	    public String getMbGender() {
	        return mbGender;
	    }

	    public void setMbGender(String mbGender) {
	        this.mbGender = mbGender;
	    }

	    public String getMbGubun() {
	        return mbGubun;
	    }

	    public void setMbGubun(String mbGubun) {
	        this.mbGubun = mbGubun;
	    }

	    public String getMbAddr() {
	        return mbAddr;
	    }

	    public void setMbAddr(String mbAddr) {
	        this.mbAddr = mbAddr;
	    }

	    public String getMbJoindate() {
	        return mbJoindate;
	    }

	    public void setMbJoindate(String mbJoindate) {
	        this.mbJoindate = mbJoindate;
	    }

	    public String getAdminYn() {
	        return adminYn;
	    }

	    public void setAdminYn(String adminYn) {
	        this.adminYn = adminYn;
	    }

	   
	    
	
}
