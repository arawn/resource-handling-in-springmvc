package demo.module;

import demo.model.Session;
import demo.model.repository.SessionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arawn Park
 */
@Repository
public class InMemorySessionRepository  implements SessionRepository {

    @Override
    public List<Session> findAll() {
        List<Session> sessions = new ArrayList<>();

        sessions.add(new Session("자바 8 스트림 API", "A different way to process collections", "김제준"));
        sessions.add(new Session("스위프트 프로그래밍", "Swift로 앱 개발하기", "김다솜"));
        sessions.add(new Session("도커 사용에 유용한 유틸리티와 팁", "Docker - the open-source application container engine ", "신명수"));
        sessions.add(new Session("프론트엔드 개발프로세스, 어디까지 개선할 수 있나", "프론트엔드 개발 프로세스의 생산성을 높히는 방법을 설명합니다.", "변정훈"));
        sessions.add(new Session("Resource Handling in Spring MVC", "Spring MVC에서 정적 자원(css, js, etc)을 다루는 방법을 살펴본다.", "박용권"));
        sessions.add(new Session("Building REST API Server", "Github과 비슷한 API 서버를 만들어 보자", "백기선"));

        return sessions;
    }

}
