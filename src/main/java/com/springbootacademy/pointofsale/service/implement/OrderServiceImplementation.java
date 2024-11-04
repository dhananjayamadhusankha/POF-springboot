package com.springbootacademy.pointofsale.service.implement;

import com.springbootacademy.pointofsale.dto.request.OrderDetailsSaveRequestDTO;
import com.springbootacademy.pointofsale.dto.request.OrderSaveRequestDTO;
import com.springbootacademy.pointofsale.entity.Order;
import com.springbootacademy.pointofsale.entity.OrderDetails;
import com.springbootacademy.pointofsale.exception.NotFoundException;
import com.springbootacademy.pointofsale.repository.CustomerRepository;
import com.springbootacademy.pointofsale.repository.ItemRepository;
import com.springbootacademy.pointofsale.repository.OrderDetailsRepository;
import com.springbootacademy.pointofsale.repository.OrderRepository;
import com.springbootacademy.pointofsale.service.OrderService;
import com.springbootacademy.pointofsale.util.mappers.OrderMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImplementation implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    @Transactional
    public String saveOrder(OrderSaveRequestDTO orderSaveRequestDTO) {
        Order order = new Order(
                customerRepository.getReferenceById(orderSaveRequestDTO.getCustomerId()),
                orderSaveRequestDTO.getDate(),
                orderSaveRequestDTO.getTotalQuantity()
        );
        orderRepository.save(order);

        if (orderRepository.existsById(order.getOrderId())){
            List<OrderDetails> orderDetailsList = orderMapper.dtoListToEntityList(orderSaveRequestDTO.getOrderDetails());
            for (int i = 0; i < orderDetailsList.size(); i++){
                orderDetailsList.get(i).setOrder(order);
                orderDetailsList.get(i).setItem(itemRepository.getReferenceById(
                        orderSaveRequestDTO.getOrderDetails().get(i).getItemId()
                ));
            }
            if (orderDetailsList.size() > 0){
                orderDetailsRepository.saveAll(orderDetailsList);
                return "saved";
            }else {
                throw new NotFoundException("No order Details");
            }
        }else {
            throw new NotFoundException("Can not find order ID");
        }
    }
}
