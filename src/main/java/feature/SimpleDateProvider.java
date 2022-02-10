package feature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SimpleDateProvider implements DateProvider {
    @Override
    public String Today() {
        var dateTime = LocalDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(dateTime);
    }
}
