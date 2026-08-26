import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import DTO.Product;
import Service.ProductService;
import Service.ProductServiceImpl;

public class Main{
    
    static Scanner sc = new Scanner(System.in);
    static List<Product> products = null;
    static ProductService productService = new ProductServiceImpl();


    public static void menu() {
        System.out.println("::::::::: 상품관리 :::::::::");
        System.out.println("1. 상품 목록");
        System.out.println("2. 상품 조회");
        System.out.println("3. 상품 등록");
        System.out.println("4. 상품 수정");
        System.out.println("5. 상품 삭제");
        System.out.println("0. 프로그램 종료");
        System.out.println(":::::: 번호 입력 : ");
        
    }
    
    /**
     * 상품 목록
    */
   public static void list() {
        System.out.println("::::::::: 상품목록 :::::::::");
        productList = productService.list();
        printAll();
    }
    
    /**
     * 상품 목록 전체 출력
     * @param list
     */

    private static void printAll() {
        if (productList == null || productList.isempty()) {
            System.out.println("조회된 상품이 없습니다.");
            return;
        }
        // 상품 목록 출력
        for(Product product : productList) {
            print(product);
        }
    }
    /**
     * 상품 출력
     * @param product
     */
    private static void print(Product product) {
        if (Product == null) {
            System.out.println("조회할 수 없는 상품입니다.");
            return;
        }
        int no = product.getNo();
        String name = product.getName();
        int price = product.getPrice();
        String description = product.getDescription();
        Date createdAt = product.getCreatedAt();
        Date updatedAt = product.getUpdatedAt();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String reg = sdf.format(createdAt);
        String upd = sdf.format(updatedAt);

        System.out.println(":::::::::::::::::::::::");
        System.out.println("★ 상품번호 : " + no);
        System.out.println("★ 상품명 : " + name);
        System.out.println("★ 가격 : " + price + "원");
        System.out.println("-----------------------");
        System.out.println(" " + description);
        System.out.println("★ 등록일자 : " + createdAt);
        System.out.println("★ 수정일자 : " + updatedAt);
        System.out.println("::::::::::::::::::::::::::");
        System.out.println();
    }
    /**
     * 상품 조회
     */

    public static void select() {
        System.out.println("::::::::: 상품조회 :::::::::");
        System.out.println("상품 번호 : ");
        int no = sc.nextInt();
        sc.nextInt();

        Product product = productService.select(no);
        print(product);
    }

    public static void insert() {
        System.out.println("::::::::: 상품등록 :::::::::");

        Product product = input();
        int result = productService.insert(product);
        if (result > 0) {
            System.out.println("★ 상품이 등록되었습니다.");
        } else {
            System.out.println("★ 상품등록에 실패하였습니다.");
        }
    }

   /**
     * 상품 정보 입력 
     * @return
     */
    private static Product input() {
        System.out.print("★ 상품명 : ");
        String name = sc.nextLine();
        System.out.print("★ 가격 : ");
        String price = sc.nextLine();
        System.out.print("★ 설명 : ");
        String description = sc.nextLine();

        Product product = new Product(name, price, description);
        return product;
    }
    /**
     * 상품 수정
     */
    public static void update() {
        System.out.println("::::::::: 상품수정 :::::::::");

        System.out.println("상품 번호 : ");
        int no = sc.nextInt();
        sc.nextLine();

        Product product = input();
        product.setNo(no);

        // 게시글 수정 요청
        int result = productService.update(product);
        if (result > 0) {
            System.out.println("★ 상품이 수정되었습니다.");
        } else{
            System.out.println("★ 상품수정에 실패하였습니다.");
        }
    }
   /**
    * 상품 삭제
    */
    public static void delete() {
        System.out.println("::::::::: 상품삭제 :::::::::");

        System.out.println("상품 번호 : ");
        int no = sc.nextInt();
        sc.nextInt();
        sc.nextInt();

        // 게시글 삭제요청
        int result = productService.delete(no);
        if (result > 0) {
            System.out.println("★ 게시글을 삭제하였습니다.");
        } else
            System.out.println("★ 게시글삭제에 실패하였습니다.");
   }

    public static void main(String[] args) throws Exception{
        int menuNo = 0;

        do {
            // 메뉴판 출력
            menu();
            // 메뉴번호 입력
            menuNo = sc.nextInt();
            sc.nextLine();
            // 0 프로그램 종료
            if (menuNo == 0) break;
            // 메뉴 선택
            switch (menuNo) {
                case 1: list();         // 게시글 목록
                    break;
                case 2: select();
                    break;
                case 3: insert();
                    break;
                case 4: update();
                    break;
                case 5: delete();
                    break;
            }
        } while (menuNo != 0);
        System.out.println("프로그램을 종료합니다...");
    }
}