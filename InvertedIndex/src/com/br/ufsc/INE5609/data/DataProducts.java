package com.br.ufsc.INE5609.data;

import com.br.ufsc.INE5609.indexation.DirInvertedIndex;
import com.br.ufsc.INE5609.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DataProducts {
    private Product[] products;
    //Criação dos 3 diretórios solicitados
    private DirInvertedIndex dirByBrand;
    private DirInvertedIndex dirByType;
    private DirInvertedIndex dirByFlavor;

    private int index = 0;


    public DataProducts(Product[] products, DirInvertedIndex dirByBrand, DirInvertedIndex dirByType, DirInvertedIndex dirByFlavor) {
        this.products = products;
        this.dirByBrand = dirByBrand;
        this.dirByType = dirByType;
        this.dirByFlavor = dirByFlavor;


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
        if ((index + 1) > products.length)
            throw new IndexOutOfBoundsException();

        index++;
    }

    public void insertProduct(Product product) {
        products[getIndex()] = product;
        dirByBrand.insert(product.getBrand(), getIndex());
        dirByType.insert(product.getType(), getIndex());
        dirByFlavor.insert(product.getFlavor(), getIndex());
        incrementIndex();
    }

    public List<Product> getProductsByBrand(String brand) {
        List<Product> productsByBrand = new ArrayList<>();

        List<Integer> listByBrand = dirByBrand.getList(brand);

        for (int i : listByBrand)
            productsByBrand.add(products[i]);

        return productsByBrand;

    }

    public List<Product> getProductsByBrandandByType(String Brand, String Type) {
        return Null;
    }

    public List<Product> getProductsByType(String type) {
        List<Product> productsByType = new ArrayList<>();
        List<Integer> listByType = dirByType.getList(type);

        for (int index : listByType) {
            productsByType.add(products[index]);
        }
        return productsByType;
    }

    public List<Product> getProductsByFlavor(String flavor) {
        List<Product> productsByFlavor = new ArrayList<>();
        List<Integer> listByFlavor = dirByFlavor.getList(flavor);

        for (int index : listByFlavor) {
            productsByFlavor.add(products[index]);
        }
        return productsByFlavor;
    }
}
