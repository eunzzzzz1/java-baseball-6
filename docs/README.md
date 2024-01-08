## 구현 기능 목록

### 프로그래밍 요구 사항
1. JDK 17 확인할 것
2. 프로그램 실행의 시작점은 `main()`
3. 프로그램 종료 시 `System.exit()` 호출하지 말 것
4. `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용
   ```java
     List<Integer> computer = new ArrayList<>();
     while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
     }


### 기능 요구사항
0. 시작문구 : `"숫자 야구 게임을 시작합니다."`
1. **1~9 까지의 _서로 다른_ 랜덤한 세 자리수 생성**
   - `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현
   - 랜덤 값 추출 : `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
   - 사용자 입력 값 : `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용


2. **사용자의 입력 값 받기**
    - `"숫자를 입력해주세요 : "`
    - 숫자가 아닌 잘못된 값을 입력했을 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료


3. **컴퓨터의 랜덤 수와 사용자의 입력값 비교**
   - 같은 숫자 같은 자리에 있을 경우 : `n스트라이크`
   - 같은 숫자만 있을 경우 : `n볼`
   - 아무 것도 없는 경우 : `낫싱`


4. **반복**
   - 언제까지? : `3스트라이크`가 나올 때 까지
   - 3스트라이크가 발생하면
     - `"3개의 숫자를 모두 맞히셨습니다! 게임 종료"`
     - `"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."`
     - 재시작 1, 종료 2
     - 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
