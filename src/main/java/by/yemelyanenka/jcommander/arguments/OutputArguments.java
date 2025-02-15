package by.yemelyanenka.jcommander.arguments;


import by.yemelyanenka.jcommander.validators.outputTypeValidation;
import com.beust.jcommander.Parameter;


public class OutputArguments {

    @Parameter(names={"--output", "-o"},description = "output type declaration", help = true,
                                                        validateWith = outputTypeValidation.class)

    private String outputType;


    public String getOutputType() {
        return outputType;
    }
}
