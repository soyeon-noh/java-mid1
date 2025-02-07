package exception.basic.unchecked;

// throws 생략가능. 자동으로 던져짐
// 언체크 예외는 주로 생략하지만 중요한 예외인 경우 가독성을 위해 작성
public class Client {
    public void call() {
        // runtime error라 컴파일러가 체크 안 함.
        throw new MyUncheckedException("ex");
    }
}
