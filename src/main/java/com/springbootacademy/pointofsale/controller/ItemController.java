package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.response.ItemsSaveResponseDTO;
import com.springbootacademy.pointofsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String save = itemService.saveItem(itemSaveRequestDTO);
        return save;
    }

    @GetMapping(path = "/get_by_name", params = "name")
    public List<ItemsSaveResponseDTO> getItemByNameAndStatus(@RequestParam(name = "name") String itemName){
        List<ItemsSaveResponseDTO> itemsSaveResponseDTOList = itemService.getItemByNameAndStatus(itemName);
        return itemsSaveResponseDTOList;
    }
}
