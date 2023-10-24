package com.example.jsp.Service;

import com.example.jsp.DTO.BoardDTO;
import com.example.jsp.Entity.BoardEntity;
import com.example.jsp.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Select;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor //Autowired
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<BoardDTO> findAll() throws  Exception{
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }

    public List<BoardEntity> findAllEntity() throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAll();
        return boardEntities;
    }

    //전체목록을 내림차순으로 조회
    public List<BoardDTO> listDESC()throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllByOrderByIdDesc();
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }

    public List<BoardDTO> subjectsearch(String subject)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllBySubject(subject);
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }
    public List<BoardDTO> subjectwith(String subject)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllBySubjectStartingWith(subject);
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }

    public List<BoardDTO> subjecendtwith(String subject)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllBySubjectEndsWith(subject);
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }


    public List<BoardDTO> subjectLike(String subject)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllBySubjectLike("%"+subject+"%");
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }

    public List<BoardDTO> subjectSql(String subject)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllBySubjectSql("%"+subject+"%");
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }
    //서로다른 변수를 연결하여 조회
    public List<BoardDTO> subjectSqlNo(String subject)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllBySubjectSqlNo("%"+subject+"%");
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }

    public List<BoardDTO> subjectBy(String search)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllByFeld(search);
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }
    public List<BoardDTO> subjectContains(String subject)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllBySubjectContains(subject);
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }
    public List<BoardDTO> usernameContains(String username)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllByUsernameContains(username);
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }

    public List<BoardDTO> subjectThen(int id)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllByIdLessThan(id);
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }
    public List<BoardDTO> viewcontGreaterThan(int id)throws Exception{
        List<BoardEntity> boardEntities = boardRepository.findAllByViewcntGreaterThan(id);
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities,BoardDTO[].class));
        return boardDTOS;
    }
}
