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

The `EnumString`, `Enum`, and `Number` annotations check allowed text, allowed numeric values,
and numeric length. Their validator classes are public so Hibernate Validator can create them.
`ValidationTest` checks valid, invalid, optional, and negative values.

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

##### 1. Valid input

**Request**

- Method: POST
- URL: http://localhost:8080/api/validate
- Content-Type: application/json

~~~json
{
  "state": "READY",
  "level": 1,
  "code": 42
}
~~~

**Response**

- Status: 200 OK

~~~json
{
  "state": "READY",
  "level": 1,
  "code": 42
}
~~~

##### 2. Invalid input

**Request**

- Method: POST
- URL: http://localhost:8080/api/validate
- Content-Type: application/json

~~~json
{
  "state": "OTHER",
  "level": 3,
  "code": 1234
}
~~~

**Response**

- Status: 400 Bad Request

~~~json
{
  "status": 400,
  "error": "Bad Request"
}
~~~

**Note:** The response also includes a timestamp and request path.

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

`EnumString`, `Enum`, `Number` 애너테이션으로 허용 문자열, 허용 숫자, 숫자 길이를 검사한다.
Hibernate Validator가 생성할 수 있도록 검증기 클래스를 public으로 분리했다.
`ValidationTest`는 정상·오류·선택값·음수 입력을 확인한다.

ValidationController는 JSON 입력에 세 가지 사용자 정의 검증 조건을 적용한다.

### 실행과 테스트

JDK 8, Maven 3.6.3 이상 사용. 저장소 루트에서 실행.

```sh
java -version
mvn clean verify
mvn spring-boot:run
```

단위 테스트는 Bean Validation API를 직접 호출한다. 앱은 localhost:8080에서도 요청을 받는다.

#### Postman API

##### 1. 정상 입력

**요청**

- 메서드: POST
- URL: http://localhost:8080/api/validate
- Content-Type: application/json

~~~json
{
  "state": "READY",
  "level": 1,
  "code": 42
}
~~~

**응답**

- 상태: 200 OK

~~~json
{
  "state": "READY",
  "level": 1,
  "code": 42
}
~~~

##### 2. 검증 실패

**요청**

- 메서드: POST
- URL: http://localhost:8080/api/validate
- Content-Type: application/json

~~~json
{
  "state": "OTHER",
  "level": 3,
  "code": 1234
}
~~~

**응답**

- 상태: 400 Bad Request

~~~json
{
  "status": 400,
  "error": "Bad Request"
}
~~~

**참고:** 실제 응답에는 timestamp와 path도 포함.
