package by.yemelyanenka.jcommander.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class InputFilePathValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {

        if(value.isBlank() && value.strip().matches(".*[/\n\r\t\0\f`?*<>|\":].*") && !value.contains(".txt"))
                 throw new ParameterException(" Parameter: " + name + " should be a path to txt file!");

    }
}
