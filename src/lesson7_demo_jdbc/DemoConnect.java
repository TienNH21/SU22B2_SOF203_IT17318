package lesson7_demo_jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import lesson5_demo.Product;

public class DemoConnect {
    public static void main(String[] args) {
        try {
            // B1: Load driver để kết nối tới CDSL
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String dbUser = "sa", dbPass = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=su22b2_sof203";
            
            // B2: Tạo kết nối tới CSDL
            Connection conn = DriverManager
                .getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Kết nối thành công");
            
            // B3: Tạo PreparedStatement & set tham số
//            String query = "SELECT * FROM san_pham";
            Product p = new Product(0, "Ao dai tay", "BLACK", 20, 99, 1);
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
            
            // B5: Đóng kết nối
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
