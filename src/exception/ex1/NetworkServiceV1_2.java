package exception.ex1;

// 연결 실패시 데이터 전송을 하지 않게 변경
// 오류 로그 추가
// 한계 : disconnect()가 호출되지 않아 연결 해제가 안됨
public class NetworkServiceV1_2 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); // 추가


        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
            return; // 연결실패시 빠져나감
        }

        String sendResult = client.send(data);
        if (isError(sendResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
            return;
        }

        client.disconnect();
    }

    private static boolean isError(String connectResult) {
        return !connectResult.equals("success");
    }
}
