package hello.springapi.app.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@RestController
public class OrderControllerV1Impl implements OrderControllerV1 {

    private final OrderServiceV1 orderService;

    public OrderControllerV1Impl(OrderServiceV1 orderService) {
        log.info("HERE==============================");
        this.orderService = orderService;
    }

//    @Override
    @GetMapping("/v1/request")
    public String request(String itemId) {
        log.info("HERE REQUEST==============================");
        orderService.orderItem(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
