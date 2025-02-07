package exception.ex2;

// 예외도 객체. 필요한 필드와 메서드를 가질 수 있다.
public class NetworkClientExceptionV2 extends Exception{

    // 오류 코드
    // 어떤 종류에 오류가 발생했는지 구분하기 위해
    private String errorCode;

    // 오류 메시지
    // 어떤 오류가 발생했는지 개발자가 보고 이해할 수 있는 설명 담기
    // 상위 클래스인 Throwable 에서 기본으로 제공하는 기능을 사용
    public NetworkClientExceptionV2(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
