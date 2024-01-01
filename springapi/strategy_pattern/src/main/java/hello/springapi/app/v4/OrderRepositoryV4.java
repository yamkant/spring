package hello.springapi.app.v4;

import hello.springapi.trace.TraceStatus;
import hello.springapi.trace.logtrace.LogTrace;
import hello.springapi.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        TraceStatus status = null;
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!");
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepository.save()");


    }
//
//    public void save(String itemId) {
//        TraceStatus status = null;
//        try {
//            status = trace.begin("OrderRepository.save()");
//            if (itemId.equals("ex")) {
//                throw new IllegalStateException("예외 발생!");
//            }
//            sleep(1000);
//
//            trace.end(status);
//        } catch (Exception e) {
//            trace.exception(status, e);
//            throw e;
//        }
//
//    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
