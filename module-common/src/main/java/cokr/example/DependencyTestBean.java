package cokr.example;

import org.springframework.stereotype.Component;

@Component
public class DependencyTestBean {
    public void dependencyTest() {
        System.out.println("성공적으로 로딩 됐습니다");
    }
}
