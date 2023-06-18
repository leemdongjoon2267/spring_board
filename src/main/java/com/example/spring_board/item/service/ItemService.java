package com.example.spring_board.item.service;

import com.example.spring_board.item.domain.Item;
import com.example.spring_board.item.etc.ItemForm;
import com.example.spring_board.item.repository.ItemRepository;
import com.example.spring_board.member.domain.Member;
import com.example.spring_board.member.service.MemberService;
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

    public void create(Item item) throws SQLException{
        
        itemRepository.save(item);
    }

    public List<Item> findAll(){
        List<Item> items = itemRepository.findByAppointment(null);

        return items;
    }

    public Item findById(Long myId) throws EntityNotFoundException {
        Item item = itemRepository.findById(myId).orElseThrow(EntityNotFoundException::new);
        return item;
    }

    public void update(ItemForm itemForm) throws Exception {
        Item item1 = itemRepository.findById(Long.parseLong(itemForm.getId())).orElseThrow(Exception::new);
        if(item1 == (null)){
            throw new Exception();
        }else {
            item1.setName(itemForm.getName());
            itemRepository.save(item1);

        }
    }

    public void delete(long id) {
        itemRepository.delete(this.findById(id));

    }


}
