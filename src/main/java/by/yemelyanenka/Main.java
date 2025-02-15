package by.yemelyanenka;

import by.yemelyanenka.core.FileLoader;
import by.yemelyanenka.core.Output;
import by.yemelyanenka.jcommander.arguments.*;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        InputFilePathArguments pathArguments = new InputFilePathArguments();
        SortTypeArguments sortArguments = new SortTypeArguments();
        SortOrderArguments sortOrderArguments = new SortOrderArguments();
        OutputArguments outputArguments = new OutputArguments();
        OutputFilePathArgument outputFilePathArgument = new OutputFilePathArgument();
        Output output = new Output();


        FileLoader fileLoader = new FileLoader();

        JCommander jCommander = JCommander.newBuilder()
                .addObject(pathArguments)
                .addObject(sortArguments)
                .addObject(sortOrderArguments)
                .addObject(outputArguments)
                .addObject(outputFilePathArgument)
                .build();

        try {
            jCommander.parse(args);

            if(outputArguments.getOutputType().equals("file") && outputFilePathArgument.getOutputPath() == null)
                throw new IOException("--output flag must have --path flag");

            fileLoader.readDataFromFileByPath(pathArguments.getFilePath(),sortArguments.getSortTypeParameter(),sortOrderArguments.getOrderParameter());

            if (outputArguments.getOutputType().equals("console"))
                output.consoleOutput(fileLoader
                        .readDataFromFileByPath(pathArguments.getFilePath(),
                                sortArguments.getSortTypeParameter(),
                                sortOrderArguments.getOrderParameter()));
            else
                output.fileOutput(outputFilePathArgument.getOutputPath(),
                        fileLoader
                                .readDataFromFileByPath(pathArguments.getFilePath(),
                                        sortArguments.getSortTypeParameter(),
                                        sortOrderArguments.getOrderParameter())
                        );

        } catch(ParameterException parameterException) {
            System.out.println("check your entrance: " + parameterException.getMessage());
            jCommander.usage();
        } catch(FileNotFoundException fileNotFoundException){
        System.out.println("Can not found file by this file path: " + fileNotFoundException.getMessage());
        } catch(IOException ioException){
            System.out.println("Incorrect input for file path: " + ioException );
        } catch(NullPointerException nullPointerException){
            System.out.println("Null Pointer Exception: " + nullPointerException.getMessage()
                    + "  at " + nullPointerException.getLocalizedMessage());
        }catch (NumberFormatException numberFormatException){
            numberFormatException.printStackTrace();
        }






    }
}