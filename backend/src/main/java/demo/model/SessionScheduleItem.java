package demo.model;

import java.time.LocalTime;

/**
 * @author Arwan Park
 */
public class SessionScheduleItem extends ScheduleItem {

    private Session session;

    public SessionScheduleItem(LocalTime begin, LocalTime end, Session session) {
        super(begin, end);

        this.session = session;
    }

    @Override
    public String getName() {
        return session.getTitle();
    }

    @Override
    public String getParticipant() {
        return session.getSpeaker();
    }

}
