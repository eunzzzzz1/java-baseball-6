package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int answer = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            // 1. 1~9 까지의 랜덤한 3개의 수 선정하기
            List<Integer> list = new ArrayList<>();

            while(list.size() < 3) {
                int rd = Randoms.pickNumberInRange(1, 9);
                if (!list.contains(rd)) list.add(rd);
            }

            int strike = 0;
            int ball = 0;

            try {

                // 2. 사용자의 입력 값 받기
                while(strike!=3) {

                    System.out.print("숫자를 입력해주세요 : ");
                    String[] user = Console.readLine().split("");
                    List<Integer> userList = new ArrayList<>();

                    for (String s : user) {
                        int num = Integer.parseInt(s);
                        if (user.length != 3 || num == 0 || userList.contains(num))
                            throw new IllegalArgumentException();
                        userList.add(Integer.parseInt(s));
                    }

                    // 3. 컴퓨터의 랜덤 수와 사용자의 입력 값 비교하기

                    strike = 0;
                    ball = 0;

                    for(int i=0;i<3;i++) {
                        if(list.get(i)==userList.get(i)) strike++;
                        else if (list.contains(userList.get(i))) ball++;
                    }

                    if(ball>0) System.out.print(ball+"볼 ");
                    if(strike>0) System.out.print(strike+"스트라이크");
                    if(ball==0 && strike==0) System.out.print("낫싱");
                    System.out.println();

                }

                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                answer = Integer.parseInt(Console.readLine());
                if(answer!=1 && answer!=2)
                    throw new IllegalArgumentException();

            } catch (NumberFormatException e) { // 입력값이 숫자가 아닌 건 여기서 잡고
                throw new IllegalArgumentException("문자 입력");
            }

        } while (answer==1);

    }

}
