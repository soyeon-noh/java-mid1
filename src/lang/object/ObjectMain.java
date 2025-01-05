package lang.object;

// 자바에서 Object 클래스가 최상위 부모 클래스인 이유
// 1. 공통 기능 제공
// 2. 다형성의 기본 구현
public class ObjectMain {

    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        // toString()은 Object 클래스의 매서드
        String string = child.toString();
        System.out.println(string);
    }
}
