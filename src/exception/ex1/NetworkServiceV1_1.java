package exception.ex1;

// 한계 : 연결 실패시 데이터 전송됨. 로그x
public class NetworkServiceV1_1 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV1 client = new NetworkClientV1(address);
        client.initError(data); // 추가

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
