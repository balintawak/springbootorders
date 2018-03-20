package work.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter
{
    private static final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime convertString (String localDateTime)
    {
        return LocalDateTime.parse(localDateTime, dateTimeFormatter);
    }

    public static LocalDateTime getCurrentTime ()
    {
        return LocalDateTime.now();
    }
}
