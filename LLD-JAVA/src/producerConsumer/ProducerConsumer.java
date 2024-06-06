package producerConsumer;

import java.util.concurrent.locks.LockSupport;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        SharedResources sharedResources = new SharedResources();
        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResources.produce();
        });

        Thread producer2 = new Thread(() -> {
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResources.produce();
        });
        Thread consumer = new Thread(sharedResources::consume);
        Thread consumer2 = new Thread(sharedResources::consume);
        consumer.start();
        consumer2.start();
        producer.start();
        producer2.start();
        producer2.join();


//       producer.start();
//        consumer.start();
//        consumer2.start();
//        producer2.start();

//        ExecutorService serv = Executors.newFixedThreadPool(5);
//        serv.submit(producer);
//        serv.submit(producer2);
//        serv.submit(consumer);
//        serv.submit(consumer2);
//        serv.shutdown();
//        try {
//            producer2.join();
//            consumer2.join();
//            consumer.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}

//private HttpClient httpClient;
//
///** Starts an HTTP Server listening on port 8080.
//    Delegates the handling of the requests to the handleHttpRequest method
// **/
//private void startHttpServer() throws IOException {
//    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
//    HttpContext context = server.createContext("/");
//    context.setHandler(this::handleHttpRequest);
//
//    // UPDATE
//    ExecutorService executorService = Executors.newFixedThreadPool(8);
//    this.httpClient = HttpClient.newBuilder().executor(executorService).build();
//    server.setExecutor(executorService);
//
//    server.start();
//}
//
///** UPDATED - Handles an incoming HTTP request from a user
//*/
//private void handleHttpRequest(HttpExchange httpExchange) {
//    int numberOfProducts = parseRequest(httpExchange);
//    URI requestURI = URI.create(String.format("best-online-store/products?number-of-products=%d", numberOfProducts);
//
//    CompletableFuture<HttpResponse<String>> responseFuture =
//            httpClient.sendAsync(HttpRequest.newBuilder()
//                    .GET()
//                    .uri(requestURI)
//                    .build(),
//            HttpResponse.BodyHandlers.ofString());
//
//    responseFuture.thenAccept( response -> {
//        sendWebpageToUser(httpExchange, response);
//    });
//}
