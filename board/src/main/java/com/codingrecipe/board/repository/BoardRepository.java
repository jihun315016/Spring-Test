package com.codingrecipe.board.repository;

import com.codingrecipe.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    // mybatis에서 제공하는 클래스
    private final SqlSessionTemplate sql;

    public void save(BoardDTO boardDTO) {
        // Board.save에서 Board는 board-mapper.xml 파일의 mapper namespace를 가리킨다.
        // save는 쿼리문을 담고있는 태그를 의미
        // boardDTO 객체는 db에 넘길 파라미터 객체, 하나만 적을 수 있다. -> 두 개 이상이라면 해시맵같은걸로 넘긴다.
        sql.insert("Board.save", boardDTO);
    }

    public List<BoardDTO> findAll() {
        // 이건 파라미터 없음
        return sql.selectList("Board.findAll");
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }

    public BoardDTO findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }
}
