package no.ssb.bfk.hamletfeed;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class HamletFeedApplication implements CommandLineRunner {
    private final FileLoader fileLoader;

    public static void main(String[] args) {
        SpringApplication.run(HamletFeedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fileLoader.execute();
    }
}
