package src.com.kh.product.view;

import java.util.List;
import java.util.Scanner;

import src.com.kh.product.controller.ProductController;
import src.com.kh.product.model.vo.Product;

public class ProductView {
	
	private Scanner sc = new Scanner(System.in);
	private ProductController pc = new ProductController();
	
	
	public void mainMenu() {
		
		
		while(true) {
		System.out.println("======= 상품 관리 목록 입니다.========");
		System.out.println("1. 상품 전체 조회 ");
		System.out.println("2. 상품명으로 검색하기 ");
		System.out.println("3. 상품 추가 등록하기 ");
		System.out.println("4. 상품 가격 수정하기 ");
		System.out.println("5. 상품 재고 수정하기 ");
		System.out.println("6. 상품 삭제하기 ");
		System.out.println("0. 메인메뉴로 돌아가기 ");
		System.out.print("메뉴번호를 입력해주세요 > ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
		case 1 : findAll();break;
		case 2 : findByName(); break;
		case 3 : save(); break;
		case 4 : updatePrice(); break;
		case 5 : updateStock(); break;
		case 6 : delete(); break;
		case 0 : System.out.println("메인 메뉴로 돌아갑니다."); return;
		default : System.out.println("잘못된 메뉴 선택입니다.");
		}
		
	}

  }



	private void findAll() {
		
		System.out.println("\n ===== 상품 전체 조회 =====");
		
		List<Product> products = pc.findAll();
		
		System.out.println("\n조회된 총 상품수는 " + products.size());
		if(products.isEmpty()) {
			System.out.println("상품이 존재하지 않습니다.");
		} else {
			for(Product product : products) {
				System.out.println("=======================");
				System.out.print("상품 번호 : " + product.getProductId());
				System.out.print(" | 상품명 : " + product.getName());
				System.out.print(" | 상품 종류 : " + product.getCategory());
				System.out.print(" | 가격 : " + product.getPrice());
				System.out.print(" | 재고 : " + product.getStock());
				System.out.println("\n");
			}
		}
		
	}
	
	
	private void findByName() {
		
		System.out.println("\n == 제품명으로 검색하기 == ");
		System.out.print("검색할 제품명을 입력해주세요 > ");
		String name = sc.nextLine();
		
		Product product = pc.findByName(name);
		
		if(product != null) {
			System.out.println("\n " + name + "의 검색 결과입니다.");
			System.out.println("=================================");
			System.out.print("상품 번호 : " + product.getProductId());
			System.out.print(" | 상품명 : " + product.getName());
			System.out.print(" | 상품 종류 : " + product.getCategory());
			System.out.print(" | 가격 : " + product.getPrice());
			System.out.print(" | 재고 : " + product.getStock());
			System.out.println();
		} else {
			System.out.println("상품이 존재하지 않습니다. ");
		}
		
	}
	
	
	private void save() {
		
		System.out.println("======= 상품 추가 =======");
		
		System.out.print("상품 번호를 입력해주세요 > ");
		int productId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("상품명을 입력해주세요 > ");
		String name = sc.nextLine();
		
		System.out.print("상품 종류를 입력해주세요 >");
		String category = sc.nextLine();
		
		System.out.print("가격을 입력해주세요 > ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("재고 수량을 입력해주세요 > ");
		int stock = sc.nextInt();
		sc.nextLine();
		
		int result = pc.save(productId, name, category, price, stock);
		
		if(result > 0) {
			System.out.println("\n 상품등록에 성공하였습니다.");
		} else {
			System.out.println("\n 상품등록에 실패하셨습니다. ");
		}
		
	}
	
	private void updatePrice() {
		System.out.println("\n 제품 가격수정 서비스입니다. ");
		
		System.out.print("제품 번호를 입력해주세요 > ");
		int productId = sc.nextInt();
		sc.nextLine();
		System.out.print("제품명을 입력해주세요 > ");
		String name = sc.nextLine();
		System.out.print("변경된 가격을 입력해주세요 > ");
		int newPrice = sc.nextInt();
		sc.nextLine();
		
		int result = pc.updatePrice(productId,name, newPrice);
		
		if(result > 0) {
			System.out.println("가격 변경에 성공하셨습니다. ");
		} else {
			System.out.println("제품명, 제품번호 확인해주세요.");
		}
		
	}
	
    private void updateStock() {
    	
        System.out.println("\n 제품 가격수정 서비스입니다. ");
		
		System.out.print("제품 번호를 입력해주세요 > ");
		int productId = sc.nextInt();
		sc.nextLine();
		System.out.print("제품명을 입력해주세요 > ");
		String name = sc.nextLine();
		System.out.print("재고수량을 입력해주세요 > ");
		int newStock = sc.nextInt();
		sc.nextLine();
		
		int result = pc.updateStock(productId,name, newStock);
		
		if(result > 0) {
			System.out.println("재고 변경에 성공하셨습니다. ");
		} else {
			System.out.println("제품명, 제품번호 확인해주세요.");
		}
		
	}
	
	
	private void delete() {

		System.out.println("=========== 상품 삭제 ===========");
		
		System.out.print("삭제할 제품 번호를 입력해주세요 > ");
		int productId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("삭제할 제품명을 입력해주세요 > ");
		String name = sc.nextLine();
		
		int result = pc.delete(productId, name);
		
		if(result > 0) {
			System.out.println("상품이 삭제되었습니다.");
		} else {
			System.out.println("삭제 실패했습니다.");
		}
		
	}
	
}