package LMS;

import java.util.ArrayList;
import java.util.Scanner;

//class C01StudentPrac
//{
//	String stdId;
//	String stdName;
//	String stdAddr;
//	String stdPhone;
//	String Subject[];	//수강신청과목 저장 
//}

//public class C01StudentMenuPRAC {
//	C01TeacherMenu T;
//
//	ArrayList<C01Student> Stdlist = new ArrayList();
//	int Curidx;	// 현재 로그인한 학생 idx 저장
////	(이 값에 따라 현재 로그인한 사람 누군지 알수 있게)
//	int Stdidx = 0;  
//	
//	Scanner sc = new Scanner(System.in);
//	int no=0;
//	C01Student profile;
//	void run() {
//		while(true)
//		{
//		System.out.println("------------ 학생메뉴 -------------");
//		System.out.println("1.계정 등록");
//		System.out.println("2.로그  인");
//		System.out.println("3.로그 아웃");
//		System.out.println("4.내 강의실");
//		System.out.println("5.수강 신청");
//		System.out.println("6.신청 취소");
//		System.out.println("7.정보 수정");
//		System.out.println("8.계정 삭제");
//		System.out.println("9.종료");
//		System.out.println("------------ 학생메뉴 -------------");
//		System.out.print("입력 :");
//		no = sc.nextInt();
//		switch(no)
//		{
//		case 1:
//			//C01StudentMenu객체를 만들고 
//			//각정보 입력한 후
//			//ArrayList에 추가합니다
//			profile = new C01Student();
//			
//			sc.nextLine();		//계정 등록
//			System.out.print("아이디 : ");
//			profile.stdId = sc.nextLine();
//			System.out.print("이름 : ");
//			profile.stdName = sc.nextLine();
//			System.out.print("주소 : ");
//			profile.stdAddr = sc.nextLine();
//			System.out.print("폰번호 : ");
//			profile.stdPhone = sc.nextLine();
//			
//			Stdlist.add(Stdidx, profile); //?번째 학생프로필 추가
//			
// 			System.out.println(Stdidx);
//			System.out.println(Stdidx+"번째 학생의 아이디 : " + profile.stdId + 
//					"\n이름 : " + profile.stdName +
//					"\n주소 : " + profile.stdAddr + 
//					"\n폰번호 : " + profile.stdPhone);
//			System.out.println(Stdlist); //[LMSPRAC.C01Student@5315b42e]
//											//리스트 안에 객체 주소가 저장?
//			System.out.println(Stdidx+"학생 아이디 : " +Stdlist.get(Stdidx).stdId);
//			System.out.println(Stdidx+"학생 이름 : " +Stdlist.get(Stdidx).stdName);
//			System.out.println(Stdidx+"학생 주소 : " +Stdlist.get(Stdidx).stdAddr);
//			System.out.println(Stdidx+"학생 폰번호 : " +Stdlist.get(Stdidx).stdPhone);
//			
//			Stdidx++;
//			break;
//		case 2:
//			//로그인
//			//아이디 찾기(잊어버렸을때)
//			System.out.println("번호 입력 시 아이디 출력: ");
//			System.out.println(Stdlist.get(sc.nextInt()).stdId);
//			//아이디 입력과 stdlist의 아이디가 같을 때
//			
//			for(int i=0;i<Stdlist.size();i++) {
//				System.out.print("아이디 입력 : ");
//				String id = sc.nextLine();
//				if(!id.equals(Stdlist.get(i).stdId))
//				{
//					System.out.println("잘못된 ID");
//					continue;
//				}
//				else {
//					System.out.println("로그인되었습니다");
////					Curidx = 리스트에서 stdid의 위치;
//					System.out.println(Stdlist.indexOf(Stdlist.get(sc.nextInt()).stdId));
//					Curidx = Stdlist.indexOf(id);
//					break;
//				}
//			}
//			//ArrayList에 해당 stdId가 있는 idx를 CurIdx에 저장?
//			
//			break;
//			
//		case 3:
//			//로그아웃
//			System.out.println("로그아웃");
//			//CurIdx 에 9999값 넣음
//			Curidx = 9999;
//			
//			break;
//		case 4:
//			//내가 신청한 과목 정보 출력(여러 과목일수 있음)
//			
//			break;
//		case 5:
//			//CurIdx에 있는 학생 정보객체에 과목을 입력받아 저장 
//			String Subject[] = new String[T.Tchlist.size()];
//			for(int i=0;i<1;i++) {
//				System.out.print("과목 입력/ : ");
//				Subject[i] = sc.nextLine();
//			}
//			
//			
//			
//			break;
//		case 6:
//			//신청 취소할 과목을 입력받아
//			//동일한 과목이 있다면 삭제(NULL값 입력)
//			break;
//		case 7:
//			//학생정보를 수정
//			break;
//		case 8:
//			//계정삭제
//			//현재 CurIdx 를 리스트에서 제거 
//			break;
//		case 9:
//			//종료
//			return ;
////			return 과 break의 차이점
////					return과  반복문에서 쓰이는 break의 차이점은 뭘까요?
////
////					return은 함수 자체를 중단시키는데 비해 break 명령문이 실행되면 블록 문장에서 빠져나와 다음 작업을 시작합니다.
////
////					즉 return과 break의 차이는 어디까지 빠져나가느냐가 됩니다. 
////
////					return : 함수 탈출. 해당 함수(메소드) 자체에서 빠져나감.
////					break : 루프 탈출. 함수 내의 반복문 에서 빠져나감.
//		default :
//			//잘못입력 다시
//		}
//		
//		
//		
//		}	
//		
//	}
//}
