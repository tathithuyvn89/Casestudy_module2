package repository;

import model.Clother;
import model.Product;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClotherRepositoryIlmTest {
    final static String FileRepository = "D:\\Codegym Module\\Casestudy_module2\\src\\repository\\repository.txt";
    ClotherRepository clotherRepository;
    ProductPrepositoryIlm productPrepositoryIlm;
    List<Product> productList= new ArrayList<Product>();
    @Test
    void addtoFileRepository() {
        File file1= new File(FileRepository);
        long length1=file1.length();
       String id="CLO009";
       String name ="Ao phong co co";
       Double price= 180000.0;
       int total= 8;
       String branch="Uniqlo";
       String idBySeller = "989003";
       String color= "Do";
       productList.add(new Clother(id,name,price,total,branch,idBySeller,color));
        File file2= new File(FileRepository);
        long length2=file1.length();
        boolean expected= true;
        boolean result= clotherRepository.addtoFileRepository();
        assertEquals(expected,result);
    }

    @Test
    void editInFileRepository() {
    }

    @Test
    void deleteInFileRepository() {
    }
}