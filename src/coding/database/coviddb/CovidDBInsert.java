package coding.database.coviddb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import coding.database.coviddb.CovidDTO.Response.Body.Items.Item;

//SEQ_POSTTBL.nextval
//String sql = "DELETE FROM usertbl WHERE id=?";
public class CovidDBInsert {
		//1.세션 생성 = connection 연결 port , ip , id , password, protocol
		//127.0.0.1 을 localhost라고 쓰는 것 처럼 바꾸는 것 = 도메인 네임	
		//2 . 버퍼 달아서 통신 ( ALL : SELECT * FROM emp) 
	
	
	public void urlConnect(int totalCount) {
	try {
		String urlString=
				"http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?"+
					"serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D"+
					"&pageNo=1&numOfRows="+
					totalCount+
					"&_type=json";
		URL url=new URL(urlString);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(httpConn.getInputStream(), "utf-8"));

        String responseJson = br.readLine();
        Gson gson = new Gson();
        CovidDTO dto = gson.fromJson(responseJson, CovidDTO.class);
        List<Item> resultDBItems = dto.getResponse().getBody().getItems().getItem();
        listInsert(resultDBItems);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} 
	}
		public void listInsert(List<Item> dbItems) {
			try {
				Connection dbConn = DriverManager.getConnection
						   ("jdbc:oracle:thin:@localhost:1521:xe","SCOTT","TIGER");
				System.out.println("DB연결완료");
				//이게 소켓통신에서 선과 같은 분류다.
				//update쿼리
				
				String sqlDelete = "DELETE FROM covid";
				PreparedStatement pstmt= dbConn.prepareStatement(sqlDelete);
				
				int resultcode =pstmt.executeUpdate(); //delete, update , insert 내부에 commit 이 존재한다.
				if(resultcode > 0) {
					System.out.println("변경에 성공했습니다.");
				}else if (resultcode==0) {
					System.out.println("변경되지 않았습니다.");
				}
				
				
				String sqlInsert = "INSERT INTO covid (hosno, yadmNm, sidoCdNm , sgguCdNm, recuClCd, rprtWorpClicFndtTgtYn, addr, telno,ratPsblYn,pcrPsblYn,mgtStaDd,XPos,YPos,XPosWgs84,YPosWgs84) VALUES(SEQ_POSTTBL.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt= dbConn.prepareStatement(sqlInsert);
				//실패 -1 성공 수행된(생성,삭제,수정) row 갯수,아무 변화 없으면 0	
				for(int i=0;i<dbItems.size();i++) {
				pstmt.setString(1,dbItems.get(i).getYadmNm());
				pstmt.setString(2,dbItems.get(i).getSidoCdNm());
				pstmt.setString(3,dbItems.get(i).getSgguCdNm());
				pstmt.setInt(4, dbItems.get(i).getRecuClCd());
				pstmt.setString(5,dbItems.get(i).getRprtWorpClicFndtTgtYn());
				pstmt.setString(6,dbItems.get(i).getAddr());
				pstmt.setString(7,dbItems.get(i).getTelno());
				pstmt.setString(8,dbItems.get(i).getRatPsblYn());
				pstmt.setString(9,dbItems.get(i).getPcrPsblYn());
				pstmt.setString(10,dbItems.get(i).getMgtStaDd());
				pstmt.setInt(11, dbItems.get(i).getXPos());
				pstmt.setInt(12, dbItems.get(i).getYPos());
				pstmt.setFloat(13, dbItems.get(i).getXPosWgs84());
				pstmt.setFloat(14, dbItems.get(i).getYPosWgs84());
				
				
				resultcode =pstmt.executeUpdate(); //delete, update , insert 내부에 commit 이 존재한다.
				if(resultcode > 0) {
					System.out.println("변경에 성공했습니다.");
				}else if (resultcode==0) {
					System.out.println("변경되지 않았습니다.");
				}
				}
				
				System.out.println("==========DB준비완료=========");

			} catch (Exception e) {
				// TODO: handle exception
				  System.out.println("조회중 오류가 발생했습니다." + e.getMessage());
				e.printStackTrace();
			}
		
			}
		
		public void listSelect(
				String sidoCdNm,
				String sgguCdNm
				) {
			try {
				Connection conn = DriverManager.getConnection
						   ("jdbc:oracle:thin:@localhost:1521:xe","SCOTT","TIGER");
				System.out.println("DB연결완료");
				String sql = "SELECT * FROM covid WHERE sidoCdNm=? AND sgguCdNm=?";
				PreparedStatement pstmt= conn.prepareStatement(sql);
				pstmt.setString(1,sidoCdNm);
				pstmt.setString(2,sgguCdNm);
				ResultSet rs =pstmt.executeQuery(); 
				//자기 세상의 자바 세상의 테이블로 만드는 것 = 모델링

				List<Hospital> hosp=new ArrayList<>();
				while (rs.next()) {
					
					Hospital hos =new Hospital(
							rs.getString("yadmnm"),
							rs.getString("addr"),
							rs.getString("telno"),
							rs.getString("rprtworpclicFndttgtyn"),
							rs.getString("ratpsblyn"),
							rs.getString("pcrpsblyn"),
							rs.getString("mgtstadd")
							); // - > 데이터 베이스의 resultdata 를 java로 파싱
					hosp.add(hos);
				}
				for(Hospital h : hosp) {
					System.out.println(h);
				}

				System.out.println("완료");


			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		}
