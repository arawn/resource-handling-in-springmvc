Resource Handling in Spring MVC
================================

[Adied 2014, 봄싹 세미나](https://adieu2014.github.io)에서 발표한 `Resource Handling in Spring MVC`의 데모 코드입니다.
발표자료는 [slideshare](http://www.slideshare.net/arawnkr/resource-handling-in-spring-mvc)에 있습니다.

사용된 도구 및 플랫폼
----------------

- Java 1.8+
- Gradle 1.12
- Node.js v0.10+
- Grunt 0.4+, Bower 1.3+

데모 설명
-------

### spring40-resource-example

`ResourceHttpRequestHandler`를 통해 Spring MVC에서 정적 자원(CSS, JS, IMG) 요청을 처리하는 설정 방법을 보여줍니다.

```java
@Configuration
public class ResourceExampleWebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926);
    }

}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <mvc:resources mapping="/resources/**" location="/resources/" cache-period="31556926"/>

</beans>
```

### webjars-example

서블릿 3.0 기반에서 [WebJars](http://www.webjars.org)를 사용하는 예제 코드입니다.
별다른 부연 설명이 없기 떄문에 공식 사이트의 [문서](http://www.webjars.org/documentation)를 볼것을 권합니다.

### frontend

정적 자원(html, css, javascript)을 제공하는 Client-side 모듈입니다.
npm(node package manager), bower, grunt를 사용해서 CSS, JS를 최적화하고, 템블릿(HTML)을 생성합니다.
  
##### 빌드 방법

개발 모드 : 템플릿(html)만 생성하고, CSS-JS 는 작성중인 `src/assets`, `src/libs`을 사용합니다.
```
project-root/frontend> grunt build:develop 
```

배포 모드 : 템플릿(html) 생성 및 CSS, JS 등을 최적화(병합 및 압축)합니다.
```
project-root/frontend> grunt build:release
```

### backend

Spring IO Platform 사용해 개발된 Server-side 모듈입니다.
frontend 모듈을 Gradle로 통합해서 사용하고 있습니다.


##### 빌드 방법

```
> ./gradlew clean :backend:bootRun
```

위 명령을 통해 운영 환경으로 실행이 가능합니다.
운영 환경에서는 frontend 모듈 배포 빌드 후 jar로 묶어 사용합니다.

개발 환경은 IDE에서 `demo.DemoWebBootApplication` 클래스를 직접 실행하면 됩니다.
실행시 VM options에 다음 값을 줘야합니다.

```
-Dspring.profiles.active=dev -Ddemo.frontend.src.path=/resource-handling-in-springmvc/frontend/src
```

![demo.DemoWebBootApplication 실행](https://raw.githubusercontent.com/arawn/resource-handling-in-springmvc/master/documents/backend-run-dev_01.png)
![VM options](https://raw.githubusercontent.com/arawn/resource-handling-in-springmvc/master/documents/backend-run-dev_02.png)
