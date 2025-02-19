package exception.ex3;

import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.SendExceptionV3;

public class NetworkServiceV3_1 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data); // 추가

        try {
            // 정상 흐름
            client.connect();
            client.send(data);
            /**
             * 예외 클래스를 각각의 예외 상황에 맞추어 만들면, 각 필요에 맞는 예외를 잡아서 처리 가능
             * catch(ConnectExceptionV3 e) : 연결 예외를 잡고, 해당 예외가 제공하는 기능을 사용해서 정보출력
             * catch(SendExceptionV3 e) : 전송 예외를 잡고, 해당 예외가 제공하는 기능을 사용해서 정보출력
             */
        } catch (ConnectExceptionV3 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (SendExceptionV3 e) {
            System.out.println("[전송 오류] 전송 데이터: " + e.getSendData() + ", 메시지: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }
}
