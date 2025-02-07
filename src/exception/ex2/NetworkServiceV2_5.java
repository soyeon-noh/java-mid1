package exception.ex2;

/**
 * 결론 : 자바 예외처리는 try ~ catch ~ finally 구조를 사용해서 처리
 * + 정상 흐름과 예외 흐름을 분리해서 코드를 읽기 쉽게 만든다.
 * + 사용한 자원을 항상 반환할 수 있도록 보장해준다.
 */
public class NetworkServiceV2_5 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); // 추가

        try {
            // 정상 흐름
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            // 예외 흐름
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        } finally{
            /** 반드시 호출해야 하는 마무리 흐름 */
            // try, cathch 안에서 잡을 수 없는 예외가 발생해도 finally이 먼저 반드시 호출된다.
            client.disconnect();
        }
    }
}
