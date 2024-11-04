package com.springbootacademy.pointofsale.util.mappers;

import com.springbootacademy.pointofsale.dto.request.OrderDetailsSaveRequestDTO;
import com.springbootacademy.pointofsale.entity.OrderDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    List<OrderDetails> dtoListToEntityList(List<OrderDetailsSaveRequestDTO> orderDetails);
}
