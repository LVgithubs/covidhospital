package coding.database.coviddb;

import java.util.List;

public class CovidDTO {
		private Response response; // 변수명을 꼭 동일하게!!
		
	    public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
		
		
	    class Response {
	        private Header header; // 변수명을 꼭 동일하게!!

	        public Header getHeader() {
				return header;
			}

			public void setHeader(Header header) {
				this.header = header;
			}

			public Body getBody() {
				return body;
			}

			public void setBody(Body body) {
				this.body = body;
			}

			private Body body; // 변수명을 꼭 동일하게!!


	        class Header {
	            private String resultCode;
	            private String resultMsg;
				public String getResultCode() {
					return resultCode;
				}
				public void setResultCode(String resultCode) {
					this.resultCode = resultCode;
				}
				public String getResultMsg() {
					return resultMsg;
				}
				public void setResultMsg(String resultMsg) {
					this.resultMsg = resultMsg;
				}

	        }

	        class Body {
	            private Items items;
	            private int numOfRows;
	            private int pageNo;

	            private int totalCount;

	            public Items getItems() {
					return items;
				}

				public void setItems(Items items) {
					this.items = items;
				}

				public int getNumOfRows() {
					return numOfRows;
				}

				public void setNumOfRows(int numOfRows) {
					this.numOfRows = numOfRows;
				}

				public int getPageNo() {
					return pageNo;
				}

				public void setPageNo(int pageNo) {
					this.pageNo = pageNo;
				}

				public int getTotalCount() {
					return totalCount;
				}

				public void setTotalCount(int totalCount) {
					this.totalCount = totalCount;
				}

				class Items {

	                private List<Item> item;

	                public List<Item> getItem() {
						return item;
					}

					public void setItem(List<Item> item) {
						this.item = item;
					}

					class Item {
	                	
	                	private String yadmNm;//요양기관명
	                	private String sidoCdNm;//시 도 명
	                	private String sgguCdNm;//시군구명
	                	private int recuClCd;//요양종별 코드 - 종합/병원/의원
	                	private String rprtWorpClicFndtTgtYn; //호흡기 전담 클리닉 여부
	                	private String addr; //의료기관 주소
	                	private String telno;//요양기관 전화번호
	                	private String ratPsblYn; //RAT(신속항원검사) 가능 여부
	                	private String pcrPsblYn; //PCR 가능 여부
	                	private String mgtStaDd; //운영 시작 일자

	                	private int XPos;// X좌표
	                	private int YPos;//Y좌표
	                	private float XPosWgs84;//세계 지구 X좌표
	                	private float YPosWgs84;//세계 지구 Y좌표
	                	private String ykihoEnc;//암호화된 요양기호
						public String getYadmNm() {
							return yadmNm;
						}
						public void setYadmNm(String yadmNm) {
							this.yadmNm = yadmNm;
						}
						public String getSidoCdNm() {
							return sidoCdNm;
						}
						public void setSidoCdNm(String sidoCdNm) {
							this.sidoCdNm = sidoCdNm;
						}
						public String getSgguCdNm() {
							return sgguCdNm;
						}
						public void setSgguCdNm(String sgguCdNm) {
							this.sgguCdNm = sgguCdNm;
						}
						public int getRecuClCd() {
							return recuClCd;
						}
						public void setRecuClCd(int recuClCd) {
							this.recuClCd = recuClCd;
						}
						public String getRprtWorpClicFndtTgtYn() {
							return rprtWorpClicFndtTgtYn;
						}
						public void setRprtWorpClicFndtTgtYn(String rprtWorpClicFndtTgtYn) {
							this.rprtWorpClicFndtTgtYn = rprtWorpClicFndtTgtYn;
						}
						public String getAddr() {
							return addr;
						}
						public void setAddr(String addr) {
							this.addr = addr;
						}
						public String getTelno() {
							return telno;
						}
						public void setTelno(String telno) {
							this.telno = telno;
						}
						public String getRatPsblYn() {
							return ratPsblYn;
						}
						public void setRatPsblYn(String ratPsblYn) {
							this.ratPsblYn = ratPsblYn;
						}
						public String getPcrPsblYn() {
							return pcrPsblYn;
						}
						public void setPcrPsblYn(String pcrPsblYn) {
							this.pcrPsblYn = pcrPsblYn;
						}
						public String getMgtStaDd() {
							return mgtStaDd;
						}
						public void setMgtStaDd(String mgtStaDd) {
							this.mgtStaDd = mgtStaDd;
						}
						public int getXPos() {
							return XPos;
						}
						public void setXPos(int xPos) {
							XPos = xPos;
						}
						public int getYPos() {
							return YPos;
						}
						public void setYPos(int yPos) {
							YPos = yPos;
						}
						public float getXPosWgs84() {
							return XPosWgs84;
						}
						public void setXPosWgs84(float xPosWgs84) {
							XPosWgs84 = xPosWgs84;
						}
						public float getYPosWgs84() {
							return YPosWgs84;
						}
						public void setYPosWgs84(float yPosWgs84) {
							YPosWgs84 = yPosWgs84;
						}
						public String getYkihoEnc() {
							return ykihoEnc;
						}
						public void setYkihoEnc(String ykihoEnc) {
							this.ykihoEnc = ykihoEnc;
						}

	                	           	
	                }
	            }
	        }
	    }
	}

