package no.ssb.bfk.hamletfeed;

import lombok.Data;

@Data
public class FeedEntry {
    private final int sequenceNumber;
    private final String content;
}
