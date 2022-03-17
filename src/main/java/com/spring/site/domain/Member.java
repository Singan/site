package com.spring.site.domain;


import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {

    private int mNo;
    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "[a-zA-Z0-9]{2,9}",
            message = "아이디는 영문, 숫자만 가능하며 2 ~ 10자리까지 가능합니다.")
    private String id;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{6,16}",
            message = "비밀번호는 영문과 숫자 조합으로 6 ~ 16자리까지 가능합니다.")
    private String pw;
    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 2, max = 8, message = "이름을 2~8자 사이로 입력해주세요.")
    private String name;
    private String email;
    private String phone;
    private Date registerDay;
    private String role = "ROLE_USER";
    private String profile;

}
