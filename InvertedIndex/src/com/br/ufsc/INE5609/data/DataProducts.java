package com.br.ufsc.INE5609.data;

import com.br.ufsc.INE5609.indexation.DirInvertedIndex;
import com.br.ufsc.INE5609.model.Product;

import java.util.*;

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

    private void setProducts(Product[] products) {
        this.products = products;
    }

    private DirInvertedIndex getDirByBrand() {
        return dirByBrand;
    }

    private void setDirByBrand(DirInvertedIndex dirByBrand) {
        this.dirByBrand = dirByBrand;
    }

    private DirInvertedIndex getDirByType() {
        return dirByType;
    }

    private void setDirByType(DirInvertedIndex dirByType) {
        this.dirByType = dirByType;
    }

    private DirInvertedIndex getDirByFlavor() {
        return dirByFlavor;
    }

    private void setDirByFlavor(DirInvertedIndex dirByFlavor) {
        this.dirByFlavor = dirByFlavor;
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

    public void removeProduct(String deletedProduct) {
        int indexOfProduct = getIndexbyName(deletedProduct);


        dirByFlavor.remove(products[indexOfProduct].getFlavor(), indexOfProduct);
        dirByType.remove(products[indexOfProduct].getType(), indexOfProduct);
        dirByBrand.remove(products[indexOfProduct].getBrand(), indexOfProduct);
        products[indexOfProduct] = null;
    }

    private int getIndexbyName(String deletedProduct) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if (products[i].getName().equalsIgnoreCase(deletedProduct)) {
                    return i;
                }

            }

        }
        return index;
    }


    private List<Product> productsByBrandAndByType(String Brand, String Type) {
        List<Product> productsByBrandAndByType = new ArrayList<>();
        List<Product> productsByBrand = productsByBrand(Brand);
        List<Product> productsByType = productsByType(Type);

        for (Product i : productsByBrand) {
            for (Product j : productsByType) {
                if (!i.getType().equalsIgnoreCase(j.getType())) {
                    break;
                }
                /// estou na lista de marcas, verificando se na de tipos tem algum produto da marca (i) que eu quero
                if (i.getBrand().equalsIgnoreCase(j.getBrand())
                        && i.getName().equalsIgnoreCase(j.getName())) {
                    productsByBrandAndByType.add(j);
                    break;
                }
            }
        }

        return productsByBrandAndByType;
    }


    private List<Product> productsByFlavorAndByType(String Flavor, String Type) {
        List<Product> productsByFlavorAndByType = new ArrayList<>();
        List<Product> productsByFlavor = productsByFlavor(Flavor);
        List<Product> productsByType = productsByType(Type);

        for (Product i : productsByFlavor) {
            for (Product j : productsByType) {
                if (!i.getType().equalsIgnoreCase(j.getType())) {
                    break;
                }
                /// estou na lista de marcas, verificando se na de tipos tem algum produto da marca (i) que eu quero
                if (i.getFlavor().equalsIgnoreCase(j.getFlavor())
                        && i.getName().equalsIgnoreCase(j.getName())) {
                    productsByFlavorAndByType.add(j);
                    break;
                }
            }
        }

        return productsByFlavorAndByType;
    }

    private List<Product> productsByBrand(String brand) {
        List<Product> productsByBrand = new ArrayList<>();
        List<Integer> listByBrand = dirByBrand.getList(brand);

        for (int i : listByBrand)
            productsByBrand.add(products[i]);

        return productsByBrand;

    }

    private List<Product> productsByType(String type) {
        List<Product> productsByType = new ArrayList<>();
        List<Integer> listByType = dirByType.getList(type);

        for (int index : listByType) {
            productsByType.add(products[index]);
        }
        return productsByType;
    }

    private List<Product> productsByFlavor(String flavor) {
        List<Product> productsByFlavor = new ArrayList<>();
        List<Integer> listByFlavor = dirByFlavor.getList(flavor);

        for (int index : listByFlavor) {
            productsByFlavor.add(products[index]);
        }
        return productsByFlavor;
    }

    //Stringbuilders de retorno das buscas duplas

    public StringBuilder getProductsByFlavor(String flavor) {

        return (stringConstructor(productsByFlavor(flavor)));

    }

    public StringBuilder getProductsByType(String type) {

        return (stringConstructor(productsByType(type)));

    }

    public StringBuilder getProductsByBrand(String brand) {

        return (stringConstructor(productsByBrand(brand)));

    }

    public StringBuilder getListOfProducts() {
        StringBuilder ListOfProducts = new StringBuilder("{");

        for (Product p : products) {
            if (p != null) {
                ListOfProducts.append(p);
                ListOfProducts.append("\n");
            }
        }
        ListOfProducts.append("}");

        return ListOfProducts;

    }

    public StringBuilder getProductsByBrandAndByType(String brand, String type) {

        return stringConstructor(productsByBrandAndByType(brand, type));

    }

    public StringBuilder getProductsByFlavorAndByType(String flavor, String type) {

        return stringConstructor(productsByFlavorAndByType(flavor, type));

    }

    public StringBuilder getFlavors() {

        HashMap flavors = getDirByFlavor().getDir();

        StringBuilder returnValue = new StringBuilder("{\n");
        for (Object key : flavors.keySet()) {
            returnValue.append("- " + key);
            returnValue.append(" \n");
        }
        returnValue.append("}");

        return returnValue;

    }

    public StringBuilder getTypes() {

        HashMap types = getDirByType().getDir();

        StringBuilder returnValue = new StringBuilder("{\n");
        for (Object key : types.keySet()) {
            returnValue.append("- " + key);
            returnValue.append(" \n");
        }
        returnValue.append("}");

        return returnValue;

    }

    public StringBuilder getBrands() {

        HashMap brands = getDirByBrand().getDir();

        StringBuilder returnValue = new StringBuilder("{\n");
        for (Object key : brands.keySet()) {
            returnValue.append("- " + key);
            returnValue.append(" \n");
        }
        returnValue.append("}");

        return returnValue;

    }


    private StringBuilder stringConstructor(List<Product> listOfProducts) {
        StringBuilder returnValue = new StringBuilder("{\n");

        for (int i = 0; i < listOfProducts.size(); i++) {
            returnValue.append(listOfProducts.get(i));
            returnValue.append("\n");
        }
        returnValue.append("}");

        return returnValue;
    }


}

