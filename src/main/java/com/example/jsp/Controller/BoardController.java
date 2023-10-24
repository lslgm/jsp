package com.example.jsp.Controller;

import com.example.jsp.DTO.BoardDTO;
import com.example.jsp.Entity.BoardEntity;
import com.example.jsp.Service.BoardService;
import com.example.jsp.Service.SearchService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private  final BoardService boardService;
    private final SearchService searchService;

    @GetMapping("/basiclist")
    public String baiclist(Model model) throws Exception {
        List<BoardDTO> lists=boardService.findAll();
        model.addAttribute("list",lists);
        return "board/list"; //1.매핑확인
    }

    @GetMapping("/entitylist")
    public String entitylist(Model model)throws Exception{
        List<BoardEntity> lists = boardService.findAllEntity();
        model.addAttribute("list",lists);
        return "board/listEntity";
    }

    @GetMapping("/selectlist")
    public String selectlist(Model model)throws Exception{
        return "board/search";
    }
    //검색어를 받아 서비스에서 처리 후 결과를 페이지에 전달
        //repository에 필요한 메소드생성
        //service에서 해당 repository를 수행할 메소드를 생성
        //controller에서 service의 메소드를 지정
    @PostMapping("/selectlist")
    public String resultlist(String search,Model model)throws Exception{
        //내림차순정렬
       // List<BoardDTO> list =  boardService.listDESC();
       // List<BoardDTO> list = boardService.subjectsearch(search); //정확히 일치해야함

       // List<BoardDTO> list = boardService.subjectwith(search);

       // List<BoardDTO> list = boardService.subjecendtwith(search);

        //문자열이 포함된 제목 조회 실질적으로 많이  사용
       // List<BoardDTO> list = boardService.subjectContains(search);
        //@Query로 문자열이 포함된 제목을 조회
       // List<BoardDTO> list = boardService.subjectLike(search);

        //List<BoardDTO> list = boardService.subjectSql(search);
        //서로다른 변수명으로제목을 조회
        //List<BoardDTO> list = boardService.subjectSqlNo(search);
        List<BoardDTO> list = boardService.subjectBy(search);
        //List<BoardDTO> list = boardService.subjectThen(10);
        //List<BoardDTO> list = boardService.viewcontGreaterThan(5);
        model.addAttribute("list",list);
        return "board/list";
    }//데이터베이스 명령에서 like는 포함되어있는 문자열 검색
    @GetMapping("/serachlist")
    public String searchlistFrom(Model model)throws Exception{
        return "board/searchlist";
    }

    @PostMapping("/serachlist")
    public String searchlistProc(String gubun,String search,Model model)throws Exception{
        List<BoardDTO> lists=searchService.searchgubun(gubun,search);
        model.addAttribute("list",lists);
        return "board/searchlist";
    }

}
