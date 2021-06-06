package ac.kr.soundofwind.service;


import ac.kr.soundofwind.model.Board;
import ac.kr.soundofwind.model.User;
import ac.kr.soundofwind.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //게시글 작성
    @Transactional
    public Board writeApi(Board board, User user) {
        board.setUser(user);
        return boardRepository.save(board);
    }

    //게시글 보기
    public Board showDetails(Integer id) {
        return boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글을 찾을수 없습니다.");
        });
    }
}
