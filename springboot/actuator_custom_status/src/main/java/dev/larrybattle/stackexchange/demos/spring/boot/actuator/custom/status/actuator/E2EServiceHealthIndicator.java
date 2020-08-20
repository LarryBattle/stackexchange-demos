package dev.larrybattle.stackexchange.demos.spring.boot.actuator.custom.status.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Documentation for Spring Boot Actuator
// url: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-health

// url: http://localhost:8081/actuator/health/e2EService
// {
//  "status": "TEST_FAILED",
//  "details": {
//    "test_start_time": "2020-08-20T05:24:02.608+00:00",
//    "isFakeTest": true,
//    "testName": "e2e mock test"
//  }
//}


// Example from url: http://localhost:8081/actuator/health/
// {
//  "status": "TEST_FAILED",
//  "components": {
//    "diskSpace": {
//      "status": "UP",
//      "details": {
//        "total": 0,
//        "free": 0,
//        "threshold": 0,
//        "exists": true
//      }
//    },
//    "e2EService": {
//      "status": "TEST_FAILED",
//      "details": {
//        "test_start_time": "2020-08-20T05:26:33.253+00:00",
//        "isFakeTest": true,
//        "testName": "e2e mock test"
//      }
//    },
//    "ping": {
//      "status": "UP"
//    }
//  }
//}

// $ curl -I -L http://localhost:8081/actuator/health/fooService
//  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
//                                 Dload  Upload   Total   Spent    Left  Speed
//  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0HTTP/1.1 412
//Content-Type: application/vnd.spring-boot.actuator.v3+json
//Transfer-Encoding: chunked
//Date: Thu, 20 Aug 2020 04:45:26 GMT

@Component
public class E2EServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Map<String, Object> props = new HashMap<>();
        props.put("testName", "e2e mock test");
        props.put("isFakeTest", true);
        props.put("test_start_time", new Date());

        return Health.status("TEST_FAILED")
                .withDetails(props)
                .build();
    }

}
