package example;


import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 타입 필드 (캡슐화 적용)
    private List<String> history;

    // 생성자: history 리스트 초기화
    public Calculator() {
        this.history = new ArrayList<>();
    }

    int calculate(int num1, int num2, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다!");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 연산 기호를 입력해주세요!");
                // throw new ...올바른 기호 입력하라고 만들기
        }

        // ⭐ 연산 과정과 결과를 문자열로 저장
        String operation = num1 + " " + operator + " " + num2 + " = " + result;
        history.add(operation); // 이제 history에는 문자열이 들어감
        return result;


    }
    // 연산 기호 리스트에 저장 메소드 (ex. addToHistory())

    public List<String> getHistory() {
        return history;
    }

    // 연산 기록 반환 (getter 메서드)



}
