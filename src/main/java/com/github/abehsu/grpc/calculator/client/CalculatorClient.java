package com.github.abehsu.grpc.calculator.client;

import com.proto.sum.CalculatorServiceGrpc;
import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {

    public static void main(String[] args) {
        System.out.println("Hello I'm a gRPC client");

        //Build Channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051)
                .usePlaintext()
                .build();

        System.out.println("Creating Unary Stub");
        CalculatorServiceGrpc.CalculatorServiceBlockingStub stub = CalculatorServiceGrpc.newBlockingStub(channel);

        // Create a protocol Buffer request message
        SumRequest request = SumRequest.newBuilder()
                .setFirstNumber(4)
                .setSecondNumber(5)
                .build();

        // Call the RPC and get back a CalculatorResponse (protocol buffers)
        SumResponse response = stub.sum(request);

        System.out.println(response.getResult());

    }

}
