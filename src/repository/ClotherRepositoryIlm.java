package repository;

import model.Category;
import model.Clother;
import model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClotherRepositoryIlm implements ClotherRepository  {
    public List<Product> productList= new ArrayList<Product>();
    public ProductPrepositoryIlm productPrepositoryIlm;
    final static String FileRepository = "D:\\Codegym Module\\Casestudy_module2\\src\\repository\\repository.txt";
    @Override
    public boolean addtoFileRepository() {
        File file1 = new File(FileRepository);
        long length1= file1.length();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter the Product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the Product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter the Product total: ");
        int  total = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Product branch: ");
        String branch = scanner.nextLine();
        System.out.print("Enter the Product idBySeller: ");
        String idBySeller = scanner.nextLine();
        System.out.print("Enter the Product Color: ");
        String color = scanner.nextLine();
        productList.add(new Clother(id,name,price,total,branch,idBySeller,color));
        productPrepositoryIlm.saveToFileData();
        File file2= new File(FileRepository);
        long length2= file2.length();
        if(length1<length2){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean editInFileRepository() {
        return false;
    }

    @Override
    public boolean deleteInFileRepository() {
        return false;
    }
}
