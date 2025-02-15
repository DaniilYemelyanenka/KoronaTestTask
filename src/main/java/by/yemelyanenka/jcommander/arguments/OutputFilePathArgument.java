package by.yemelyanenka.jcommander.arguments;



import by.yemelyanenka.jcommander.validators.InputFilePathValidator;


import com.beust.jcommander.Parameter;




public class OutputFilePathArgument {

    @Parameter(names = "--path" ,description = "output file path declaration", help = true,
            validateWith = InputFilePathValidator.class)

    private String outputPath;


    public String getOutputPath() {
        return outputPath;
    }
}
