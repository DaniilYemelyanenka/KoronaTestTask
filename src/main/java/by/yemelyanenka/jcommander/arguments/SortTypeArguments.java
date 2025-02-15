package by.yemelyanenka.jcommander.arguments;

import by.yemelyanenka.jcommander.validators.SortTypeValidator;
import com.beust.jcommander.Parameter;

public class SortTypeArguments {

    @Parameter(names = {"--sort", "-s"}, validateWith = SortTypeValidator.class, description = "Type of sorting", help = true )
    private String sortTypeParameter;

    public String getSortTypeParameter() {
        return sortTypeParameter;
    }


}
