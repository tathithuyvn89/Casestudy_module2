package view.companymember;

import controller.ProductManager;
import model.Category;

import java.util.Scanner;

public class CompanyMemberUse {
    public  void showProgrameForCompany() {
        ProductManager productManager= new ProductManager();
        Scanner scanner= new Scanner(System.in);
        int choose;
        do {
            showMenu();
            choose= scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("What type of product you want show");
                    System.out.println("1. ELECTRONICLEATHER");
                    System.out.println("2. MOBILE");
                    System.out.println("3. ALL PRODUCT");
                    System.out.println("Choose : ");
                    int luachon= scanner.nextInt();
                    switch (luachon){
                        case 1:
                            productManager.showData(Category.ELECTRONICLEATHER);
                            break;
                        case 2:
                            productManager.showData(Category.MOBILE);
                            break;
                        case 3:
                            productManager.showData(Category.ELECTRONICLEATHER);
                            productManager.showData(Category.MOBILE);
                            break;
                        default:
                            System.out.println("You are wrong input");
                            break;
                    }
                    break;
                case 2:
                    productManager.addProduct();
                    break;
                case 3:
                    productManager.editProduct();
                    break;
                case 4:
                    productManager.deleteProductByID();
                    break;
                case 5:
                    System.out.println("Ban muon hien thi gia tang dan loai san pham nao");
                    System.out.println("1. Hang dien da dung");
                    System.out.println("2. Dien thoai va may tinh bang");
                    System.out.println("Lua chon cua ban la: ");
                    int luachon2= scanner.nextInt();
                    scanner.nextLine();
                    if (luachon2==1){
                        productManager.sortProductByPriceDown(Category.ELECTRONICLEATHER);
                    } else if (luachon2==2){
                        productManager.sortProductByPriceDown(Category.MOBILE);
                    } else {
                        System.out.println("Ban da nhap so khung dung");
                    }
                    break;
                case 6:
                    productManager.searchProductByName();
                    break;
                case 7:
                    System.out.println("Cam on ban da su dung chuong trinh cua chung toi");
                    break;
                default:
                    break;
            }
        } while (choose!=6);


    }
    protected static void showMenu(){
        System.out.println("===============================================================");
        System.out.println("1. Show Product ");
        System.out.println("2. Add Product ");
        System.out.println("3. Edit Product by ID ");
        System.out.println("4. Delete Product by ID ");
        System.out.println("5. Sort Product by Price ");
        System.out.println("6. SearchProduct by Name ");
        System.out.println("7. Exit program ");
        System.out.println("Please choose one number, you want ");
    }
}
