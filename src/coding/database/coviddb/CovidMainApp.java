package coding.database.coviddb;

import java.util.List;
import java.util.Scanner;

import coding.database.coviddb.CovidDTO.Response.Body.Items.Item;

public class CovidMainApp {

	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CovidDBInsert databased =new CovidDBInsert();
        int totalcount=DownHospital.gettotalCount();
       
        System.out.println("���� �� ������ : " +totalcount ); //���� ������ ������ ���ɴϴ�.
        System.out.println("�����ͺ��̽��� �����մϴ�.===== ");
        databased.urlConnect(totalcount); 
        //������ ���̽��� ���� http�� ��� �ɴϴ�.
        //�̶� totalcount�� �������� ����! 
        //row 1���� ��ƿ� �����̱� ������ totalcount�� �ʿ�� �մϴ�.
        //�׸��� ����Ʈ�� ������ ���̽��� delete�� �ʱ�ȭ �ϰ� �־��ݴϴ�
        System.out.println("======�������� �Է��ϼ���======");
        System.out.println("Ex:�泲, �λ�, ����");
        String sidoCdNm = sc.nextLine();
        //String sidoCdNm = "�泲";
        
        
        System.out.println("======�� �� ���� �Է��ϼ���======");
        System.out.println("Ex:���ؽ� , �λ���");
        String sgguCdNm = sc.nextLine();
        //String sgguCdNm = "���ؽ�";
        
        
        /**
        
        System.out.println("======RAT ���� ���ΰ� �ʿ��Ѱ���?======");
        System.out.println("Ex:Y , N");
       /// String ratPsblYn = sc.nextLine();
        String ratPsblYn = "Y";
        
        System.out.println("======PCR ���� ���ΰ� �ʿ��Ѱ���?======");
        System.out.println("Ex:Y , N");
        //String pcrPsblYn = sc.nextLine();
        String pcrPsblYn = "Y";
        **/

        //System.out.println(sidoCdNm+ sgguCdNm+rprtWorpClicFndtTgtYn+ ratPsblYn+pcrPsblYn);
        
        System.out.println(sidoCdNm + "�� " + sgguCdNm + " ���� �̿� ������ �ڷγ� ���� ����� �о�ɴϴ�.");
        databased.listSelect(sidoCdNm, sgguCdNm);
//�ش� �ȵǴ���
            // System.out.println();
        }

    }

