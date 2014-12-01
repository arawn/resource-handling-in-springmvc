package demo.web.controller;

import demo.model.repository.ScheduleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Arawn Park
 */
@Controller
public class ScheduleController {

    private ScheduleItemRepository scheduleItemRepository;

    @RequestMapping("/schedule")
    public void sessions(Model model) {
        model.addAttribute("schedule", scheduleItemRepository.findAll());
    }


    @Autowired
    public void setScheduleItemRepository(ScheduleItemRepository scheduleItemRepository) {
        this.scheduleItemRepository = scheduleItemRepository;
    }

}
