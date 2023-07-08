//package com.example.spring_board.order.item.service;
//
//import com.example.spring_board.order.item.domain.Item;
//import com.example.spring_board.order.item.etc.ItemDto;
//import com.example.spring_board.order.item.repository.ItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.sql.SQLException;
//import java.util.List;
//
//@Service
//@Transactional
//public class ItemService {
//
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    public void create(Item item) throws SQLException{
//
//        itemRepository.save(item);
//    }
//
//    public List<Item> findAll(){
//        List<Item> items = itemRepository.findAll();
//
//        return items;
//    }
//
//    public Item findById(Long myId){
//        return  itemRepository.findById(myId).orElse(null);
//    }
//
//    public void update(Long myId, ItemDto itemDto){
////        조회하고, save
//        Item item = itemRepository.findById(myId).orElse(null);
//        item.updateItem(itemDto.getPrice(), item.getStockQuantity());
//        itemRepository.save(item);
//    }
//
//
//
//    public void delete(long myId) {
//        Item item = itemRepository.findById(myId).orElse(null);
//        itemRepository.delete(item);
//
//    }
//
//
//}
