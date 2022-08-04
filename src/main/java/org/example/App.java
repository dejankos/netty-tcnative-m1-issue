package org.example;

import io.netty.handler.ssl.OpenSsl;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Slf4JLoggerFactory;

import static java.lang.System.out;

public class App {

    public static void main(String[] args) {
        InternalLoggerFactory.setDefaultFactory(Slf4JLoggerFactory.INSTANCE);

        out.println("OS =" + PlatformDependent.normalizedOs());
        out.println("Arch =" + PlatformDependent.normalizedArch());

        // trigger loading native lib
        out.println("Open SSL available =" + OpenSsl.isAvailable());
    }
}
