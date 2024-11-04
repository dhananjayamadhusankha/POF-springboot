package com.springbootacademy.pointofsale.service.implement;

import com.springbootacademy.pointofsale.dto.paginate.PaginatedResponseItemDTO;
import com.springbootacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.request.OrderDetailsSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.response.ItemsGetResponseDTO;
import com.springbootacademy.pointofsale.entity.Item;
import com.springbootacademy.pointofsale.exception.NotFoundException;
import com.springbootacademy.pointofsale.repository.ItemRepository;
import com.springbootacademy.pointofsale.service.ItemService;
import com.springbootacademy.pointofsale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImplement implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if (!itemRepository.existsById(item.getItemId())){
            itemRepository.save(item);
            return itemSaveRequestDTO.getItemName()+" is saved successfully";
        }else {
            throw new DuplicateKeyException("already exist the item");
        }
    }

    @Override
    public List<ItemsGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean status = true;
        List<Item> itemList = itemRepository.findAllByItemNameEqualsAndActiveStatusEquals(itemName, status);
        if (itemList.size() > 0){
            List<ItemsGetResponseDTO> itemsGetResponseDTOList = modelMapper.map(itemList,new TypeToken<List<ItemsGetResponseDTO>>() {}.getType());
            return itemsGetResponseDTOList;
        }else {
            throw new RuntimeException("Not found a item ny name and status");
        }
    }

    @Override
    public List<ItemsGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        boolean status = true;
        List<Item> itemList = itemRepository.findAllByItemNameEqualsAndActiveStatusEquals(itemName, status);
        if (itemList.size() > 0){
            List<ItemsGetResponseDTO> itemsGetResponseDTOList = itemMapper.entityToDtoList(itemList);
            return itemsGetResponseDTOList;
        }else {
            throw new RuntimeException("Not found a item ny name and status");
        }
    }

    @Override
    public List<ItemsGetResponseDTO> getAllImageByActiveState(boolean activeStatus) {
        List<Item> itemList = itemRepository.findAllByActiveStatusEquals(activeStatus);
        if (itemList.size()>0){
            List<ItemsGetResponseDTO> itemsGetResponseDTOList = itemMapper.entityToDtoList(itemList);
            return itemsGetResponseDTOList;
        } else {
            throw new NotFoundException("No items");
        }
    }

    @Override
    public List<ItemsGetResponseDTO> getAllItems() {
        List<Item> itemList = itemRepository.findAll();
        if (itemList.size() > 0){
            List<ItemsGetResponseDTO> itemsGetResponseDTOList = itemMapper.entityToDtoList(itemList);
            return itemsGetResponseDTOList;
        }else {
            throw new NotFoundException("No Items");
        }
    }

    @Override
    public PaginatedResponseItemDTO getAllItemsByActiveStateWithPagineted(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepository.findAllByActiveStatusEquals(activeStatus, PageRequest.of(page, size));
        if (items.getSize()>0){
            List<ItemsGetResponseDTO> list = itemMapper.ListDtoToPage(items);
            long dataSize = itemRepository.countAllByActiveStatusEquals(activeStatus);;
            PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                    list, dataSize
            );

            return paginatedResponseItemDTO;
        }else {
            throw new NotFoundException("No data");
        }
    }

}
