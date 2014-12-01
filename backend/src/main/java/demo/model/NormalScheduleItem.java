package demo.model;

import java.time.LocalTime;

/**
 * @author Arwan Park
 */
public class NormalScheduleItem extends ScheduleItem {

    private String name;
    private String participant;

    public NormalScheduleItem(LocalTime begin, LocalTime end, String name, String participant) {
        super(begin, end);

        this.name = name;
        this.participant = participant;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getParticipant() {
        return participant;
    }

}
