import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class WebServer {

    public WebServer(int portNum) {
        PORT = portNum;
    }

    private static final String TASK = "/task";
    private static final String STATUS = "/status";
    private final int PORT;
    private HttpServer server;

    private final String sia = "Server is alive\n";

    public static void main(String[] args) {
        int serverPort = 8000; // default val
        if (args.length > 0) {
            try {
                serverPort = Integer.parseInt(args[0]); // First CLI arg
            } catch (NumberFormatException e) {
                System.out.println("Invalid port number, using default 8000");
            }
        }

        WebServer ws = new WebServer(serverPort);
        try {
            ws.startServer();
            System.out.println("Server is listening on " + serverPort + "...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Used for tests, don't remove
    public void shutdown() {
        System.out.println("Stopping server");
        server.stop(0);
    }

    public void startServer() throws IOException {
        InetSocketAddress isa = new InetSocketAddress(PORT);
        server = HttpServer.create(isa, 0);
        server.setExecutor(Executors.newFixedThreadPool(8));

        server.createContext(STATUS, this::handleStatusRequest);
        server.createContext(TASK, this::handleTaskRequest);

        HttpContext hpS = server.createContext(STATUS);
        hpS.setHandler(eS -> {
            try {
                handleStatusRequest(eS);
            } catch (IOException e) {
                e.printStackTrace();
            }

            HttpContext hpT = server.createContext(TASK);
            hpT.setHandler(eT -> handleStatusRequest(eT));
        });
        server.start();
    }

    public void handleStatusRequest(HttpExchange he) throws IOException {
        if (!"GET".equalsIgnoreCase(he.getRequestMethod())) {
            he.sendResponseHeaders(405, -1);
            he.close();
            return;
        }

        byte[] body = sia.getBytes(); // "Server is alive\n"
        he.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
        he.sendResponseHeaders(200, body.length);
        try (OutputStream os = he.getResponseBody()) {
            os.write(body);
        }
    }

    public void handleTaskRequest(HttpExchange exchange) throws IOException {
        if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(405, -1);
            exchange.close();
            return;
        }

        byte[] requestBytes = exchange.getRequestBody().readAllBytes();

        byte[] responseBytes;
        try {
            responseBytes = calculateResponse(requestBytes);
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
            exchange.sendResponseHeaders(200, responseBytes.length);
        } catch (NumberFormatException e) {
            String msg = "Invalid input. Expect comma-separated integers, e.g. 50,100\n";
            responseBytes = msg.getBytes();
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
            exchange.sendResponseHeaders(400, responseBytes.length);
        }

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseBytes);
        }
    }

    public byte[] calculateResponse(byte[] requestBytes) {
        String request = new String(requestBytes);

        String[] numbers = request.split(",");

        BigInteger result = BigInteger.ONE;

        for (String number : numbers) {
            BigInteger bigInteger = new BigInteger(number.trim());
            result = result.multiply(bigInteger);
        }

        String response = String.format("Result of multiplication is: %s", result);
        return response.getBytes();
    }

    public void sendResponse(byte[] bytes, HttpExchange he) throws IOException {
        he.sendResponseHeaders(200, bytes.length);
        OutputStream responseData = he.getResponseBody();
        responseData.write(bytes);
        responseData.flush();
    }

}