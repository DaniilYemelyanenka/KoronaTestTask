package by.yemelyanenka.jcommander.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class outputTypeValidation implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if(value.isBlank() && !value.strip().equals("console") | !value.strip().equals("file"))
            throw new ParameterException(name + " must be <file>  or <console> but was: " + value);
    }

}
