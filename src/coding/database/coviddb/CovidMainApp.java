package coding.database.coviddb;

import java.util.List;
import java.util.Scanner;

import coding.database.coviddb.CovidDTO.Response.Body.Items.Item;

public class CovidMainApp {

	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CovidDBInsert databased =new CovidDBInsert();
        int totalcount=DownHospital.gettotalCount();
       
        System.out.println("도합 총 갯수는 : " +totalcount ); //도합 데이터 갯수를 들고옵니다.
        System.out.println("데이터베이스에 삽입합니다.===== ");
        databased.urlConnect(totalcount); 
        //데이터 베이스를 들고올 http를 들고 옵니다.
        //이때 totalcount는 데이터의 갯수! 
        //row 1개에 담아올 예정이기 때문에 totalcount를 필요로 합니다.
        //그리고 리스트를 데이터 베이스에 delete로 초기화 하고 넣어줍니다
        System.out.println("======지역구를 입력하세요======");
        System.out.println("Ex:경남, 부산, 서울");
        String sidoCdNm = sc.nextLine();
        //String sidoCdNm = "경남";
        
        
        System.out.println("======시 군 구를 입력하세요======");
        System.out.println("Ex:김해시 , 부산사상구");
        String sgguCdNm = sc.nextLine();
        //String sgguCdNm = "김해시";
        
        
        /**
        
        System.out.println("======RAT 가능 여부가 필요한가요?======");
        System.out.println("Ex:Y , N");
       /// String ratPsblYn = sc.nextLine();
        String ratPsblYn = "Y";
        
        System.out.println("======PCR 가능 여부가 필요한가요?======");
        System.out.println("Ex:Y , N");
        //String pcrPsblYn = sc.nextLine();
        String pcrPsblYn = "Y";
        **/

        //System.out.println(sidoCdNm+ sgguCdNm+rprtWorpClicFndtTgtYn+ ratPsblYn+pcrPsblYn);
        
        System.out.println(sidoCdNm + "의 " + sgguCdNm + " 지역 이용 가능한 코로나 병원 목록을 읽어옵니다.");
        databased.listSelect(sidoCdNm, sgguCdNm);
//해당 안되는중
            // System.out.println();
        }

    }

