package LMS;

import java.util.ArrayList;
import java.util.Scanner;

class C01Student
{
	String stdId;
	String stdName;
	String stdAddr;
	String stdPhone;
	ArrayList<String> Subject=new ArrayList();	//수강신청과목 저장 
}

public class C01StudentMenu {
	
	public static ArrayList<C01Student> Stdlist = new ArrayList();
	int Curidx;	// 현재 로그인한 학생 idx 저장  
	
	C01TeacherMenu T;
	
	Scanner sc = new Scanner(System.in);
	int no=0;
	
	void run() {
		while(true)
		{
		System.out.println("------------ 학생메뉴 -------------");
		System.out.println("1.계정 등록");
		System.out.println("2.로그  인");
		System.out.println("3.로그 아웃");
		System.out.println("4.내 강의실");
		System.out.println("5.수강 신청");
		System.out.println("6.신청 취소");
		System.out.println("7.정보 수정");
		System.out.println("8.계정 삭제");
		System.out.println("9.종료");
		System.out.println("------------ 학생메뉴 -------------");
		System.out.print("입력 :");
		no = sc.nextInt();
		switch(no)
		{
		case 1:
			//C01StudentMenu객체를 만들고 
			//각정보 입력한 후
			//ArrayList에 추가합니다
			sc.nextLine();
			C01Student newstd=new C01Student();
			System.out.print("ID: ");
			newstd.stdId=sc.nextLine();
			System.out.print("Name: ");
			newstd.stdName=sc.nextLine();
			System.out.print("Addr: ");
			newstd.stdAddr=sc.nextLine();
			System.out.print("Phone: ");
			newstd.stdPhone=sc.nextLine();
			Stdlist.add(newstd);
			System.out.println("등록완료");
			break;
		case 2:
			//로그인
			//ArrayList에 해당 stdId가 있는 idx를 CurIdx에 저장
			sc.nextLine();
			System.out.print("ID 입력: ");
			String ID=sc.nextLine();
			boolean flag=false;
			for(int i=0;i<Stdlist.size();i++) {
				if(ID.equals(Stdlist.get(i).stdId)) {
					Curidx=i;
					flag=true;
					break;
				}
				if(flag==true)
					System.out.println("로그인 성공");
				else
					System.out.println("로그인 실패");
			}
			break;
		case 3:
			//로그아웃
			//CurIdx 에 9999값 넣음
			System.out.println();
			Curidx=9999;
			break;
		case 4:
			//내가 신청한 과목 정보 출력(여러 과목일수 있음)
			C01Student cur=Stdlist.get(Curidx);
			for(int i=0;i<cur.Subject.size();i++) {
				System.out.println("----------수강신청과목List------------");
				System.out.println((i+1)+cur.Subject.get(i));
			}
			break;
		case 5:
			//CurIdx에 있는 학생 정보객체에 과목을 입력받아 저장
			sc.nextLine();
			for(int i=0;i<C01TeacherMenu.Tchlist.size();i++) {
				System.out.println((i+1)+" "+C01TeacherMenu.Tchlist.get(i).Subject+" "+C01TeacherMenu.Tchlist.get(i).name+"\n");
			}
			System.out.print("신청과목명 입력: ");
			String sub=sc.nextLine();
			for(int i=0;i<C01TeacherMenu.Tchlist.size();i++) {
				if(sub.equals(C01TeacherMenu.Tchlist.get(i).Subject)) {
					Stdlist.get(Curidx).Subject.add(sub);
					System.out.println("수강신청완료");
				}
				else
					System.out.println("해당 과목은 존재하지 않습니다");
			}
			break;
		case 6:
			//신청 취소할 과목을 입력받아
			//동일한 과목이 있다면 삭제(NULL값 입력)
			sc.nextLine();
			boolean flags=false;
			C01Student cur1=Stdlist.get(Curidx);
			for(int i=0;i<cur1.Subject.size();i++) {
				System.out.println("----------수강신청과목List------------");
				System.out.println((i+1)+cur1.Subject.get(i));
			}
			System.out.print("취소과목입력: ");
			String rm=sc.nextLine();
			for(int i=0;i<cur1.Subject.size();i++) {
				if(rm.equals(cur1.Subject.get(i))) {
					cur1.Subject.remove(i);
					System.out.println("취소완료!");
					flags=true;
					break;
				}
			}
			if(flags==false) {
				System.out.println(rm+"과목 수강취소 실패");
			}
			break;
		case 7:
			//학생정보를 수정
			if(Curidx==9999) {
				System.out.println("로그인 하세요");
			}
			else {
				System.out.println("Login ID: "+Stdlist.get(Curidx));
				System.out.println("Name: "+Stdlist.get(Curidx).stdName);
				System.out.println("Addr: "+Stdlist.get(Curidx).stdAddr);
				System.out.println("Phone: "+Stdlist.get(Curidx).stdPhone);
				System.out.print("수정할 정보 번호 입력: ");
				int num=sc.nextInt();
				switch(num) 
				{
				case 1:
					System.out.println("변경 ID 입력: ");
					String tmpID=sc.nextLine();
					Stdlist.get(Curidx).stdId=tmpID;
					break;
				case 2:
					System.out.println("변경 이름 입력: ");
					String tmpname=sc.nextLine();
					Stdlist.get(Curidx).stdName=tmpname;
					break;
				case 3:
					System.out.println("변경 주소 입력: ");
					String tmpaddr=sc.nextLine();
					Stdlist.get(Curidx).stdAddr=tmpaddr;
					break;
				case 4:
					System.out.println("변경 연락처 입력: ");
					String tmpphone=sc.nextLine();
					Stdlist.get(Curidx).stdPhone=tmpphone;
					break;
				default:
					System.out.println("잘못 입력하셨습니다");
					
				}
			}
			break;
		case 8:
			//계정삭제
			//현재 CurIdx 를 리스트에서 제거 
			if(Curidx==9999) {
				System.out.println("로그인 하세요");
			}
			else {
				System.out.print("정말 삭제할 건가요?(Y/N)? ");
				String tmp=sc.nextLine();
				if(tmp.charAt(0)=='y'||tmp.charAt(0)=='Y') {
					Stdlist.remove(Curidx);
					System.out.println("계정 삭제 성공!");
				}
				else {
					System.out.println("계정 삭제 실패!");
				}
			}
			break;
		case 9:
			//종료
			return ;
		default :
			//잘못입력 다시
		}
		
		
		
		}	
		
	}
}
