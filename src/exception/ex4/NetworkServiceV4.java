package exception.ex4;


public class NetworkServiceV4 {

    public void snedMessage(String data) {
        String address = "http://example.com";
        NetworkClientV4 client = new NetworkClientV4(address);
        client.initError(data); // 추가
        try {
            // 정상 흐름
            client.connect();
            client.send(data);
        } finally {
            client.disconnect();
        }
    }
}
