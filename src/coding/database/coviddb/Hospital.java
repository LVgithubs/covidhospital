package coding.database.coviddb;

public class Hospital {
	

	public Hospital(String yadmNm, String rprtWorpClicFndtTgtYn, String addr, String telno, String ratPsblYn,
			String pcrPsblYn, String mgtStaDd) {
		super();
		this.yadmNm = yadmNm;
		this.rprtWorpClicFndtTgtYn = rprtWorpClicFndtTgtYn;
		this.addr = addr;
		this.telno = telno;
		this.ratPsblYn = ratPsblYn;
		this.pcrPsblYn = pcrPsblYn;
		this.mgtStaDd = mgtStaDd;
	}
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
	
	
	public String stringYN(String yesOrno) {
		String answer;
		if(yesOrno.equals("Y")) {
			answer="가능";
		}else {
			answer="불가";
		}
		return answer;
	}
	
	
	
	@Override
	public String toString() {
		return 
		"-요양기관 이름 이름 :" + yadmNm +
		" 요양 기관 주소 :" + addr 
		+ " 전화번호 : " + telno
		+ " RAT(신속 항원 검사) 가능 여부 : " + stringYN(ratPsblYn) +
		" 호흡기 전담 클리닉 여부 : "+ stringYN(rprtWorpClicFndtTgtYn)+
		" PCR 가능 여부" + stringYN(pcrPsblYn) + 
		" 병원 개원 날짜 - " + mgtStaDd + "-";
	}
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

}
