package com.example.jsp;

import com.example.jsp.Entity.BaseEntity;
import com.example.jsp.Entity.BoardEntity;
import com.example.jsp.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@RequiredArgsConstructor
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;


    @Test
    public void inserttest(){
        for (int i=0; i<=20;i++) {
            BoardEntity boardEntity = BoardEntity.builder()
                    .subject("테스트 제목"+i)
                    .content("테스트 내용"+i)
                    .username("test"+i)
                    .viewcnt(i)
                    .build();
            boardRepository.save(boardEntity);
        }
    }

    @Test
    public void findlist(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        System.out.println(boardEntities.toString());
    }

    @Test
    public void serach(){
        List<BoardEntity> boardEntities = boardRepository.findAllBySubjectContains("1");
        System.out.println(boardEntities.toString());

        List<BoardEntity> list = boardRepository.findAllByUsernameContains("4");
        System.out.println(list.toString());

        List<BoardEntity> list1 = boardRepository.findAllByFeld("4");
        System.out.println(list1.toString());
    }
}
