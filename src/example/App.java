package example;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);


        // 바깥쪽 while문을 탈출하기 위해 outer: 사용
        outer:
        while (true) {

            // 계산에 사용할 정수 입력 받기
            int num1 = getVaildNumber(sc, "첫 번째 정수를 입력해주세요. : ");
            int num2 = getVaildNumber(sc, "두 번째 정수를 입력해주세요. : ");

            // 계산에 사용할 사칙연산 기호 입력 받기
            char operator = getVaildOperator(sc, "사칙연산 기호를 입력해주세요.(+, -, *, /) : ");

            // 계산하고 결과값 받는 코드에 예외 처리
            try {
                int result = cal.calculate(num1, num2, operator);
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

            } catch (ArithmeticException e) {
                System.out.println("에러" + e.getMessage());
            }

            // 계산이 끝나고 난 후, while문으로 y를 입력하면 안쪽 while문만 탈출
            // n을 입력하면 바깥쪽 while문 탈출로 프로그램 종료
            while (true) {
                System.out.print("더 입력 하시겠습니까?(y/n) : ");
                String result = sc.next();

                if (result.equalsIgnoreCase("n")) {
                    break outer; // 바깥
                } else if (result.equalsIgnoreCase("y")) {
                    break;
                } else {
                    System.out.println("잘못된 경우입니다.");
                }
            }
        }
        // 스캐너 닫아주기
        sc.close();
        System.out.println("계산기를 종료 합니다");
        // 컬렉션에 저장한 history 불러오기
        System.out.println("연산기록 : " + cal.getHistory());

    }

    // 위에서 입력받은 정수가 유효한지 검사해주는 메서드
    public static int getVaildNumber(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("정수를 입력해주세요!");
                sc.next(); // 잘못된 입력 제거
            }
        }
    }


    // 위에서 입력받은 사칙연산 기호가 유효한지 검사해주는 메서드
    public static char getVaildOperator(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.next();
            if (input.length() == 1 && "+-*/".contains(input)) {
                return input.charAt(0);
            } else {
                System.out.println("올바른 연산자(+,-,*,/)를 입력해주세요!");
            }
        }
    }
}
