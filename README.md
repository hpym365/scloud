# scloud


``` 
zuul-gate port:5555     
api-gateway before feign server  
http://localhost:5555/feign/test?a=test 
```

```
feign port:5005  
feign-server before resource server    loadbalance and  circuit breaker
http://localhost:5005/test?a=test
```

```
client-app port:5001  
http://localhost:5001/test?a=test
```

```
eureka server port:1234
http://localhost:1234
```
