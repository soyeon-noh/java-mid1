package exception.ex2;

// 예외 처리 도입
/** 문제점
 * 예외 처리를 도입했지만, 아직 예외가 복구되지 않는다.
 * 사용 후에는 반드시 disconnect()를 호출해서 연결을 해결해야한다.
 */
public class NetworkServiceV2_1 {

    public void snedMessage(String data) throws NetworkClientExceptionV2 {
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); // 추가

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
