package no.ssb.bfk.hamletfeed;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class Storage {
    private static final List<FeedEntry> feedEntries = new ArrayList<>();

    public void add(String content) {
        feedEntries.add(new FeedEntry(feedEntries.size(), content));
        log.info("Added feed entry to storage. Current size: " + feedEntries.size());
    }

    public Optional<List<FeedEntry>> get(int from, int to) {
        if(to > feedEntries.size()) { to = feedEntries.size(); }
        if(from > feedEntries.size()) { from = feedEntries.size(); }
        return Optional.of(feedEntries.subList(from, to));
    }
}
