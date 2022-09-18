import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularProcessing {
    public boolean isIpAddress(String input){
        String filter = "((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}";
        Pattern pattern = Pattern.compile(filter);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }


    public boolean isGuid(String input) {
        String filter = "([0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})|" +
                        "(\\(([0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})\\))|" +
                        "(\\{([0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})}|" +
                        "(\\[[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})])";
        Pattern pattern = Pattern.compile(filter);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
