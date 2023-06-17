package com.example.spring_board.item.controller;

import com.example.spring_board.item.domain.Item;
import com.example.spring_board.item.etc.ItemRequestDto;
import com.example.spring_board.item.service.ItemService;
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
    private ItemService itemtService;

    @Autowired
    private MemberService memberService;


    @GetMapping("items/new")

    public String itemCreateForm(){
        return "item/item-register";
    }

    @PostMapping("items/new")
    public String itemCreate(ItemRequestDto itemRequestDto) throws SQLException {
        itemService.create(itemRequestDto);
        return "redirect:/";
    }

    @GetMapping("posts")
    public String itemFindAll(Model model){
        List<Item> items = itemService.findAll();
        model.addAttribute("itemList", items);
        return "item/item-list";
    }

    @GetMapping("item")
    public String itemFindById(@RequestParam(value = "id")Long myId, Model model)throws EntityNotFoundException {
        Item item = itemService.findById(myId);
        model.addAttribute("item", item);
        return "item/item-detail";
    }

    @PostMapping("item/update")
    public String itemUpdate (ItemRequestDto itemRequestDto) throws Exception {
        itemService.update(itemRequestDto);
        return "redirect:/";
    }

    @GetMapping("item/delete")
    public String deleteMember(@RequestParam(value = "id")String id){

        itemService.delete(Long.parseLong(id));
        return "redirect:/";

    }

}
