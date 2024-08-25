package cokr.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    // 의존성 확인을 위한 코드 - 시작
    private final DependencyTestBean dependencyTestBean;

    @Autowired
    public ApiApplication(DependencyTestBean dependencyTestBean) {
        this.dependencyTestBean = dependencyTestBean;
    }

    @PostConstruct
    public void dependencyTest() {
        dependencyTestBean.dependencyTest();
    }
    // 의존성 확인을 위한 코드 - 끝
}