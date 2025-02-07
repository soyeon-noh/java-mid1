package exception.basic.checked;

public class Client {
    // throws : 나는 MyCheckedException을 처리못하니 던질거야
    public void call() throws MyCheckedException{

        // 문제 상황
        // throw : 새로운 예외를 발생시킴
        throw new MyCheckedException("ex");
    }
}
