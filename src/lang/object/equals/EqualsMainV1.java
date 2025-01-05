package lang.object.equals;

// 동일성, 동등성 비교
public class EqualsMainV1 {

    public static void main(String[] args) {
        UserV1 user1 = new UserV1("id-100");
        UserV1 user2 = new UserV1("id-100");

        System.out.println("identity = " + (user1 == user2)); //false
        System.out.println("equality = " + (user1.equals(user2))); // false
        // Object가 기본으로 제공하는 equals() 는 == 으로 동일성 비교를 제공한다.
        // -> 동등성 비교를 사용하고 싶으면 equals() 메서드를 재정의해야한다.

    }
}
