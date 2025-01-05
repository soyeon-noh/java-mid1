package lang.object.toString;

public class ToStringMain1 {

    public static void main(String[] args) {
        Object object = new Object();
        String string = object.toString();

        // toString() 반환값 출력
        System.out.println(string);

        // object 직접 출력
        System.out.println(object);
        // println안에 toString을 호출하므로 이렇게 할 필요 없다.
//        System.out.println(object.toString());


    }
}

