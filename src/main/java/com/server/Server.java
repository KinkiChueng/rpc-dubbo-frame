package com.server;

import com.service.IRpcService;

import java.io.IOException;

interface Server {
    void start() throws IOException;

    void stop();

    void register(Class<? extends IRpcService> serviceInterface, Class<? extends IRpcService> impl);
}
