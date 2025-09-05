package com.kh.customer.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.customer.controller.CustomerController;
import com.kh.customer.model.vo.Customer;

public class CustomerView {
	private Scanner sc = new Scanner(System.in);
	private CustomerController cc = new CustomerController();
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println("================================================");
			System.out.println("고객 서비스 입니다.");
			System.out.println("================================================");
			System.out.println("==== 메뉴 ===");
			System.out.println("1. 고객 등록");
			System.out.println("2. 고객 전체 조회");
			System.out.println("3. 고객 아이디(No)로 조회");
			System.out.println("4. 이메일 조회 ");
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
			case 2 : findAll();break;
			case 3 : findById();break;
			case 4 : findByEmail();break;
			case 5 : findByName();break;
			case 6 : update();break;
			case 7 : delete();break;
			case 0 : return;
			default : System.out.println("알맞은 숫자를 입력해주세요.");
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

	private void findAll() {
		System.out.println("== 고객 전체 조회 ==");
		List<Customer> customers =	cc.findAll();
		for(Customer customer : customers) {
			System.out.print("고객 아이디 : " + customer.getCustomerId() 
							+ "\t고객명 : " + customer.getName()
							+ "\t이메일 : " + customer.getEmail()
							+ "\t전화번호 : " + customer.getPhone()
							+ "\t등록일 : "+ customer.getCreateDate());
			System.out.println("");
		}
		
	}
	
	private void findById() {
		System.out.println("== 아이디로 조회 ==");
		System.out.print("아이디를 입력하세요 > ");
		String customerId = sc.nextLine();
		List<Customer> customers =	cc.findById(customerId);
		if(customers.isEmpty()) {
			System.out.println("존재하지 않는 아이디 임");
		}else {
			
			for(Customer customer : customers) {
				System.out.print("고객 아이디 : " + customer.getCustomerId() 
				+ "\t고객명 : " + customer.getName()
				+ "\t이메일 : " + customer.getEmail()
				+ "\t전화번호 : " + customer.getPhone()
				+ "\t등록일 : "+ customer.getCreateDate());
			}
		}
		System.out.println("");
	}
	private void findByEmail() {
		
		System.out.println("== 이메일로 조회 ==");
		System.out.print("이메일을 입력하세요 > ");
		String email = sc.nextLine();
		Customer customer = cc.findByEmail(email);
		if (customer != null) {
			System.out.print("고객 아이디 : " + customer.getCustomerId() 
			+ "\t고객명 : " + customer.getName()
			+ "\t이메일 : " + customer.getEmail()
			+ "\t전화번호 : " + customer.getPhone()
			+ "\t등록일 : "+ customer.getCreateDate());
		}
		
	}
	
	private void findByName() {
		System.out.println("== 아이디로 조회 ==");
		System.out.print("이름을 입력하세요 > ");
		String name = sc.nextLine();
		List<Customer> customers =	cc.findByName(name);
		if(customers.isEmpty()) {
			System.out.println("존재하지 않는 이름 임");
		}else {
			
			for(Customer customer : customers) {
				System.out.print("고객 아이디 : " + customer.getCustomerId() 
				+ "\t고객명 : " + customer.getName()
				+ "\t이메일 : " + customer.getEmail()
				+ "\t전화번호 : " + customer.getPhone()
				+ "\t등록일 : "+ customer.getCreateDate());
			}
		}
		System.out.println("");
	}
	
	private void update() {
		System.out.println("== 고객 정보 수정 ==");

		System.out.print("이름을 입력해주세요 > ");
		String name = sc.nextLine();
		System.out.print("이메일을 입력해주세요 > ");
		String email = sc.nextLine();
		
		System.out.print("새 전화번호를 입력해주세요 > ");
		String newphoneNo = sc.nextLine();

		
		int result = cc.update(name,email,newphoneNo);
		
		if(result > 0) {
			System.out.println("변경에 성공했습니다");
		}else {
			System.out.println("변경에 실패했습니다.");
		}
	}
	
	private void delete() {
		System.out.println("== 고객 삭제 ==");
		System.out.print("삭제할 이메일을 입력하세요 > ");
		String email = sc.nextLine();
		
		int result = cc.delete(email);
		if(result > 0) {
			System.out.println("삭제에 성공하셨습니다.");
		}else {
			System.out.println("삭제에 실패하셨습니다.");
		}
		
	}
}
