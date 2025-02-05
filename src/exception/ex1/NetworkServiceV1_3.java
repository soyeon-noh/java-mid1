package exception.ex1;

// disconnect() 가 항상 실행되도록 변경
// 한계 : 정상흐름과 예외흐름이 분리되지 않아 복잡해짐
public class NetworkServiceV1_3 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); // 추가

        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
        } else {
            String sendResult = client.send(data);
            if (isError(sendResult)) {
                System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
            }
        }
        client.disconnect();
    }

    private static boolean isError(String result) {
        return !result.equals("success");
    }
}
