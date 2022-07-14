package lesson5_demo;

public class Product {
    private int id;
    private String tenSP;
    private String mauSac;
    private int soLuong;
    private double donGia;
    private int categoryId;

    public Product() {
    }

    public Product(int id, String tenSP, String mauSac, int soLuong, double donGia, int categoryId) {
        this.id = id;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
}
