package com.foodshring.VO;

import java.util.Date;

//댓글
public class t_commentVO {
	   
	    private int cmtSeq;                                /* 댓글 순번 */
	    private int articleSeq;                           /* 원글 순번 */
	    private String cmtContent;                       /* 댓글 내용 */
	    private String cmtDate;                          /* 댓글 작성일자 */
	    private String mbId;                             /*댓글 작성자*/
		
	    public t_commentVO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public t_commentVO(int cmtSeq, int articleSeq, String cmtContent, String cmtDate, String mbId) {
			super();
			this.cmtSeq = cmtSeq;
			this.articleSeq = articleSeq;
			this.cmtContent = cmtContent;
			this.cmtDate = cmtDate;
			this.mbId = mbId;
		}

		public int getCmtSeq() {
			return cmtSeq;
		}

		public void setCmtSeq(int cmtSeq) {
			this.cmtSeq = cmtSeq;
		}

		public int getArticleSeq() {
			return articleSeq;
		}

		public void setArticleSeq(int articleSeq) {
			this.articleSeq = articleSeq;
		}

		public String getCmtContent() {
			return cmtContent;
		}

		public void setCmtContent(String cmtContent) {
			this.cmtContent = cmtContent;
		}

		public String getCmtDate() {
			return cmtDate;
		}

		public void setCmtDate(String cmtDate) {
			this.cmtDate = cmtDate;
		}

		public String getMbId() {
			return mbId;
		}

		public void setMbId(String mbId) {
			this.mbId = mbId;
		}

		@Override
		public String toString() {
			return "t_commentVO [cmtSeq=" + cmtSeq + ", articleSeq=" + articleSeq + ", cmtContent=" + cmtContent
					+ ", cmtDate=" + cmtDate + ", mbId=" + mbId + "]";
		} 
	    
	}