package src.com.kh.orders.view;

import java.util.List;
import java.util.Scanner;

import src.com.kh.orders.controller.OrdersController;
import src.com.kh.orders.model.vo.Orders;

public class OrdersView {

	private Scanner sc = new Scanner(System.in);
	private OrdersController oc = new OrdersController();

	public void mainMenu() {

		while (true) {

			System.out.println("주문 서비스 입니다.");
			System.out.println("===============================");
			System.out.println("1. 주문 등록 하기");
			System.out.println("2. 전체 주문 조회 하기");
			System.out.println("3. 주문 수정 하기");
			System.out.println("4. 주문 삭제 하기");
			System.out.println("5. 고객 서비스로 돌아가기");
			System.out.println("===============================");
			System.out.print("메뉴를 선택해주세요 ! > ");
			int menuNo = sc.nextInt();

			switch (menuNo) {
			case 1:
				orderSave();
				break;
			case 2:
				orderFindAll();
				break;
			case 3:
				orderUpdate();
				break;
			case 4:
				orderDelete();
				break;
			case 5:
				return;
			default :
				System.out.println("잘못된 선택입니다.");
			}
		}
	}




	private void orderSave() {
		
		System.out.println("주문하기 서비스 입니다. ");
		
		System.out.print("주문자 아이디를 입력하세요 > ");
		int customerId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("상품 번호를 입력하세요 > ");
		int productId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("주문 수량을 입력해주세요 > ");
		int quantity = sc.nextInt();
		sc.nextLine();
		
		int result = oc.orderSave(customerId, productId, quantity);
		
		if(result > 0) {
			System.out.println("주문 하기 성공");
		} else {
			System.out.println("주문 하기 실패");
		}
	}
	private void orderFindAll() {
		
		System.out.println("전체 주문 조회 하기 서비스");
		
		List<Orders> orders = oc.orderFindAll();
		
		if(orders.isEmpty()) {
			System.out.println("조회결과가 존재하지 않습니다.");
		} else {
			for(Orders order : orders) {
				System.out.println("===================");
				System.out.println("주문 번호 : " + order.getOrderId());
				System.out.println("고객 번호 : " + order.getCustomerId());
				System.out.println("상품 번호 : " + order.getProductId());
				System.out.println("주문 수량 : " + order.getQuantity());
				System.out.println("주문 날짜 : " + order.getOrderDate());
			}
		}
	}
	private void orderUpdate() {
		
		System.out.println("주문 수량 변경하기 > ");
		
		System.out.print("고객의 아이디를 입력해주세요 > ");
		int customerId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("현재 주문 수량을 입력해주세요 > ");
		int quantity = sc.nextInt();
		sc.nextLine();
		
		System.out.print("변경하실 수량을 입력해주세요 > ");
		int newQuantity = sc.nextInt();
		sc.nextLine();
		
		int result = oc.oderUpdate(customerId, quantity, newQuantity);
		
		if(result > 0) {
			System.out.println("변경이 완료되었습니다.");
		} else {
			System.out.println("변경이 실패했습니다. ");
		}
	}
	
	private void orderDelete() {
		
		System.out.println("삭제하기 메뉴입니다. ");
		System.out.println("삭제하실 주문 번호를 입력해주세요 > ");
		int orderId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("삭제하실 고객 아이디를 입력해주세요 > ");
		int customerId = sc.nextInt();
		sc.nextLine();
		
		int result = oc.orderDelete(orderId, customerId);
		
		if(result > 0) {
			System.out.println("삭제가 완료되었습니다. ");
		} else {
			System.out.println("삭제 실패 했습니다.");
		}
	}
}
