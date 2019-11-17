package com.br.ufsc.INE5609.data;

import com.br.ufsc.INE5609.indexation.DirInvertedIndex;
import com.br.ufsc.INE5609.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DataProducts {
    private Product[] products;
    private DirInvertedIndex dirByBrand;
    private DirInvertedIndex dirByType;
    private int index = 0;


    public DataProducts(Product[] products, DirInvertedIndex dirByBrand, DirInvertedIndex dirByType) {
        this.products = products;
        this.dirByBrand = dirByBrand;
        this.dirByType = dirByType;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public DirInvertedIndex getDirByBrand() {
        return dirByBrand;
    }

    public void setDirByBrand(DirInvertedIndex dirByBrand) {
        this.dirByBrand = dirByBrand;
    }

    public DirInvertedIndex getDirByType() {
        return dirByType;
    }

    public void setDirByType(DirInvertedIndex dirByType) {
        this.dirByType = dirByType;
    }

    private int getIndex() {
        return index;
    }

    private void incrementIndex() throws IndexOutOfBoundsException {
        if ((index++) > products.length)
            throw new IndexOutOfBoundsException();

        index++;
    }

    public void insertProduct(Product product) {
        products[getIndex()] = product;
        dirByBrand.insert(product.getBrand(), getIndex());
        dirByType.insert(product.getType(), getIndex());
        incrementIndex();
    }

    public List<Product> getProductsByBrand(String brand) {
        List<Product> productsByBrand = new ArrayList<>();
        List<Integer> listByBrand = dirByBrand.getList(brand);

        for (int i : listByBrand)
            productsByBrand.add(products[i]);

        return productsByBrand;

    }

    public List<Product> getProductsByType(String type) {
        List<Product> productsByType = new ArrayList<>();
        List<Integer> listByType = dirByType.getList(type);

        for (int index : listByType) {
            productsByType.add(products[index]);
        }
        return productsByType;
    }
}
