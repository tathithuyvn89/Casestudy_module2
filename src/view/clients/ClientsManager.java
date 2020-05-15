package view.clients;

import controller.ProductManager;
import model.Category;

import java.util.Scanner;

public class ClientsManager {
    public void showPrograme() {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            ClientsManager.showMenu();
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("What type of product you want show");
                    System.out.println("1. ELECTRONICLEATHER");
                    System.out.println("2. MOBILE");
                    System.out.println("3. ALL PRODUCT");
                    System.out.println("Choose : ");
                    int luachon = scanner.nextInt();
                    switch (luachon) {
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
                    System.out.println("Ban muon hien thi gia tang dan loai san pham nao");
                    System.out.println("1. Hang dien da dung");
                    System.out.println("2. Dien thoai va may tinh bang");
                    System.out.println("Lua chon cua ban la: ");
                    int luachon2 = scanner.nextInt();
                    scanner.nextLine();
                    if (luachon2 == 1) {
                        productManager.sortProductByPriceDown(Category.ELECTRONICLEATHER);
                    } else if (luachon2 == 2) {
                        productManager.sortProductByPriceDown(Category.MOBILE);
                    } else {
                        System.out.println("Ban da nhap so khung dung");
                    }
                    break;
                case 3:
                    productManager.searchProductByName();
                    break;
                case 4:
                    System.out.println("Cam on ban da su dung chuong trinh cua chung toi");
                    break;
            }

            }while (choose!=4);
        }
        protected static void showMenu () {
            System.out.println("===============================================================");
            System.out.println("1. Show Product ");
            System.out.println("2. Sort Product by Price ");
            System.out.println("3. SearchProduct by Name ");
            System.out.println("4. Exit program ");
            System.out.println("Please choose one number, you want ");
        }
    }
