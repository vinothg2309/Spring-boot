### 1. MDC(Mapped Diagnostic Context)

1. Add traceId to MDC in preHandle method in LogInterceptor.java(HandlerInterceptor)

```
	MDC.put(TRACING_ID, UUID.randomUUID().toString());
```
2. Add LogInterceptor as interceptor in LoggerInterceptorConfig.java(WebMvcConfigurer).
3. Add logging pattern in application.properties & include tracingId in it.
4. Remove traceId from MDC in afterCompletion method in LogInterceptor.java

### 2. MDC in Microservices

#### https://fullstackdeveloper.guru/2020/10/27/how-to-trace-logs-across-distributed-applications-microservices-in-spring-boot/

Whenever there is a called between the microservices(A to B), add trace ID in the request header(Microservices A)
before making any subsequent service call to Microservice B

```
		HttpHeaders headers = new HttpHeaders();
        headers.add("tracingId", MDC.get("tracingId"));
```
Microservice B can also implement interceptor and follow same step as in section 1. MDC(Mapped Diagnostic Context)
Refer: https://oddblogger.com/spring-boot-mdc-logging

### 3. ThreadLocal(JAVA)

The TheadLocal construct allows us to store data that will be accessible only by a specific thread.
Next, when we want to use this value from a thread we only need to call a get() or set() method. 
Simply put, we can think that ThreadLocal stores data inside of a map – with the thread as the key.

If we use ThreadLocal in ThreadPoolExecutor, we need to perform ThreadLocal clean up
Refer https://www.baeldung.com/java-threadlocal



