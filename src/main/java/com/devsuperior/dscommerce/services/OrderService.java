package com.devsuperior.dscommerce.services;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repository.OrderItemRepository;
import com.devsuperior.dscommerce.repository.OrderRepository;
import com.devsuperior.dscommerce.repository.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

    private static final String RESOURCE_NOT_FOUND = "Resource not found";

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND));
        authService.validateSelfOrAdmin(entity.getClient().getId());
        return new OrderDTO(entity);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order entity = new Order();
        entity.setMoment(Instant.now());
        entity.setStatus(OrderStatus.WAITING_PAYMENT);
        entity.setClient(userService.authenticated());
        entity.getItems().addAll(dto.getItems().stream().map(i -> {
            Product product = new Product();
            product.setId(i.getProductId());
            Double price = productRepository.getReferenceById(product.getId()).getPrice();
            return new OrderItem(entity, product, i.getQuantity(), price);
        }).toList());
        Order result = repository.save(entity);
        orderItemRepository.saveAll(result.getItems());
        return new OrderDTO(result);
    }

}
