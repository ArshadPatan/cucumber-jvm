package cucumber.examples.java.calculator;

import cucumber.api.Configuration;
import cucumber.api.TypeRegistry;
import io.cucumber.datatable.DataTableType;
import cucumber.examples.java.calculator.RpnCalculatorStepdefs.Entry;
import cucumber.examples.java.calculator.ShoppingStepdefs.Grocery;

import java.util.Map;

import static java.util.Locale.ENGLISH;

public class ParameterTypes implements Configuration {

    @Override
    public TypeRegistry createTypeRegistry() {
        TypeRegistry typeRegistry = new TypeRegistry(ENGLISH);

        typeRegistry.defineDataTableType(new DataTableType(
            Entry.class,
            (Map<String, String> row) -> new Entry(
                Integer.valueOf(row.get("first")),
                Integer.valueOf(row.get("second")),
                row.get("operation")
            )
        ));

        typeRegistry.defineDataTableType(new DataTableType(
            Grocery.class,
            (Map<String, String> row) -> new Grocery(
                row.get("name"),
                ShoppingStepdefs.Price.fromString(row.get("price"))
            )
        ));

        return typeRegistry;
    }
}
