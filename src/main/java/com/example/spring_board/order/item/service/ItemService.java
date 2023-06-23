package com.example.spring_board.order.item.service;

import com.example.spring_board.order.item.domain.Item;
import com.example.spring_board.order.item.etc.ItemDto;
import com.example.spring_board.order.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;

    public void create(Item item) throws SQLException{

        itemRepository.save(item);
    }

    public List<Item> findAll(){
        List<Item> items = itemRepository.findAll();

        return items;
    }


    public void update(ItemDto itemDto) throws Exception {
        Item item1 = itemRepository.findById(Long.parseLong(itemDto.getId())).orElseThrow(Exception::new);
        if(item1 == (null)){
            throw new Exception();
        }else {
            item1.setName(itemDto.getName());
            itemRepository.save(item1);

        }
    }

    public void delete(long id) {
        itemRepository.delete(this.findById(id));

    }


}
