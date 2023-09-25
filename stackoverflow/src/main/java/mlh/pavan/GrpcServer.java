package mlh.pavan;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import mlh.pavan.service.StackOverFlowService;


public class GrpcServer {

    public static void main(String[] args) throws Exception
    {
        System.out.println("starting GRPC Server");
        Server server = ServerBuilder.forPort(6000).addService(new StackOverFlowService()).build();
        try
        {
            server.start();
            System.out.println("Server started at "+ server.getPort());
            server.awaitTermination();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}