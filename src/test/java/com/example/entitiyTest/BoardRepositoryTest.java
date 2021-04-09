package com.example.entitiyTest;

import com.example.entitiyTest.domain.Board;
import com.example.entitiyTest.domain.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void insertTest(){
        String title = "title2";
        String writer="writer2";
        String content="content2";

        boardRepository.save(Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build());
        List<Board> boards =boardRepository.findAll();
        //then
        Board board = boards.get(0);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
        assertThat(board.getWriter()).isEqualTo(writer);
    }
}
