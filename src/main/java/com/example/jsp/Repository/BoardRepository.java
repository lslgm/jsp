package com.example.jsp.Repository;

import com.example.jsp.DTO.BoardDTO;
import com.example.jsp.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {
    //기본 save,delete,findAll,findById,count는 제공
    //목록정렬처리 오름차순(ASC) 내림차순(DESC)

    List<BoardEntity> findAllByOrderByIdDesc(); //모든 결과물을 id로 내림차순

    //검색(제목검색해서 조회)
    List<BoardEntity> findAllBySubject(String subject);

    //앞에문자열이 포함되있는 제목 조회
    List<BoardEntity> findAllBySubjectStartingWith(String subject);

    //뒤에문자열이 포함되는 제목 조회
    List<BoardEntity> findAllBySubjectEndsWith(String subject);




    //문자열의 위치를 수동으로 지정해서 제목을 조회
    //Like는 %을 추가해서 문자열의 위치를 지정 -> %문자열%,%문자열,문자열%
    List<BoardEntity> findAllBySubjectLike(String subject);

    //질의어를 임의로 작성해서 제목을 조회
    //Query("select 별칠명 From 테이블명 별칭명 where 별칭명,필드명=....
    @Query("SELECT u FROM BoardEntity u WHERE u.subject like :subject")
    List<BoardEntity> findAllBySubjectSql(String subject);

    //필드명과 전달받은 변수명이 다른경우
    @Query("SELECT u FROM BoardEntity u WHERE u.subject like :subject")
    List<BoardEntity> findAllBySubjectSqlNo(@Param("subject") String name);


    //10.번호 10보다 작은자료만 조회(미만LessThan 이하LessThanEqual)
    List<BoardEntity> findAllByIdLessThan(int id);

    //조회수가 5보다큰 자료만 조회(이상 GreaterThanEqual 초과GreaterThan)
    List<BoardEntity> findAllByViewcntGreaterThan(int id);

    //2개의 필드를 이용해서 조회(제목과 작성자)
    @Query("SELECT u FROM BoardEntity u WHERE u.subject like %:subject% OR u.username like %:subject%")
    List<BoardEntity>   findAllByFeld(String subject);
    List<BoardEntity> findAllBySubjectContains(String subject);
    List<BoardEntity> findAllByUsernameContains(String username);
}
//선언후 테스트 진행 기본데이터를 작성

