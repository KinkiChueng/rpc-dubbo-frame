package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RPCClient {
    @SuppressWarnings("unchecked")
    public static <T>T getRPCProxy(Class<T> tClass, final InetSocketAddress address) {
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), new Class<?>[]{tClass}, (proxy, method, args) -> {
            Socket socket = null;
            ObjectInputStream objectInputStream = null;
            ObjectOutputStream objectOutputStream = null;
            try {
                //创建连接服务的socket
                socket = new Socket();
                //绑定地址
                socket.connect(address);
                //创建输出流
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                //记录调用的类，方法，以及传入的参数，属性
                objectOutputStream.writeUTF(tClass.getName());
                objectOutputStream.writeUTF(method.getName());
                objectOutputStream.writeObject(method.getParameterTypes());
                objectOutputStream.writeObject(args);

                //同步阻塞等待服务器返回应答，获取后返回
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                return objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) socket.close();
                if (objectInputStream != null) objectInputStream.close();
                if (objectOutputStream != null) objectOutputStream.close();
            }
            return null;
        });
    }
}
