package session;

import java.util.Date;

public class TimeContainer {
    private Double startTime;
    private Double resultTime;
    private String date;

    public TimeContainer() {
        date = new Date().toString();
        startTime = 0.0;
        resultTime = 0.0;
    }

    public Double start() {
        startTime = (double) System.currentTimeMillis();
        return startTime;
    }
    public Double stop() {
        if (startTime != 0) {
            resultTime = (double) System.currentTimeMillis() - startTime;
            return resultTime;
        }else return 0.0;
    }

    public Double getTime() {
        return resultTime;
    }

    public String getData() {
        return date;
    }
}
