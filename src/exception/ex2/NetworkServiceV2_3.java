package exception.ex2;

// 예외 복구
public class NetworkServiceV2_3 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); // 추가

        /**
         * 하나의 try 안에 정상 흐름을 모두 담는다.
         * 문제점: 예외가 발생하면 disconnect()가 호출되지 않음
         */
        try {
            // 정상 흐름
            client.connect();
            client.send(data);
            client.disconnect(); // 예외 발생시 무시
        } catch (NetworkClientExceptionV2 e) {
            // 예외 흐름
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
            return;
        }
    }
}
