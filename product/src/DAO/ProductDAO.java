package DAO;



import java.util.ArrayList;
import java.util.List;

import DTO.Product;


public class ProductDAO extends JDBConnection {
   /**
    * @return productlist
    */
   public List<Product> list() {
    List<Product> productList = new ArrayList<>();

    String sql = " SELECT * "
               + " FROM product";
    
    try{
        stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Product product = new Product();
            product.setNo(rs.getInt("no"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getInt("price"));
            product.setDescription(rs.getNString("description"));
            product.setCreatedAt(rs.getTimestamp("created_at"));
            product.setUpdatedAt(rs.getTimestamp("updated_at"));
            
            productList.add(product);

        }
    } catch (Exception e) {
        System.err.println(" 상품 목록 조회 시, 예외 발생");
        e.printStackTrace();

   
   } return productList;
}
/**
 * 데이터 조회
 * @param no 
 * @return
 */
public Product select(int no) {
    Product product = new Product();
    String sql = " SELECT * " 
               + " FROM product"
               + " WHERE no = ?"; 
    try {
        psmt = con.prepareStatement(sql);
        psmt.setInt(1, no);
        rs = psmt.executeQuery();
    if (rs.next()) {
            product.setNo(rs.getInt("no"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getInt("price"));
            product.setDescription(rs.getNString("description"));
            product.setCreatedAt(rs.getTimestamp("created_at"));
            product.setUpdatedAt(rs.getTimestamp("updated_at"));
    }
    } catch (Exception e) {
       System.err.println("싱품 조회 시, 예외 발생");
            e.printStackTrace();
    }           
    return product;
}

/**
 * 데이터 등록
 * @param product
 * @return
 */
public int insert(Product product) {
    int result = 0;

    String sql = " INSERT INTO product ( no, name, price, description )"
                  + " VALUES( BOARD_SEQ.nextval, ?, ?, ? )";
        
    try {
        psmt = con.prepareStatement(sql);
        psmt.setString(1, product.getName());
        psmt.setInt(2, product.getPrice());
        psmt.setString(3, product.getDescription());
        result = psmt.executeUpdate();
    } catch (Exception e) {
       System.err.println("상품 등록 시, 예외 발생");
            e.printStackTrace();
    }
    return result;
}

public int updat(Product product) {
    int result = 0;

    String sql = " UPDATE product "
                   + " SET name = ? "
                   + "    , price = ? "
                   + "    , description = ? "
                   + "    , updated_at = sysdate "
                   + " WHERE no = ? ";
    try {
        psmt = con.prepareStatement(sql);      
        psmt.setString(1, product.getName());
        psmt.setInt(2, product.getPrice());
        psmt.setString(3, product.getDescription());
        psmt.setInt(4, product.getNo());         // 4번 ? 에 글번호 매핑
            result = psmt.executeUpdate(); 
    } catch (Exception e) {
        System.err.println("상품 수정 시, 예외 발생");
            e.printStackTrace();
    } return result;
}
/**
 * @param no
 * @return
 */
public int delete(int no) {
    int result = 0;
    String sql = " DELETE FROM product "
               + " WHERE no = ? ";
    try {psmt = con.prepareStatement(sql);
            psmt.setInt(1, no);
            result = psmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("상품 삭제 시, 예외 발생");
            e.printStackTrace();
        }
        return result;
}

}

 