package com.example.spring_board.item.service;

import com.example.spring_board.item.domain.Item;
import com.example.spring_board.item.etc.ItemRequestDto;
import com.example.spring_board.item.repository.ItemRepository;
import com.example.spring_board.member.domain.Member;
import com.example.spring_board.member.service.MemberService;
import com.example.spring_board.post.domain.Post;
import com.example.spring_board.post.etc.PostRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private MemberService memberService;

    public void create(ItemRequestDto itemRequestDto) throws SQLException{
        Member member1 = memberService.findByEmail(itemRequestDto.getEmail());
        Post post1 = Post.builder()
                .title(itemRequestDto.getTitle())
                .contents(itemRequestDto.getContents())
//                post에는 author변수가 있으므로, post생성시 author 객체를 넘겨주면,
//                내부적으로 author객체에서 author_id를 꺼내어 DB에 넣게 된다.
                .member(member1)
                .build();
        itemRepository.save(item1);
    }

    public List<Item> findAll(){
        List<Item> items = itemRepository.findByAppointment(null);

        return items;
    }

    public Item findById(Long myId) throws EntityNotFoundException {
        Item item = itemRepository.findById(myId).orElseThrow(EntityNotFoundException::new);
        return item;
    }

    public void update(PostRequestDto postRequestDto) throws Exception {
        Post post1 = postRepository.findById(Long.parseLong(postRequestDto.getId())).orElseThrow(Exception::new);
        if(post1 == (null)){
            throw new Exception();
        }else {
            post1.setTitle(postRequestDto.getTitle());
            post1.setContents(postRequestDto.getContents());
            postRepository.save(post1);

        }
    }

    public void delete(long id) {
        postRepository.delete(this.findById(id));

    }


}
