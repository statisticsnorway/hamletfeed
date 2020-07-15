package no.ssb.bfk.hamletfeed;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
@AllArgsConstructor
@Slf4j
public class FeedController {
    private final Storage storage;

    @GetMapping
    public ResponseEntity<?> getEntriesInRange(@RequestParam int from, @RequestParam int to) {
        log.info("Received request from " + from + " to " + to);

        try {
            return ResponseEntity.of(storage.get(from, to));
        } catch(IndexOutOfBoundsException | IllegalArgumentException e) {
            log.error("Invalid from/to. Returned 400 BAD_REQUEST.");
            return new ResponseEntity<>("Invalid from/to", HttpStatus.BAD_REQUEST);
        }
    }
}
