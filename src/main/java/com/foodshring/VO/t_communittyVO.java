package com.foodshring.VO;

public class t_communittyVO {                           //게시판
	    private String articleSeq;                      /* 글 번호   */
	    private String articleTitle;                    /* 글 제목   */
	    private String articleContent;                  /* 글 내용   */
	    private String articleFile;                     /* 첨부파일   */
	    private String articleDate;                     /* 글 작성일  */
	    private String mbId;                            /* 글 작성자  */
		
	    public t_communittyVO() {
			super();
		}

		public t_communittyVO(String articleSeq, String articleTitle, String articleContent, String articleFile,
				String articleDate, String mbId) {
			super();
			this.articleSeq = articleSeq;
			this.articleTitle = articleTitle;
			this.articleContent = articleContent;
			this.articleFile = articleFile;
			this.articleDate = articleDate;
			this.mbId = mbId;
		}

		public String getArticleSeq() {
			return articleSeq;
		}

		public void setArticleSeq(String articleSeq) {
			this.articleSeq = articleSeq;
		}

		public String getArticleTitle() {
			return articleTitle;
		}

		public void setArticleTitle(String articleTitle) {
			this.articleTitle = articleTitle;
		}

		public String getArticleContent() {
			return articleContent;
		}

		public void setArticleContent(String articleContent) {
			this.articleContent = articleContent;
		}

		public String getArticleFile() {
			return articleFile;
		}

		public void setArticleFile(String articleFile) {
			this.articleFile = articleFile;
		}

		public String getArticleDate() {
			return articleDate;
		}

		public void setArticleDate(String articleDate) {
			this.articleDate = articleDate;
		}

		public String getMbId() {
			return mbId;
		}

		public void setMbId(String mbId) {
			this.mbId = mbId;
		}

		@Override
		public String toString() {
			return "t_communittyVO [articleSeq=" + articleSeq + ", articleTitle=" + articleTitle + ", articleContent="
					+ articleContent + ", articleFile=" + articleFile + ", articleDate=" + articleDate + ", mbId="
					+ mbId + "]";
		}

	} 