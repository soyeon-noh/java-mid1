package exception.basic.checked;

public class CheckedThrowMain {

    /**
     * Service.callThrow() 에서 던진 예외를
     * main()의 callThrow() 를 호출하는 곳에서 처리 못해서 '정상종료' 안 뜸
     *
     * 예외가 main() 밖으로 던져지면
     * 예외 정보와 스택 트레이스(Stack Trace)를 출력하고 프로그램이 종료된다.
     */

    public static void main(String[] args) throws MyCheckedException {
        Service service = new Service();
        service.callThrow();
        System.out.println("정상 종료");
    }
}
