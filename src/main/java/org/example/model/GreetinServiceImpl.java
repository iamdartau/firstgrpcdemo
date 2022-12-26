package org.example.model;

import io.grpc.stub.StreamObserver;
import org.example.grpc.GreetingServiceGrpc;
import org.example.grpc.StartServiceClient;

public class GreetinServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(StartServiceClient.HelloRequest request,
                         StreamObserver<StartServiceClient.HelloResponse> responseObserver) {

        System.out.println(request);

        StartServiceClient.HelloResponse response = StartServiceClient
                .HelloResponse
                .newBuilder()
                .setGreeting("hi, welcome to server " + request.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
