package hello.springapi;

import hello.springapi.trace.logtrace.FieldLogTrace;
import hello.springapi.trace.logtrace.LogTrace;
import hello.springapi.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
