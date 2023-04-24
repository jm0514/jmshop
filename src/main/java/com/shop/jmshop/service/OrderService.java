package com.shop.jmshop.service;

import com.shop.jmshop.dto.OrderDto;
import com.shop.jmshop.entity.Item;
import com.shop.jmshop.entity.Member;
import com.shop.jmshop.entity.Order;
import com.shop.jmshop.entity.OrderItem;
import com.shop.jmshop.repository.ItemRepository;
import com.shop.jmshop.repository.MemberRepository;
import com.shop.jmshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    public Long order(OrderDto orderDto, String email) {
        Item item = itemRepository.findById(orderDto.getItemId())
                .orElseThrow(() -> new EntityExistsException());
        Member member = memberRepository.findByEmail(email);

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount());
        orderItemList.add(orderItem);

        Order order = Order.createOrder(member, orderItemList);
        orderRepository.save(order);

        return order.getId();
    }

}
