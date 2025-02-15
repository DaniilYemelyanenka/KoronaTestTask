package by.yemelyanenka.core;

import by.yemelyanenka.core.entity.Employee;
import by.yemelyanenka.core.entity.Manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Output {

    private String path;

    public Output(){
        this.path = "File.txt";
    }

    public void consoleOutput(String result){

        System.out.println(result);
    }

    public void fileOutput(String filepath, String result){
        this.path = filepath;
        try {
            Files.writeString(Paths.get(filepath), result);
        }catch(IOException ioException){
            System.out.println("Exception on writing to file: " + ioException.getMessage());
        }
    }

}
