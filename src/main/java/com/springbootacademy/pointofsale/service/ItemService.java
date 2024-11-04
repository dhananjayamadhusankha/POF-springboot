package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.paginate.PaginatedResponseItemDTO;
import com.springbootacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.request.OrderDetailsSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.response.ItemsGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemsGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemsGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);

    List<ItemsGetResponseDTO> getAllImageByActiveState(boolean activeStatus);

    List<ItemsGetResponseDTO> getAllItems();

    PaginatedResponseItemDTO getAllItemsByActiveStateWithPagineted(boolean activeStatus, int page, int size);

}
