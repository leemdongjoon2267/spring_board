package com.example.spring_board.item.controller;

import com.example.spring_board.item.domain.Item;
import com.example.spring_board.item.etc.ItemDto;
import com.example.spring_board.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping("/items/new")
    public String itemCreateForm(Model model){
        model.addAttribute("form", new ItemDto());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String itemCreate(ItemDto itemDto) throws SQLException {
        Item item1 = Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .stockQuantity(itemDto.getStockQuantity())
                .build();
        itemService.create(item1);

        return "redirect:/items";
    }

    @GetMapping("items")
    public String itemFindAll(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("item/{id}/edit")
//    get요청의 paramete넣는 방법 2가지 1)pathvariable 2)RequestParam(Form을 쓰는 방법)
    public String itemUpdateForm(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @PostMapping("item/{id}/edit")
    public String itemUpdate(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/itemList";
    }

}
