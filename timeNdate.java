import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class timeNdate {

    public static void main(String[] args) {

        // CHANGE THIS VALUE
        boolean use24Hour = true; // true = 24-hour, false = 12-hour (AM/PM)

        ZoneId indiaZone = ZoneId.of("Asia/Kolkata");

        DateTimeFormatter formatter24 = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");

        DateTimeFormatter formatter12 = DateTimeFormatter.ofPattern("dd-MM-yyyy  hh:mm:ss a");

        boolean showColon = true; // for blinking effect

        while (true) {

            ZonedDateTime now = ZonedDateTime.now(indiaZone);

            String time = use24Hour
                    ? now.format(formatter24)
                    : now.format(formatter12);

            // Blinking colon logic
            if (!showColon) {
                time = time.replace(":", " ");
            }

            System.out.print("\r       Date & Time : " + time);

            showColon = !showColon; // toggle colon

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}