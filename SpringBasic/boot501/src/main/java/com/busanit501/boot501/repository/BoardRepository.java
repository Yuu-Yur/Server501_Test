package com.busanit501.boot501.repository;

import com.busanit501.boot501.domain.Board;
import com.busanit501.boot501.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//extends JpaRepository<Board, Long> -> 기본 쿼리 메소드 이용해서,
// 간단한 crud 디비 작업은, 메서드를 이용해서 처리가 가능함.

// Querydsl 이용시, 만들었던 인터페이스를 추가 구현 해야함.
public interface BoardRepository extends JpaRepository<Board, Long> , BoardSearch {
//public interface BoardRepository extends JpaRepository<Board, Long>  {
    // 아무 메서드가 없음.
    // 하지만, 우리는 기본 탑재된 쿼리 메소드를 활용할 예정.

    //쿼리스트링 ,방법1
    Page<Board> findByTitleContainingOrderByBnoDesc(String title, Pageable pageable);

    //@Query , 방법2 전달. JPQL 문법으로, 작성하고,
    // 모든 디비(마리아다비, 오라클, 마이SQL, PostGre 관계형 디비)에 적용이 됨.
    @Query("select b from Board b where b.title like concat('%',:keyword,'%')")
    Page<Board> findByKeyword(String keyword, Pageable pageable);

    // Querydsl  도구 이용해서, 방법3,
    // BoardSearch 인터페이스 구현하고, 이 인터페이스를 구현한 클래스에서 문법 사용.
    // BoardSearchImpl 구현한 클래스의 이름. 구현체,



}