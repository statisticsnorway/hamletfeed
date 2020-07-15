package no.ssb.bfk.hamletfeed;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@AllArgsConstructor
public class FileLoader {
    private final Storage storage;

    private static final String FILENAME = "hamlet.txt";

    public void execute() throws URISyntaxException, IOException {
        Files.lines(Paths.get(getClass().getClassLoader().getResource(FILENAME).toURI()))
                .forEach(line -> storage.add(line.trim()));
    }
}
