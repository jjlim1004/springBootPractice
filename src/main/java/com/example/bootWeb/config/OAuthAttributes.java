package com.example.bootWeb.config;

import com.example.bootWeb.domain.Member;
import com.example.bootWeb.domain.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;


// of -> ofNaver -> OAuthAttributes 생성

@Getter
public class OAuthAttributes {
    private Map<String,Object> attributes;
    private String nameAttributeKey;
    private String id;
    private String name;
    private String email;
    private String gender;
    private String age;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey,String id, String age,
                           String name, String email, String gender) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    // of()
    // OAuth2User 에서 반환하는 사용자 정보는 Map이므로 값 하나하나를 변환해야 한다.
    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String ,Object> attributes) {
        if ("naver".equals(registrationId)) {
            return ofNaver("id",attributes);
        }
        return ofGoogle(userNameAttributeName,attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,Map<String ,Object> attributes){
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String,Object> attributes) {
        Map<String,Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .id((String) response.get("id"))
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .gender((String) response.get("gender"))
                .age((String) response.get("age"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    // toEntity()
    // Member 엔티티를 생성한다.
    // OAuthAttributes 에서 엔티티를 생성하는 시점 == 처음 가입할 때
    // 가입할 떄의 기본 권한을 GUEST로 주기 위해서 role 빌더 값에는 Role.GUEST를 설정한다.
    public Member toEntity() {
        return Member.builder()
                .memberId(id)
                .memberName(name)
                .memberEmail(email)
                .memberGender(gender)
                .memberAge(age)
                .role(Role.GUEST)
                .build();
    }
}