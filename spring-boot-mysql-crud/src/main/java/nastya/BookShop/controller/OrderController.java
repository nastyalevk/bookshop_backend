package nastya.BookShop.controller;

import nastya.BookShop.dto.order.OrderDto;
import nastya.BookShop.service.api.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity getOrdersByClient(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity(orderService.findByClientId(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Order error: {}", e.getMessage());
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/order/{id}")
    public ResponseEntity getOrder(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity(orderService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @GetMapping()
    public ResponseEntity findAll() {
        try {
            return new ResponseEntity(orderService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto) {
        try {
            orderService.saveOrder(orderDto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
