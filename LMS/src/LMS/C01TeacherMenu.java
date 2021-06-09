package LMS;

import java.util.ArrayList;
import java.util.Scanner;

class C01Teacher
{
	String TID;
	String name;
	String Subject;
	String Email;
	
	@Override
	public String toString() {return "이름: "+name+" \nID: "+TID+" \nEmail: "+Email+" \nSubject: "+Subject;}
}

public class C01TeacherMenu {
	
	//출석부용
	C01StudentMenu S;
	
	//생성자를 이용해서 메인메뉴에서 만든 학생객체의 주소를 받아
	//S에 저장 
//	C01TeacherMenu(C01StudentMenu stu){
//		this.S=stu;
//	}
	
	void SetS(C01StudentMenu S) {
		this.S=S;
	}
	
	public static ArrayList<C01Teacher> Tchlist = new ArrayList();
	int Curidx;	// 현재 로그인한 교수 Idx 저장
	C01Teacher pro;
	
	Scanner sc = new Scanner(System.in);
	int no;
	
	
	void run() {
		while(true)
		{
		System.out.println("------------ 교수메뉴 -------------");
		System.out.println("1.교수 가입");
		System.out.println("2.로그  인");
		System.out.println("3.로그 아웃");
		System.out.println("4.출 석 부 ");
		System.out.println("5.정보 변경");
		System.out.println("6.계정 삭제");
		System.out.println("7.종료");
		System.out.println("------------ 교수메뉴 -------------");
		System.out.print("입력 :");
		no = sc.nextInt();
		
		switch(no)
		{
		case 1:
			//계정 가입
			//C01Teacher객체 만들고 각멤버에 값 넣어서 (교수ID , 교수이름 , 교수과목, 이메일주소) ArrayList에 저장 
			pro = new C01Teacher();
			System.out.print("ID를 입력하세요: ");
			pro.TID = sc.next();
			System.out.print("이름을 입력하세요: ");
			pro.name = sc.next();
			System.out.print("과목을 입력하세요: ");
			pro.Subject = sc.next();
			System.out.print("이메일 주소를 입력하세요: ");
			pro.Email = sc.next();
			Tchlist.add(pro);
			System.out.println("등록 완료!");
			break;
		case 2:
			//로그인
			//ArrayList에 해당 TId가 있는 idx를 CurIdx에 저장
			sc.nextLine();
			System.out.print("ID 입력: ");
			String ID=sc.nextLine();
			boolean flag=false;
			for(int i=0;i<Tchlist.size();i++) {
				if(ID.equals(Tchlist.get(i).TID)) {
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
			System.out.println(Tchlist.get(Curidx).name+" 님 로그아웃");
			Curidx=9999;
			break;
		case 4:
			//출석부
			//S안에 있는 내용 참고해서 idx에 있는 교수과목과 동일한 과목을 듣는 학생리스트를 출력 
			if(Curidx==9999) {
				System.out.println("로그인 하세요");
			}
			else {
				System.out.println("------------출석부--------------");
				C01Teacher me=Tchlist.get(Curidx);
				
				for(int i=0;i<S.Stdlist.size();i++) {
					for(int j=0;j<S.Stdlist.get(i).Subject.size();j++) {
						if(me.Subject.equals(S.Stdlist.get(j).Subject.get(j))) {
							System.out.println((i+1)+" "+S.Stdlist.get(i).stdName);
							break;
						}
					}
				}
			}
			break;
		case 5:
			//정보변경
			//해당 idx에 있는 정보 변경 
			if(Curidx==9999) {
				System.out.println("로그인 하세요");
			}
			else {
				System.out.println("Login ID: "+Tchlist.get(Curidx));
				System.out.println("Name: "+Tchlist.get(Curidx).name);
				System.out.println("Subject: "+Tchlist.get(Curidx).Subject);
				System.out.println("Email: "+Tchlist.get(Curidx).Email);
				System.out.print("수정할 정보 번호 입력: ");
				int num=sc.nextInt();
				switch(num) 
				{
				case 1:
					System.out.println("변경 ID 입력: ");
					String tmpID=sc.nextLine();
					Tchlist.get(Curidx).TID=tmpID;
					break;
				case 2:
					System.out.println("변경 이름 입력: ");
					String tmpname=sc.nextLine();
					Tchlist.get(Curidx).name=tmpname;
					break;
				case 3:
					System.out.println("변경 과목 입력: ");
					String tmpsub=sc.nextLine();
					Tchlist.get(Curidx).Subject=tmpsub;
					break;
				case 4:
					System.out.println("변경 이메일 입력: ");
					String tmpemail=sc.nextLine();
					Tchlist.get(Curidx).Email=tmpemail;
					break;
				default:
					System.out.println("잘못 입력하셨습니다");
					
				}
			}
			break;
		case 6:
			//계정삭제
			//해당 idx에 있는 정보 삭제 
			if(Curidx==9999) {
				System.out.println("로그인 하세요");
			}
			else {
				System.out.print("정말 삭제할 건가요?(Y/N)? ");
				String tmp=sc.nextLine();
				if(tmp.charAt(0)=='y'||tmp.charAt(0)=='Y') {
					Tchlist.remove(Curidx);
					System.out.println("계정 삭제 성공!");
				}
				else {
					System.out.println("계정 삭제 실패!");
				}
			}
			break;
		case 7:
			//종료
			return ;
		default :
			System.out.println("잘못 입력했습니다. 1~7번까지 입력해주세요");
		}
		
		}
	}
}
