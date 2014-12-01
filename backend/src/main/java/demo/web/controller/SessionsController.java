package demo.web.controller;

import demo.model.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Arawn Park
 */
@Controller
public class SessionsController {

    private SessionRepository sessionRepository;

    @RequestMapping("/sessions")
    public void sessions(Model model) {
        model.addAttribute("sessions", sessionRepository.findAll());
    }


    @Autowired
    public void setSessionRepository(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

}
