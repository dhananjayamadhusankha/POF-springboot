package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.response.ItemsGetResponseDTO;
import com.springbootacademy.pointofsale.service.ItemService;
import com.springbootacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping("/save")
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
//        String save = itemService.saveItem(itemSaveRequestDTO);
//        return save;
//    }

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String save = itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
            new StandardResponse(200, save, "Item saved successfully"),
            HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get_by_name", params = "name")
    public List<ItemsGetResponseDTO> getItemByNameAndStatus(@RequestParam(name = "name") String itemName){
        List<ItemsGetResponseDTO> itemsGetResponseDTOList = itemService.getItemByNameAndStatus(itemName);
        return itemsGetResponseDTOList;
    }

    @GetMapping(path = "get_by_name_with_matstruct", params = "name")
    public List<ItemsGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam(name = "name") String itemName){
        List<ItemsGetResponseDTO> itemsGetResponseDTOList = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return itemsGetResponseDTOList;
    }
}
