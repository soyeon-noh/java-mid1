package exception.ex2;

// 예외 복구
public class NetworkServiceV2_2 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); // 추가

        /**
         * 얘외를 잡아서 처리함.
         * 따라서 예외가 복구 되고, 프로그램도 계속 수행할 수 있다.
         * 문제점 : 정상흐름과 예외흐름 분리가 안 됨
         */
        try {
            client.connect();
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
            return;
        }

        try {
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
            return;
        }

        client.disconnect();
    }
}
