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

    @Transactional
    public Board writeApi(Board board, User user) {
        board.setUser(user);
        return boardRepository.save(board);
    }
}
