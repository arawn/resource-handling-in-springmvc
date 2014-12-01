package demo.module;

import demo.model.NormalScheduleItem;
import demo.model.ScheduleItem;
import demo.model.Session;
import demo.model.SessionScheduleItem;
import demo.model.repository.ScheduleItemRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arawn Park
 */
@Repository
public class InMemoryScheduleItemRepository implements ScheduleItemRepository {

    @Override
    public List<ScheduleItem> findAll() {
        List<ScheduleItem> schedule = new ArrayList<>();

        LocalTime time = LocalTime.of(10, 0);

        schedule.add(new NormalScheduleItem(time, time.plusMinutes(30), "등록 및 입장", ""));
        schedule.add(new NormalScheduleItem(time.plusMinutes(30), time.plusMinutes(50), "키노트", "김정우"));
        schedule.add(new SessionScheduleItem(time.plusMinutes(60), time.plusMinutes(110), new Session("자바 8 스트림 API", "A different way to process collections", "김제준")));
        schedule.add(new NormalScheduleItem(time.plusMinutes(110), time.plusMinutes(150), "점심 + 네트워킹 타임", ""));
        schedule.add(new SessionScheduleItem(time.plusMinutes(150), time.plusMinutes(200), new Session("스위프트 프로그래밍", "Swift로 앱 개발하기", "김다솜")));
        schedule.add(new SessionScheduleItem(time.plusMinutes(210), time.plusMinutes(260), new Session("도커 사용에 유용한 유틸리티와 팁", "Docker - the open-source application container engine ", "신명수")));
        schedule.add(new SessionScheduleItem(time.plusMinutes(270), time.plusMinutes(320), new Session("프론트엔드 개발프로세스, 어디까지 개선할 수 있나", "프론트엔드 개발 프로세스의 생산성을 높히는 방법을 설명합니다.", "변정훈")));
        schedule.add(new SessionScheduleItem(time.plusMinutes(330), time.plusMinutes(380), new Session("Resource Handling in Spring MVC", "Spring MVC에서 정적 자원(css, js, etc)을 다루는 방법을 살펴본다.", "박용권")));
        schedule.add(new SessionScheduleItem(time.plusMinutes(390), time.plusMinutes(440), new Session("Building REST API Server", "Github과 비슷한 API 서버를 만들어 보자", "백기선")));
        schedule.add(new NormalScheduleItem(time.plusMinutes(450), time.plusMinutes(480), "봄싹 회고 및 마무리", "김성윤"));

        return schedule;
    }

}
