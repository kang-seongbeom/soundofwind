package ac.kr.soundofwind.service;


import ac.kr.soundofwind.dto.RequestReplySaveDto;
import ac.kr.soundofwind.domain.Board;
import ac.kr.soundofwind.domain.User;
import ac.kr.soundofwind.dto.RequestSearch;
import ac.kr.soundofwind.repository.BoardRepository;
import ac.kr.soundofwind.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public Page<Board> allBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

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

    @Transactional
    public void updateBoard(Integer id, Board board){
        boardRepository.update(board.getTitle(), board.getContent(), id);
    }

    @Transactional
    public void deleteBoard(Integer id) {
        boardRepository.deleteById(id);
    }

    //댓글 작성
    @Transactional
    public void writeReplyeApi(RequestReplySaveDto replySaveRequestDto) {
        replyRepository.saveReply(replySaveRequestDto.getUserId(),
                replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
    }

    @Transactional
    public void deleteReply(Integer replyId) {
        replyRepository.deleteById(replyId);
    }

    @Transactional
    public Page<Board> search(RequestSearch requestSearch, Pageable pageable) {
        if(requestSearch.getItem().equals("title")){
            return boardRepository.findAllByTitleLike("%"+requestSearch.getText()+"%", pageable);
        }else if(requestSearch.getItem().equals("content")){
            return boardRepository.findAllByContentLike("%"+requestSearch.getItem()+"%",pageable);
        }
        return null;
    }
}
