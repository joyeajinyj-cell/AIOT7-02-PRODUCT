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
        System.out.println("::::::::: 상품관리 :::::::::");
        productList = productService.list();
        
    }


    public static void main(String[] args) throws Exception{
        System.out.println("Hello, World!");
    }
}