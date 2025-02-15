package by.yemelyanenka.jcommander.arguments;

import by.yemelyanenka.jcommander.validators.SortOrdervalidator;
import com.beust.jcommander.Parameter;

public class SortOrderArguments {

    @Parameter(names = {"--order"}, description = "Order of sorting", help = true, validateWith = SortOrdervalidator.class)
    private String orderParameter;

    public String getOrderParameter() {
        return orderParameter;
    }
}
