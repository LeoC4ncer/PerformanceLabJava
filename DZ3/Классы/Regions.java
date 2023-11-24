import java.util.ArrayList;
import java.util.Arrays;

public enum Regions {
    UD("Удмурсткая республика",
            new ArrayList<String>(Arrays.asList("18", "118"))),
    MOW("Москва",
            new ArrayList<String>(Arrays.asList("77", "97", "99","117","197",
                    "199", "777", "797", "799", "977", "277", "297", "299" ))),
    BA("Республика Башкортостан",
            new ArrayList<String>(Arrays.asList("02","102","702")))
    ;
    private String name;
    private ArrayList<String> codes;

    Regions(String name, ArrayList<String> codes) {
        this.name = name;
        this.codes = codes;
    }

    public ArrayList<String> getCodes()
    {
        return codes;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        String nameAndCode;
            nameAndCode = name + ": ";
            for (String regionCode : getCodes()) {
                nameAndCode += regionCode + ", ";
            }
        return nameAndCode.substring( 0 ,nameAndCode.length() - 2);
    }
}
