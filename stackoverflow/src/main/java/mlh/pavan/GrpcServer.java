package mlh.pavan;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import mlh.pavan.service.StackOverFlowService;
import mlh.pavan.Constants.Constants;
import mlh.pavan.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GrpcServer {

    private static final Logger logger = LogManager.getLogger(GrpcServer.class);

    public static void main(String[] args) throws Exception
    {
        Server server = ServerBuilder.forPort(PropertyReader.getInstance().getGrpcServerPort()).addService(new StackOverFlowService()).build();
        try
        {
            logger.info(Constants.SERVER_LISTENING_MESSAGE);
            server.start();
            server.awaitTermination();
        }
        catch(Exception e)
        {
            logger.error("Server terminated"+e.getMessage());
        }
    }
}