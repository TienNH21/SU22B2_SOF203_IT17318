package lesson5_demo;

import java.util.ArrayList;

public class ProductService {
    private ArrayList<Product> listProd;

    public ProductService() {
        this.listProd = new ArrayList<>();
    }
    
    public void insert(Product p)
    {
        this.listProd.add(p);
    }
    
    public void update(int id, Product p)
    {
        for (int idx = 0; idx < listProd.size(); idx++) {
            Product prod = this.listProd.get(idx);
            if (prod.getId() == id) {
                this.listProd.set(idx, p);
            }
        }
    }

    public void delete(int id)
    {
        for (int i = 0; i < listProd.size(); i++) {
            Product prod = this.listProd.get(i);
            if (prod.getId() == id) {
                this.listProd.remove(i);
            }
        }
    }
    
    public ArrayList<Product> getList()
    {
        return this.listProd;
    }
    
    public void setList(ArrayList<Product> list)
    {
        this.listProd = list;
    }
}
