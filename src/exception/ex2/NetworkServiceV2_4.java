package exception.ex2;

// 예외 복구
public class NetworkServiceV2_4 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); // 추가

        /**
         * disconnect()를 try-catch 외부로 빼면서 항상 실행되도록 함.
         */
        try {
            // 정상 흐름
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            // 예외 흐름
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }
        /**
         * 문제점 : NetworkClientException 이 아닌 다른 예외가 발생해서 예외가 밖으로 던져지면 무시됨
         * 결과적으로 : 지금과 같은 구조로는 disconnect를 항상 호출하는 것이 매우 어려움
         */
        client.disconnect();
    }
}
