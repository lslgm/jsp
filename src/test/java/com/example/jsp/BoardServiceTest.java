package com.example.jsp;

import com.example.jsp.DTO.BoardDTO;
import com.example.jsp.Entity.BoardEntity;
import com.example.jsp.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

public class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    public void findAllDTO()throws Exception{
        List<BoardDTO> list =boardService.findAll();
        System.out.println(list.toString());
    }
    @Test
    public void findAllEntity()throws Exception{
        List<BoardEntity> list = boardService.findAllEntity();
        System.out.println(list.toString());
    }
}
