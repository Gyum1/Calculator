package example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            double result = 0;
            System.out.println("-------------------------");
            System.out.print("1.계산기 실행\n2.종료\n:");
            int select = sc.nextInt();
            if(select == 2) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("사칙연산 기호를 입력하세요. : ");
            char sign = sc.next().charAt(0);


            System.out.print("첫 번째 숫자를 입력해주세요.(양의 정수만 입력) : ");
            double num1 = sc.nextInt();
            if(num1 < 0) {
                System.out.println("양의 정수만 입력 가능합니다.");
                System.out.print("첫 번째 숫자를 입력해주세요.(양의 정수만 입력) : ");
                num1 = sc.nextInt();
            }

            System.out.print("두 번째 숫자를 입력해주세요.(양의 정수만 입력) : ");
            double num2 = sc.nextInt();
            if(num2 < 0){
                System.out.println("양의 정수만 입력 가능합니다.");
                System.out.print("두 번째 숫자를 입력해주세요.(양의 정수만 입력) : ");
                num2 = sc.nextInt();
            } else if(sign == '/') {
                if(num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    System.out.print("두 번째 숫자를 입력해주세요.(양의 정수만 입력) : ");
                    num2 = sc.nextInt();
                }
            }




            switch(sign) {

                case '+':
                    result = num1 + num2;
                    System.out.println((int)num1 + " + " + (int)num2 + " = " + (int)result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println((int)num1 + " - " + (int)num2 + " = " + (int)result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println((int)num1 + " * " + (int)num2 + " = " + (int)result);
                    break;
                case '/':
                    result = num1 / num2;
                    System.out.println((int)num1 + " / " + (int)num2 + " = " + result);
                    break;
                default:
                    System.out.println("+, -, *, / 외에는 입력이 불가능합니다.");
            }




        }
    }
}
