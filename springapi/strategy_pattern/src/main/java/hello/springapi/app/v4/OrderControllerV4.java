package hello.springapi.app.v4;

import hello.springapi.trace.logtrace.LogTrace;
import hello.springapi.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
            @Override
            protected Void call() {
                orderService.orderItem(itemId);
                return null;
            }
        };
        return template.execute("OrderController.request()");
    }

}
