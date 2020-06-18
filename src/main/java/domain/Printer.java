package domain;

import java.util.List;

class Printer {
    static final String HEADER = "operation | date | amount | balance";

    String print(List<HistoryLine> historyLines) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        for (HistoryLine line : historyLines) {
            stringBuilder.append("\n");
            stringBuilder.append(line.printLine());
        }
        return stringBuilder.toString();
    }
}
