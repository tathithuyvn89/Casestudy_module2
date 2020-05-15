package repository;

import model.Category;
import model.ElectronicLeather;
import model.Mobile;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProductPrepositoryIlm implements ProductRepository {
    public List<Product> productList = new ArrayList<>();
    final static String FileLocal_typeMobile = "D:\\Codegym Module\\Casestudy_module2\\src\\repository\\Dienthoai_maytinh.csv";
    final static String FileLocal_typeDoDaDung = "D:\\Codegym Module\\Casestudy_module2\\src\\repository\\Do_da_dung.csv";
    final static String FileRepository = "D:\\Codegym Module\\Casestudy_module2\\src\\repository\\repository.txt";
    @Override
    public void readFromFileSource(String fileSource) {
        try {
            File file = new File(fileSource);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] products = line.split(",");
                String name = products[0];
                String CategoryID = "";
                if (fileSource.contains("Do_da_dung")) {
                    CategoryID = "DGD";
                } else {
                    CategoryID = "MOB";
                }
                String zero = "";
                if (i < 10) {
                    zero = "00" + i;
                } else if (i > 10 && i < 100) {
                    zero = "0" + i;

                } else {
                    zero = "" + i;
                }
                ++i;

                String id = CategoryID + zero;
                String branch = products[1];
                Double price = Double.parseDouble(products[2]);
                String idSeller = products[3];
                int total= (int) (Math.random()*10+1);
                if (fileSource.contains("Do_da_dung")) {
                    productList.add(new ElectronicLeather(id, name, price, total,branch, idSeller));
                } else {
                    productList.add(new Mobile(id, name, price,total, branch, idSeller));
                }

            }

            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(" File not exit");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveToFileData() {

            FileOutputStream os = null;
            ObjectOutputStream osOb = null;
            try {
                os = new FileOutputStream(FileRepository);
                osOb = new ObjectOutputStream(os);
                osOb.writeObject(productList);
                os.close();
                osOb.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void addToFileData() {
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
        if (id.contains("MOB")) {
            productList.add(new Mobile(id, name, price,total, branch, idBySeller));
        } else {
            productList.add(new ElectronicLeather(id, name, price,total, branch, idBySeller));
        }
        saveToFileData();

    }

    @Override
    public void editInFileData() {
        System.out.println("size" + productList.size());
        System.out.println("Enter product'ID which you want revise : ");
        Scanner scanner = new Scanner(System.in);
        String id= scanner.nextLine();

        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getID().equalsIgnoreCase(id)) {
                productList.get(i).display();
                index = i;
            }
        }
        if (index == -1) {
            System.out.println(" Product name is invalid");
        } else {
            int choose;

            do {
                System.out.println("Choose edit at ");
                System.out.println("1. Edit ID");
                System.out.println("2. Edit Name");
                System.out.println("3. Edit Price");
                System.out.println("4. Edit Total");
                System.out.println("5. Edit Branch");
                System.out.println("6. Edit IdBySeller");
                System.out.println("7.Complete Edit.");
                choose = scanner.nextInt();
                scanner.nextLine();
                switch (choose) {
                    case 1:
                        System.out.print("Enter new ID: ");
                        String newid = scanner.nextLine();
                        productList.get(index).setID(newid);
                        break;
                    case 2:
                        System.out.print("Enter new name");
                        String newname = scanner.nextLine();
                        productList.get(index).setName(newname);
                        break;
                    case 3:
                        System.out.print("Enter new Price: ");
                        double newprice = scanner.nextDouble();
                        scanner.nextLine();
                        productList.get(index).setPrice(newprice);
                        break;
                    case 4:
                        System.out.print("Enter new Total: ");
                        int newTotal = scanner.nextInt();
                        scanner.nextLine();
                        productList.get(index).setTotal(newTotal);
                        break;
                    case 5:
                        System.out.print("Enter new Branch: ");
                        String newBranch = scanner.nextLine();
                        productList.get(index).setBranch(newBranch);
                        break;
                    case 6:
                        System.out.print("Enter new IdSeller: ");
                        String newIdSeller = scanner.nextLine();
                        productList.get(index).setIdBySeller(newIdSeller);
                        break;
                    case 7 :
                        System.out.println("Ok, You want close editing");
                        break;
                    default:
                        System.out.println("Your choose is faled");
                        break;
                }
            } while (choose != 7);

        }
        saveToFileData();

    }

    @Override
    public void showData(  Category category) {
        File file= new File(FileRepository);
        if (!file.exists()){
            readFromFileSource(FileLocal_typeMobile);
            readFromFileSource(FileLocal_typeDoDaDung);
            saveToFileData();
        }
        FileInputStream is = null;
        ObjectInputStream isObj = null;
        try {
            is = new FileInputStream(FileRepository);
            isObj = new ObjectInputStream(is);
            productList = (List<Product>)isObj.readObject();
            is.close();
            isObj.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not exit");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        for (int i = 0; i < productList.size(); i++) {
            switch (category) {
                case ELECTRONICLEATHER:
                    if (productList.get(i).getID().contains("DGD")) {
                        productList.get(i).display();
                    }
                    break;
                case MOBILE:
                    if (productList.get(i).getID().contains("MOB")) {
                        productList.get(i).display();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void deleteInFileData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input product's Id, which you want delete");
        String deleteByID= scanner.nextLine();
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getID().equalsIgnoreCase(deleteByID)){
                productList.remove(i);
            }
        }
     saveToFileData();
    }
}
