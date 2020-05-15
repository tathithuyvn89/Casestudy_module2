package repository;

import model.Category;

import java.util.List;

public interface GenaralRepository {
    void readFromFileSource(String fileSource);

    <T> void saveToFileData();

    void showData(Category category);

    void addToFileData();

    void editInFileData();

    void deleteInFileData();

}
