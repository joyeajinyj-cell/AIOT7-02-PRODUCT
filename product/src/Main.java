import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import DTO.Product;
import Service.ProductService;
import Service.ProductServiceImpl;

public class Main {
    
    static Scanner sc = new Scanner(System.in);
    static List<Product> productList = null;
    static ProductService productService = new ProductServiceImpl();

    /**
     * 메뉴판
     */
    public static void menu() {
        System.out.println(":::::::: 게시판 ::::::::");
        System.out.println("1. 상품 목록");
        System.out.println("2. 상품 조회");
        System.out.println("3. 상품 등록");
        System.out.println("4. 상품 수정");
        System.out.println("5. 상품 삭제");
        System.out.println("0. 프로그램 종료");
        System.out.println(":::::::: 번호 입력 : ");
    }

    /**
     * 게시글 목록
     */
    public static void list() {
        System.out.println(":::::::: 싱품 목록 ::::::::");
        // 게시글 목록 데이터 요청
        productList = productService.list();
        printAll();
        }

    /**
     * 글 목록 전체 출력
     * 
     */

    private static void printAll() {
        // 글 목록 존재하는지 확인
        if (productList == null || productList.isEmpty()) {
            System.err.println("조회된 상품이 없습니다.");
            return; // 메소드 종료
            }
        // 글 목록 출력
        for(Product product : productList) {
            print(product);
        }
    }
    
    /**
     * 게시글 출력
     * @param product
     */
    private static void print(Product product) {
        if ( product == null ) {
            System.err.println("조회할 수 없는 상품 입니다.");
            return; // 메소드 종료
        }
        int no = product.getNo();
        String name = product.getName();
        int price = product.getPrice();
        String description = product.getDescription();
        Date createdAt = product.getCreatedAt();
        Date updatedAt = product.getUpdatedAt();
        // 날짜 포맷
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String reg = sdf.format(createdAt);
        String upd = sdf.format(updatedAt);

        System.out.println("::::::::::::::::::::::::::::::::");
        System.out.println(" ★상품 번호 : " + no);
        System.out.println(" ★상품 이름 : " + name);
        System.out.println(" ★가격 : " + price);
        System.out.println("=================================");
        System.out.println(" " + description);
        System.out.println(" ★등록일자 : " + reg);
        System.out.println(" ★수정일자 : " + upd);
        System.out.println("::::::::::::::::::::::::::::::::");
        System.out.println();

    }

    public static void select() {
        System.out.println(":::::::: 상품 조회 ::::::::");
        System.out.print("상품 번호 : ");
        int no = sc.nextInt();
        sc.nextLine();
    
        Product product = productService.select(no);
      
        print(product);
    }

    public static void insert() {
        System.out.println("::::::::: 상품 등록 ::::::::");

        Product product = input();
        // 상품 등록 요청
        int result = productService.insert(product);
        if (result > 0) {
            System.out.println("★상품이 등록되었습니다.");
        }else {
            System.out.println("★상품등록에 실패하였습니다.");
        }

    }
    /**
     * 상품 정보 입력
     * @return 
     */
    private static Product input() {
        System.out.print("★상품 이름 : ");
        String name = sc.nextLine();
        System.out.print("★가격 : ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("★설명 : ");
        String description = sc.nextLine();

        Product product = new Product(name, price, description);
        return product;
    }

    /**
     * 상품 수정    
     */
    public static void update() {
        System.out.println(":::::::: 상품 수정 ::::::::");

        System.out.print("상품 번호 : ");
        int no = sc.nextInt();
        sc.nextLine();

        Product product =  input();
        product.setNo(no);

        //상품 수정 요청
        int result = productService.update(product);
        if (result > 0 ) {
            System.out.println("★상품이 수정되었습니다.");
        } else {
            System.out.println("★상품 수정에 실패하였습니다.");
        }
    }

    /**
     * 게시글 삭제
     */
    public static void delete() {
        System.out.println(":::::::: 게시글 삭제 ::::::::");

        System.out.print("상품 번호 : ");
        int no = sc.nextInt();
        sc.nextLine();

        // 게시글 삭제 요청
        int result = productService.delete(no);
        if (result > 0 ) {
            System.out.println("★상품이 삭제되었습니다.");
        } else {
            System.out.println("★상품 삭제에 실패하였습니다.");
        }
    }



    public static void main(String[] args) throws Exception {
        int menuNo = 0;

        do {
            //메뉴판 출력
            menu();
            //메뉴 번호 입력
            menuNo = sc.nextInt();
            sc.nextLine();
            //0--> 프로그램 종료
            if( menuNo == 0 ) break;
            //메뉴 선택
            switch (menuNo) {
                case 1: list();          // 게시글 목록
                        break;
                case 2: select();        // 게시글 조회
                        break;
                case 3: insert();        // 게시글 등록
                        break;
                case 4: update();        // 게시글 수정
                        break;
                case 5: delete();        // 게시글 삭제
                        break;                                              
            }
        }while (menuNo != 0);

        System.out.println("프로그램을 종료합니다.");
    }
}