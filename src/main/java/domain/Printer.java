package domain;

import java.util.List;
import java.util.stream.Collectors;

class Printer {
    static final String HEADER = "operation | date | amount | balance";

    String print(List<HistoryLine> historyLines) {
        return historyLines.stream()
                .map(line -> "\n" + line.toString())
                .collect(Collectors.joining("", HEADER, ""));
    }
}
