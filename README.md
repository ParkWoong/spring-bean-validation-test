# Bean Validation annotations / Bean Validation 애너테이션

[ENG](#eng) | [KR](#kr)

## ENG

### Project structure

```text
pom.xml
src/main/java/io/github/parkwoong/example/Application.java
src/main/java/io/github/parkwoong/example/ValidationController.java
src/main/java/io/github/parkwoong/example/util/validation/Enum.java
src/main/java/io/github/parkwoong/example/util/validation/EnumString.java
src/main/java/io/github/parkwoong/example/util/validation/EnumStringValidator.java
src/main/java/io/github/parkwoong/example/util/validation/EnumValidator.java
src/main/java/io/github/parkwoong/example/util/validation/Number.java
src/main/java/io/github/parkwoong/example/util/validation/NumberValidator.java
src/main/java/io/github/parkwoong/example/util/validation/common/AbstractLongValidator.java
src/main/java/io/github/parkwoong/example/util/validation/common/AbstractValidator.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/example/ValidationTest.java
```

### Code explanation

The `EnumString`, `Enum`, and `Number` annotations check allowed text, allowed numeric values, and numeric length. Their validator classes are public so Hibernate Validator can create them. `ValidationTest` checks valid, invalid, optional, and negative values.

ValidationController applies the three custom constraints to JSON input.

### Run and test

Use JDK 8 and Maven 3.6.3+. Run from the repository root:

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

The unit test calls the Bean Validation API directly. The app also listens on localhost:8080.

#### Postman API

Send POST http://localhost:8080/api/validate with Content-Type: application/json and body {"state":"READY","level":1,"code":42}. Expected: HTTP 200 with the same JSON. Send {"state":"OTHER","level":3,"code":1234} to see HTTP 400 because the custom constraints reject those values.

## KR

### 프로젝트 구조

```text
pom.xml
src/main/java/io/github/parkwoong/example/Application.java
src/main/java/io/github/parkwoong/example/ValidationController.java
src/main/java/io/github/parkwoong/example/util/validation/Enum.java
src/main/java/io/github/parkwoong/example/util/validation/EnumString.java
src/main/java/io/github/parkwoong/example/util/validation/EnumStringValidator.java
src/main/java/io/github/parkwoong/example/util/validation/EnumValidator.java
src/main/java/io/github/parkwoong/example/util/validation/Number.java
src/main/java/io/github/parkwoong/example/util/validation/NumberValidator.java
src/main/java/io/github/parkwoong/example/util/validation/common/AbstractLongValidator.java
src/main/java/io/github/parkwoong/example/util/validation/common/AbstractValidator.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/example/ValidationTest.java
```

### 코드 설명

`EnumString`, `Enum`, `Number` 애너테이션으로 허용 문자열, 허용 숫자, 숫자 길이를 검사합니다. Hibernate Validator가 생성할 수 있도록 검증기 클래스를 public으로 분리했습니다. `ValidationTest`는 정상·오류·선택값·음수 입력을 확인합니다.

ValidationController는 JSON 입력에 세 가지 사용자 정의 검증 조건을 적용합니다.

### 실행과 테스트

JDK 8과 Maven 3.6.3 이상을 사용합니다. 저장소 루트에서 실행하세요:

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

단위 테스트는 Bean Validation API를 직접 호출합니다. 앱은 localhost:8080에서도 요청을 받습니다.

#### Postman API

Content-Type: application/json으로 POST http://localhost:8080/api/validate에 {"state":"READY","level":1,"code":42}를 보내세요. 예상 결과: HTTP 200과 동일한 JSON입니다. {"state":"OTHER","level":3,"code":1234}를 보내면 사용자 정의 검증 조건에 걸려 HTTP 400을 반환합니다.
