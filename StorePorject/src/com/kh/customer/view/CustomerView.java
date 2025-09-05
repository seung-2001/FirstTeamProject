package com.kh.customer.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.customer.controller.CustomerController;

public class CustomerView {
	private Scanner sc = new Scanner(System.in);
	private CustomerController cc = new CustomerController();
	public void mainMenu() {
		while(true) {
			
			System.out.println("고객 서비스 입니다.");
			System.out.println("================================================");
			System.out.println("==== 메뉴 ===");
			System.out.println("1. 고객 등록");
			System.out.println("2. 고객 전체 조회");
			System.out.println("3. 고객 아이디(No)로 조회");
			System.out.println("4. 고객 전화번호로 조회 ");
			System.out.println("5. 고객 이름 조회 ");
			System.out.println("6. 고객 정보 수정");
			System.out.println("7. 회원 탈퇴");
			System.out.println("0. 종료");
			System.out.print("메뉴 번호를 선택하세요 > ");
			int menuNo = 10;
			try {
				menuNo = sc.nextInt();
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("숫자 입력하세요 ^^");
			}
			
			switch(menuNo) {
			case 1 : save();break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
			case 7 : break;
			case 0 : return;
			default : System.out.println("옳바른 숫자를 입력해주세요.");
			}
			
		}
		
		
	}

	private void save() {
		System.out.println("== 고객 등록 ==");
		System.out.print("고객아이디를 입력해주세요(No) > ");
		String customerId = sc.nextLine();
		System.out.print("이름을 입력해주세요 > ");
		String name = sc.nextLine();
		System.out.print("이메일을 입력해주세요 > ");
		String email = sc.nextLine();
		System.out.print("휴대폰 번호를 입력해주세요 > ");
		String phone = sc.nextLine();
		
		int result = cc.save(customerId,name,email,phone);
		
		if(result > 0) {
			System.out.println("등록에 성공했습니다");
		}else {
			System.out.println("등록에 실패했습니다.");
		}
		
	}

}
