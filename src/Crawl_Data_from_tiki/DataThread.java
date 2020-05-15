package Crawl_Data_from_tiki;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataThread extends Thread {

    String url;
    String localFile;

    public DataThread(String url, String localFile) {
        this.url = url;
        this.localFile = localFile;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
//            content= content.replaceAll("\\t", "");
            Pattern patternName = Pattern.compile("data-title=\"(.*?)\" data-price=\"");
            Matcher matcher1 = patternName.matcher(content);
            Pattern patternPrice = Pattern.compile("\" data-price=\"(.*?)\" data-id");
            Matcher matcher2 = patternPrice.matcher(content);
            Pattern patternID = Pattern.compile("\" data-id=\"(.*?)\"data-score=");
            Matcher matcher3 = patternID.matcher(content);
            Pattern patternBrach = Pattern.compile("\" data-brand=\"(.*?)\" data-category=\"");
            Matcher matcher4 = patternBrach.matcher(content);

            //Tim kiem duoc thong tin va se thuc hien ghi luon vao file du lieu
            File file = new File(this.localFile);
            file.createNewFile();
            FileWriter os = new FileWriter(file);
            BufferedWriter bff = new BufferedWriter(os);
            while (matcher2.find() && matcher1.find() && matcher3.find() && matcher4.find()) {
                String line = (matcher1.group(1).trim()).replaceAll(",", "-") + "," + matcher4.group(1) + "," + matcher2.group(1).trim() + "," + matcher3.group(1).replaceAll("\"", "");
                System.out.println(line);
                bff.write(line);
                bff.newLine();

            }
//            os.close();

            bff.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
