package lang.object.equals;

import java.util.Objects;

public class UserV2 {

    private String id;

    public UserV2(String id) {
        this.id = id;
    }
/*
    // 생략된 extends Object의 method를 override
    @Override
    public boolean equals(Object obj) {
        // obj 타입엔 id가 없으므로 다운캐스팅
        UserV2 user = (UserV2) obj;
        // UserV2의 동등성은 id(고객번호)로 비교한다
        return id.equals(user.id);
    }*/

    // 정확한 equals 구현
    // Generate -> equals and hashcode 를 사용해서 equals를 구현
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserV2 userV2 = (UserV2) object;
        return Objects.equals(id, userV2.id);
    }

}
