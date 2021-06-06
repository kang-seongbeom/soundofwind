package ac.kr.soundofwind.service;


import ac.kr.soundofwind.dto.RequestReplySaveDto;
import ac.kr.soundofwind.model.Board;
import ac.kr.soundofwind.model.Reply;
import ac.kr.soundofwind.model.User;
import ac.kr.soundofwind.repository.BoardRepository;
import ac.kr.soundofwind.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    //게시글 보기
    @Transactional
    public Board showDetails(Integer id) {
        return boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글을 찾을수 없습니다.");
        });
    }

    //게시글 작성
    @Transactional
    public void writeApi(Board board, User user) {
        board.setUser(user);
        boardRepository.save(board);
    }


    //댓글 작성
    @Transactional
    public void writReplyeApi(RequestReplySaveDto replySaveRequestDto) {
        replyRepository.saveReply(replySaveRequestDto.getUserId(),
                replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
    }

    //uodate를 하려면 영속화를 시켜야함
    @org.springframework.transaction.annotation.Transactional
    public void updateBoard(Integer id, Board board){
        System.out.println("----------"+id+"/"+board);
        boardRepository.update(board.getTitle(), board.getContent(), id);
    }
}
