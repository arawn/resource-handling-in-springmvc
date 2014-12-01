package demo.model.repository;

import demo.model.Session;

import java.util.List;

/**
 * @author Arawn Park
 */
public interface SessionRepository {

    List<Session> findAll();

}
