package ru.otus.springproject.dao;

public class FilePathDao {
    private final String filePath;

    public FilePathDao(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath(){
        return this.filePath;
    }
}
