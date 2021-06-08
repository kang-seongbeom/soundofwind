package ac.kr.soundofwind.service;


import ac.kr.soundofwind.domain.Board;
import ac.kr.soundofwind.domain.User;
import ac.kr.soundofwind.domain.Wiki;
import ac.kr.soundofwind.repository.WikiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WikiService {

    @Autowired
    private WikiRepository wikiRepository;

    @Transactional
    public Page<Wiki> allWikis(Pageable pageable) {
        return wikiRepository.findAll(pageable);
    }

    @Transactional
    public Wiki showDetails(Integer id) {
        return wikiRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글을 찾을수 없습니다.");
        });
    }

    //wiki작성
    @Transactional
    public void writeApi(Wiki wiki, User user) {
        wiki.setUser(user);
        wikiRepository.save(wiki);
    }

    @Transactional
    public void updateWiki(Integer id, Wiki wiki){
        wikiRepository.update(wiki.getTitle(), wiki.getContent(), id);
    }

    @Transactional
    public void deleteWiki(Integer id) {
        wikiRepository.deleteById(id);
    }
}
