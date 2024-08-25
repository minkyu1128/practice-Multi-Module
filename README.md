# 멀티 모듈
레이어간 경계를 서브 모듈로 분리하고, 모듈간 의존을 설정하여 구조적으로 의존을 분리 합니다.


## 모듈 분리

---

### 루트(ROOT) 모듈 
**불필요한 패키지 & 파일 삭제**
* src 디렉토리 제거
* build.gradle 수정
* settings.gradle 수정

**build.gradle 수정**

아래와 같이 스크립트를 수정 합니다.

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.3.3'
    id 'io.spring.dependency-management' version '1.1.6'
}

bootJar.enabled = false // 빌드시 현재 모듈(multi-module)의 .jar를 생성하지 않습니다.

repositories {
    mavenCentral()
}

//"subprojects"에 정의된 설정은 모든 하위 모듈에 적용 됩니다.
subprojects { 
    group 'com.example'
    version '0.0.1-SNAPSHOT'
    sourceCompatibility = '17'

    apply plugin: 'java'
    apply plugin: 'java-library'
    apply plugin: 'org.springframework.boot'
    apply plugin: 'io.spring.dependency-management'

    configurations {
        compileOnly {
            extendsFrom annotationProcessor
        }
    }

    repositories {
        mavenCentral()
    }

    dependencies { // 모든 하위 모듈에 추가 될 의존성 목록입니다.
        implementation 'org.springframework.boot:spring-boot-starter'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }

    test {
        useJUnitPlatform()
    }
}
```

**모듈 생성**

모듈을 다음 구조로 생성 합니다.
* **moudle-infra**
  * ROOT모듈에 대한 Infrastructor를 정의 합니다
* **moudle-common**
  * 공통 utility를 제공 합니다.
* **module-api**
  * API 서버
  * End User로 부터 요청을 수신 한다
* **module-core**
  * Entity 를 정의 한다
  * 도메인에 대한 비즈니스를 처리
* **module-stream**
  * Stream 서버
  * Kafka를 사용해 API 요청에 대한 topic을 발송한다(Producer)
  * Stream에 발송된 topic을 받아서 처리 한다(Consumer)

모듈 생성을 완료 한 후 ROOT 모듈의 `settings.gradle`을 확인 합니다.
생성 한 모듈이 아래와 같이 작성 되어 있지 않다면 추가 해줍니다.
```groovy
rootProject.name = 'multi-module'
//생성한 모듈은 자동으로 아래와 같이 추가 됩니다
include 'module-infra'
include 'module-common'
include 'module-api'
include 'module-core'
include 'module-stream'
```

### 서브(Sub) 모듈
각 모듈이 boot.jar 를 생성하지 않도록 생성한 모든 모듈의 `build.gradle` 스크립트를 수정합니다.
```groovy
//plain jar만 생성하도록 설정
bootJar.enabled = false
jar.enabled = true

dependencies {
    ...
}
```


## Documents..

--- 
* [참고사이트](https://velog.io/@jthugg/spring-multi-module)