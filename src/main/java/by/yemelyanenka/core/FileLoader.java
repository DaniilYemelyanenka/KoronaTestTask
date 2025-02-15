package by.yemelyanenka.core;

import by.yemelyanenka.core.entity.Employee;
import by.yemelyanenka.core.entity.Manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class FileLoader {
    private String path;
    private String fileContent;

    public FileLoader(){
        this.path = "File.txt";
    }



    public String readDataFromFileByPath(String path,String sortType,String sortOrder) throws IOException{
        this.path = path;
        fileContent  = Files.readString(Paths.get(this.path));
        return new WorkersMapper().getWorkersListFromFile(fileContent,sortType,sortOrder);
    }


    public String getFileContent() {
        return fileContent;
    }
}
