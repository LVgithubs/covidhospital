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
        	 String yadmNm,//요양기관명
        	 String sidoCdNm,//시 도 명
        	 String sgguCdNm,//시군구명
        	 int recuClCd,//요양종별 코드 - 종합/병원/의원
        	 String rprtWorpClicFndtTgtYn, //호흡기 전담 클리닉 여부
        	 String addr, //의료기관 주소
        	 String telno,//요양기관 전화번호
        	 String ratPsblYn, //RAT(신속항원검사) 가능 여부
        	 String pcrPsblYn, //PCR 가능 여부
        	 String mgtStaDd, //운영 시작 일자
        	 int XPos,// X좌표
        	 int YPos,//Y좌표
        	 float XPosWgs84,//세계 지구 X좌표
        	 float YPosWgs84,//세계 지구 Y좌표
        	 String ykihoEn){//암호화된 요양기호){
		
		//시도군구를 조회한다
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
			  System.out.println("조회중 오류가 발생했습니다." + e.getMessage());
			e.printStackTrace();
		}
			return null;
		
	}
	



}
