package controller;

import model.Category;
import model.Product;
import repository.ProductPrepositoryIlm;

import java.util.*;

public class ProductManager implements ProductAct {

    private List<Product> productList = new ArrayList<Product>();
    private ProductPrepositoryIlm repository = new ProductPrepositoryIlm();

    @Override
    public void showData(Category category) {
        repository.showData(category);

    }

    @Override
    public void addProduct() {
    repository.addToFileData();
    }

    @Override
    public void editProduct() {
     repository.editInFileData();
    }

    @Override
    public void sortProductByPriceDown(Category category) {
        sortProduct();
        switch (category){
            case MOBILE:
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getID().contains("MOB")) {
                    productList.get(i).display();
                }
            }
            break;
            case ELECTRONICLEATHER:
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getID().contains("DGD")) {
                    productList.get(i).display();
                }
            }
            break;
            default:
                break;
        }
    }

    private void sortProduct() {
        productList = repository.productList;
        Comparator comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(productList, comparator);
    }

    @Override
    public void deleteProductByID() {
        repository.deleteInFileData();
    }

    @Override
    public void searchProductByName() {
        productList=repository.productList;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter product's Name, you want search");
        String nameSearch= scanner.nextLine();
        int sum=0; // kiem tra xem co bao nhieu gia tri duoc tim thay
        System.out.println(productList.size()+"sise la ");
        for (int i=0; i<productList.size();i++){
            if (productList.get(i).getName().contains(nameSearch)){
                productList.get(i).display();
                sum++;
            }
        }
        if (sum==0){
            System.out.println("Not exit product's name!");
        }
    }

    @Override
    public void checkProductIsEmpty() {
        System.out.println("The Product have total = 0. Please add them ");
        productList=repository.productList;
        for (int i=0; i<productList.size();i++){
            if(productList.get(i).getTotal()==0){
                productList.get(i).display();
            }
        }
    }
}
