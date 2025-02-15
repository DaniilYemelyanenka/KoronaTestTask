package by.yemelyanenka.jcommander.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class SortOrdervalidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!(value.equals("ask") || value.equals("desc")))
            throw new ParameterException(  "Parameter: " + name + " should be (ask or desk)");

    }
}
