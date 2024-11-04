package com.springbootacademy.pointofsale.util.mappers;

import com.springbootacademy.pointofsale.dto.paginate.PaginatedResponseItemDTO;
import com.springbootacademy.pointofsale.dto.response.ItemsGetResponseDTO;
import com.springbootacademy.pointofsale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    public List<ItemsGetResponseDTO> entityToDtoList(List<Item> items);

    List<ItemsGetResponseDTO> ListDtoToPage(Page<Item> items);

//    List<ItemsGetResponseDTO> af(List<Item> itemList);
}
