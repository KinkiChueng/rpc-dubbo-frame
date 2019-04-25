package service;

/**
 * 服务端暴露服务接口，客户端可以直接调用
 */
public interface IHelloService extends IRpcService{
    String sayHello(String name, String msg);
}
