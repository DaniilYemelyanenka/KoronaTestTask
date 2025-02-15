package by.yemelyanenka.jcommander.arguments;

import by.yemelyanenka.jcommander.validators.InputFilePathValidator;
import com.beust.jcommander.Parameter;

public class InputFilePathArguments {

    @Parameter(names="--inputPath",description = "Path to file with data", help = true, validateWith = InputFilePathValidator.class)
    private String filePath;


    public String getFilePath() {
        return filePath;
    }
}
