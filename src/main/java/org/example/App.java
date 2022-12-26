package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.model.GreetinServiceImpl;

import java.io.IOException;

public class App
{
    public static void main( String[] args )
    {
        Server server =
                ServerBuilder
                        .forPort(8088)
                        .addService(new GreetinServiceImpl())
                        .build();
        try {
            server.start();
            System.out.println("server started");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
