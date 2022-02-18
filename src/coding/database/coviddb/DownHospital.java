package coding.database.coviddb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

import coding.database.coviddb.CovidDTO.Response.Body.Items.Item;

public class DownHospital {
	
	public static String urlString=
			"http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?"+
				"serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D"+
				"&pageNo=1&numOfRows=10"+
				"&_type=json";
	
	public static int gettotalCount() {
		
		
		try {
			URL url=new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            String responseJson = br.readLine();
            Gson gson = new Gson();
            CovidDTO dto = gson.fromJson(responseJson, CovidDTO.class);
            
            int totalcount=dto.getResponse().getBody().getTotalCount();
            return totalcount;
            
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	
	
	public List<Item> getList(
        	 String yadmNm,//�������
        	 String sidoCdNm,//�� �� ��
        	 String sgguCdNm,//�ñ�����
        	 int recuClCd,//������� �ڵ� - ����/����/�ǿ�
        	 String rprtWorpClicFndtTgtYn, //ȣ��� ���� Ŭ���� ����
        	 String addr, //�Ƿ��� �ּ�
        	 String telno,//����� ��ȭ��ȣ
        	 String ratPsblYn, //RAT(�ż��׿��˻�) ���� ����
        	 String pcrPsblYn, //PCR ���� ����
        	 String mgtStaDd, //� ���� ����
        	 int XPos,// X��ǥ
        	 int YPos,//Y��ǥ
        	 float XPosWgs84,//���� ���� X��ǥ
        	 float YPosWgs84,//���� ���� Y��ǥ
        	 String ykihoEn){//��ȣȭ�� ����ȣ){
		
		//�õ������� ��ȸ�Ѵ�
			try {
			URL url=new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            String responseJson = br.readLine();
            Gson gson = new Gson();
            CovidDTO dto = gson.fromJson(responseJson, CovidDTO.class);

            List<Item> result = dto.getResponse().getBody().getItems().getItem();
            return result;
            
		} catch (Exception e) {
			// TODO: handle exception
			  System.out.println("��ȸ�� ������ �߻��߽��ϴ�." + e.getMessage());
			e.printStackTrace();
		}
			return null;
		
	}
	



}
