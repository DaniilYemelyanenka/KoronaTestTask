package by.yemelyanenka.jcommander.validators;

import com.beust.jcommander.*;


public class SortTypeValidator implements IParameterValidator {


    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!(value.equals("name") | value.equals("salary")))
            throw new ParameterException( "Parameter: " + name + " should be (name or salary)");
    }
}
