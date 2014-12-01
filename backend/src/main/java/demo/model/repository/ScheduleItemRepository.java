package demo.model.repository;

import demo.model.ScheduleItem;

import java.util.List;

/**
 * @author Arawn Park
 */
public interface ScheduleItemRepository {

    List<ScheduleItem> findAll();

}
