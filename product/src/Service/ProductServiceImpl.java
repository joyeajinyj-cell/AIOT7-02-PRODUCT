package Service;

import java.util.List;

import DAO.ProductDAO;
import DTO.Product;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> list() {
        // DAO객체로 게시글 목록을 요청
        List<Product> productlist = productDAO.list();
        // 게시글 목록 데이터 반환
        return productlist;
    }

    @Override
    public Product select(int no) {
        // 게시글 번호 no를 DB로 넘겨주고 게시글 정보 요청
        Product product = productDAO.select(no);
        // 게시글 정보 반환
        return product;
    }

    @Override
    public int insert(Product product) {
        // 게시글 정보를 전달하여 DB에 데이터 등록 요청
        int result = productDAO.insert(product);
        // - result(결과 )         : 0 --> 데이터 등록 실패
        //                         : 1 --> 데이터 등록 성공
        if (result > 0)  System.out.println("데이터 등록 성공");
        else System.out.println("데이터 등록 실패");
        return result;                 
    }

    @Override
    public int update(Product product) {
        int result = productDAO.update(product);
        if (result > 0)  System.out.println("데이터 수정 성공");
        else System.out.println("데이터 수정 실패");
        return result;
    }

    @Override
    public int delete(int no) {
        int result =productDAO.delete(no);
         if (result > 0)  System.out.println("데이터 삭제 성공");
        else System.out.println("데이터 삭제 실패");
        return result;
    }
    
}
