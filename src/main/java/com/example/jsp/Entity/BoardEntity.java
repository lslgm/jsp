package com.example.jsp.Entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="board")
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @Column(length = 100,nullable = false)
    private String subject; //제목

    private String content; //내용

    @Column(length = 20)
    private String username; //작성자

    private int viewcnt; //열람수
}
