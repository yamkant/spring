package hello.springapi.trace.callback;

public interface TraceCallback<T> {
    T call();
}
