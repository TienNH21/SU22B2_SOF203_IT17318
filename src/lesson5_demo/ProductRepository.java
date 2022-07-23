package lesson5_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository {
    public void insert(Product p)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            System.out.println("Kết nối thành công");
            
            String query = "INSERT INTO san_pham"
                    + "(ten, so_luong, mau_sac, don_gia, danh_muc_id)"
                    + "VALUES (?, ?, ?, ?, ?)";
            //                 1  2  3  4  5

            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, p.getTenSP());
            ps.setInt(2, p.getSoLuong());
            ps.setString(3, p.getMauSac());
            ps.setDouble(4, p.getDonGia());
            ps.setInt(5, p.getCategoryId());

            // B4: Thực thi
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void update(int id, Product p)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            System.out.println("Kết nối thành công");
            
            // B3: Tạo PreparedStatement & set tham số
            String query = "UPDATE san_pham SET " +
                "ten = ?, so_luong = ?, mau_sac = ?, " +
                "don_gia = ?, danh_muc_id = ? " +
                "WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, p.getTenSP());
            ps.setInt(2, p.getSoLuong());
            ps.setString(3, p.getMauSac());
            ps.setDouble(4, p.getDonGia());
            ps.setInt(5, p.getCategoryId());
            ps.setInt(6, id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id)
    {
        try {
            Connection conn = JdbcUtil.getConnection();
            System.out.println("Kết nối thành công");
            
            // B3: Tạo PreparedStatement & set tham số
            String query = "DELETE FROM san_pham WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            // B4: Thực thi
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Product> all()
    {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();
            System.out.println("Kết nối thành công");
            String query = "SELECT * FROM san_pham";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                int soLg = rs.getInt("so_luong");
                String mau = rs.getString("mau_sac");
                double gia = rs.getDouble("don_gia");
                int danhMucId = rs.getInt("danh_muc_id");
                Product p = new Product(id, ten, mau, soLg, gia, danhMucId);
                listProduct.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listProduct;
    }
}
