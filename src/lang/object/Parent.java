package lang.object;

// 부모가 없으면 묵시적으로 Object 클래스를 상속받는다.
// 따라서 생략 권장
public class Parent extends Object{

    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
