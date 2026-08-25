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
        System.out.println("1. 상품");
    }


    public static void main(String[] args) throws Exception{
        System.out.println("Hello, World!");
    }
}