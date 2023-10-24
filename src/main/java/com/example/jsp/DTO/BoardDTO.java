package com.example.jsp.DTO;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoardDTO {
    private  int id;
    @NotBlank(message = "* 제목은 필수 입력입니다.")
    @Size(min = 1,max = 50,message = "제목의 길이는 1자 이상 50자 이내로 작성하세요.")
    private String subject; //제목
    @Max(value = 255,message = "내용은 255자 이내로 작성하셔야 합니다.")
    private String content; //내용
    @NotBlank(message = "* 작성자는 생략이 불가능합니다.")
    private String username; //작성자
    private int viewcnt; //열람수
    private LocalDateTime createdDate; //생성시간
    private  LocalDateTime modifiedDate;
}
