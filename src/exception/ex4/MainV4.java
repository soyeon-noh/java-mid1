package exception.ex4;


import exception.ex4.exception.SendExceptionV4;

import java.util.Scanner;

public class MainV4 {

    public static void main(String[] args){
//        NetworkServiceV4 networkService = new NetworkServiceV4();
        NetworkServiceV5 networkService = new NetworkServiceV5();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                networkService.snedMessage(input);
                // catch로 잡는순간 복구는 됐다
            } catch (Exception e) {
                exceptionHandler(e);
            }

            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }

    // 공통 예외 처리
    private static void exceptionHandler(Exception e) {
        // 공통 처리
        System.out.println("사용자 메시지: 죄송합니다. 알 수 없는 문제가 발생했습니다");
        System.out.println("== 개발자용 디버깅 메시지 ==");
        // 스택 트레이스 출력
        // 오류발생시 콘솔에 로그는 띄우면서 계속 문자를 전송할 수 있음.
        e.printStackTrace(System.out); // sout처럼 하얗게 나옴
//        e.printStackTrace(System.err); // 붉은 에러로 출력
//        e.printStackTrace(); // 이렇게 하면 기본 System.err
        // 보통 그냥 기본으로 하면된다.
        // (이곳에서는 console 출력이 있으므로 출력순서를 보장하여 섞이지 않게 out사용)

        // 필요하면 예외 별로 별도의 추가 처리 가능.
        if (e instanceof SendExceptionV4 sendEx) {
            System.out.println("[전송 오류] 전송데이터 : " + sendEx.getSendData());
        }
    }
}
