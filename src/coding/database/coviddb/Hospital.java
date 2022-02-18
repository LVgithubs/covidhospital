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
	private String yadmNm;//�������
	private String sidoCdNm;//�� �� ��
	private String sgguCdNm;//�ñ�����
	private int recuClCd;//������� �ڵ� - ����/����/�ǿ�
	private String rprtWorpClicFndtTgtYn; //ȣ��� ���� Ŭ���� ����
	private String addr; //�Ƿ��� �ּ�
	private String telno;//����� ��ȭ��ȣ
	private String ratPsblYn; //RAT(�ż��׿��˻�) ���� ����
	private String pcrPsblYn; //PCR ���� ����
	private String mgtStaDd; //� ���� ����
	
	
	public String stringYN(String yesOrno) {
		String answer;
		if(yesOrno.equals("Y")) {
			answer="����";
		}else {
			answer="�Ұ�";
		}
		return answer;
	}
	
	
	
	@Override
	public String toString() {
		return 
		"-����� �̸� �̸� :" + yadmNm +
		" ��� ��� �ּ� :" + addr 
		+ " ��ȭ��ȣ : " + telno
		+ " RAT(�ż� �׿� �˻�) ���� ���� : " + stringYN(ratPsblYn) +
		" ȣ��� ���� Ŭ���� ���� : "+ stringYN(rprtWorpClicFndtTgtYn)+
		" PCR ���� ����" + stringYN(pcrPsblYn) + 
		" ���� ���� ��¥ - " + mgtStaDd + "-";
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
