package domain;

import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

class History {
    private List<HistoryLine> historyLines = new LinkedList<>();

    void addHistoryLine(Operation operation, Amount balance) {
        historyLines.add(0, new HistoryLine(operation, balance));
    }

    List<HistoryLine> historyLines() {
        return unmodifiableList(historyLines);
    }
}
