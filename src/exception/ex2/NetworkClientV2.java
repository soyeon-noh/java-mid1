package exception.ex2;

public class NetworkClientV2 {

    private final String address;
    public boolean connectError; // 기본값 false
    public boolean sendError;

    public NetworkClientV2(String address) {
        this.address = address;
    }

    /**
     * 체크 오류이기 때문에 throws로 던져줘야한다.
     */
    public void connect() throws NetworkClientExceptionV2{
        if (connectError) {
            throw new NetworkClientExceptionV2("connectError", address + " 서버 연결 실패");
        }
        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }
    /**
     * 오류가 발생했을 때 오류 코드를 반환하는 게 아니라 예외를 던진다.
     * 따라서 반환값을 사용하지 않아도되는 void 로 처리.
     * - 메서드가 정상 종료되면 성공 / 예외가 던져지면 실패
     * - 오류가 발생하면 예외 객체를 만들고 거기에 오류 코드와 유류 메시지를 담아둠
     *   그리고 만든 예외 객체를 throw를 통해 던진다.
     */
    public void send(String data) throws NetworkClientExceptionV2 {

        if (sendError) {
            throw new NetworkClientExceptionV2("sendError",address + " 서버에 데이터 전송 실패: " + data);
//             중간에 다른 예외가 발생했다고 가정
//            throw new RuntimeException("ex");
        }
        // 전송 성공
        System.out.println(address + " 서버에 데이터 전송: " + data);
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해재");
    }

    public void initError(String data) {
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }
}
