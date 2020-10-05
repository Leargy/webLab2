package session;

import java.io.Serializable;

public class Entry implements Serializable {
    private Double x;
    private Double y;
    private Double r;
    private boolean isHit = false;
    private TimeContainer timeContainer;

    public Entry() {

    }
    public Entry(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getR() {
        return r;
    }

    public boolean getIsHit() {
        return isHit;
    }
    public void setHit(boolean hit) {
        isHit = hit;
    }


    public void setTimeContainer(TimeContainer timeContainer) {
        this.timeContainer = timeContainer;
    }

    public TimeContainer getTimeContainer() {
        if (timeContainer == null) return new TimeContainer();
        return timeContainer;
    }
}
