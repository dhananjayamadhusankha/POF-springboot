package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.response.ItemsGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemsGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemsGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);
}
