package exercise.daytime;
import jakarta.annotation.PostConstruct;

public class Day implements Daytime {
    private String name = "day";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void showUponCreation() {
        System.out.println("Bean \"day\" was created");
    }
    // END
}
