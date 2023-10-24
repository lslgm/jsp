package com.example.jsp.Service;

import com.example.jsp.DTO.BoardDTO;
import com.example.jsp.Entity.BoardEntity;
import com.example.jsp.Repository.BoardRepository;
import com.example.jsp.Repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor //Autowired
@Transactional
public class SearchService {
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    //서로다른 변수를 연결하여 조회
    public List<BoardDTO> searchgubun(String gubun, String search){
        List<BoardEntity> boardEntities;
        if (gubun.equals("1") && search !=null){
            boardEntities = boardRepository.findAllBySubjectContains(search);
        }else if(gubun.equals("2") && search !=null){
            boardEntities = boardRepository.findAllByUsernameContains(search);
        }else if(gubun.equals("3") && search !=null){
            boardEntities=boardRepository.findAllByFeld(search);
        }else{
            boardEntities=boardRepository.findAll();
        }
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }



}
