package com.example.spring_board.item.controller;

import com.example.spring_board.item.domain.Item;
import com.example.spring_board.item.etc.ItemForm;
import com.example.spring_board.item.service.ItemService;
import com.example.spring_board.member.domain.Member;
import com.example.spring_board.member.etc.MemberForm;
import com.example.spring_board.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    

    @GetMapping("/items/new")
    public String itemCreateForm(Model model){
        model.addAttribute("form", new ItemForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String itemCreate(ItemForm itemForm) throws SQLException {
        Item item1 = Item.builder()
                .name(itemForm.getName())
                .price(itemForm.getPrice())
                .quantity(itemForm.getQuantity())
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
