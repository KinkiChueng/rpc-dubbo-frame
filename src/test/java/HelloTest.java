import client.RPCClient;
import service.IHelloService;

import java.net.InetSocketAddress;

public class HelloTest {
    public static void main(String[] args) {
        InetSocketAddress addr = new InetSocketAddress("localhost", 2046);
        IHelloService sayHello = RPCClient.getRPCProxy(IHelloService.class, addr);
        System.out.println(sayHello.sayHello("lasia","hello"));
    }

}
