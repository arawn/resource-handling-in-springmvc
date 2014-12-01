package demo.model;

import java.time.LocalTime;

/**
 * @author Arwan Park
 */
public abstract class ScheduleItem {

    private LocalTime begin;
    private LocalTime end;

    public ScheduleItem(LocalTime begin, LocalTime end) {
        this.begin = begin;
        this.end = end;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public abstract String getName();

    public abstract String getParticipant();

}
