package com.springbootacademy.pointofsale.service.implement;

import com.springbootacademy.pointofsale.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.response.ItemsSaveResponseDTO;
import com.springbootacademy.pointofsale.entity.Item;
import com.springbootacademy.pointofsale.repository.ItemRepository;
import com.springbootacademy.pointofsale.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImplement implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

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
    public List<ItemsSaveResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean status = true;
        List<Item> itemList = itemRepository.findAllByItemNameEqualsAndActiveStatusEquals(itemName, status);
        if (itemList.size() > 0){
            List<ItemsSaveResponseDTO> itemsSaveResponseDTOList = modelMapper.map(itemList,new TypeToken<List<ItemsSaveResponseDTO>>() {}.getType());
            return itemsSaveResponseDTOList;
        }else {
            throw new RuntimeException("Not found a item ny name and status");
        }
    }
}
