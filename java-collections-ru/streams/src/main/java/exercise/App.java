package exercise;

import java.util.List;


// BEGIN
public class App {
    public static final List FREE_HOSTS  = List.of("gmail.com", "yandex.ru", "hotmail.com");

    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .map(email -> email.split("@")[1])
                .filter(host -> FREE_HOSTS.contains(host))
                .count();
    }
}
// END
