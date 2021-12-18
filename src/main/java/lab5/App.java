package lab5;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.model.Query;
import akka.japi.Pair;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import org.asynchttpclient.AsyncHttpClient;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class App {
    public static final String HOST = "localhost";
    public static ActorRef cache;
    public static final String DEFAULT_URL = "https://www.google.ru/";


    public static Pair<String, Integer> makePair(HttpRequest request) {
        Query query = request.getUri().query();


    private static CompletionStage<Object> asy(Pair<String, Integer> pair) {
        return Patterns.ask(cache, pair, Duration.ofMillis(5000)).thenCompose(
                result -> {
                    long responseTime = ((CacheResponse) result).getTime();
                    if (responseTime > 0) {
                        return CompletableFuture.completedFuture(new Pair<>(pair.first(), responseTime));
                    }
                    return Source.from(Collections.singletonList(pair))
                            .toMat(
                                    testSink(),
                                    Keep.right()
                            )
                            .run(materializer)
                            .thenCompose(sum ->
                                CompletableFuture.completedFuture(
                                            new Pair<>(
                                                    pair.first(),
                                                    sum/pair.second()
                                            )
                                )
                            );
                });
    }


    private static Sink<Pair<String, Integer>, CompletionStage<Long>> testSink() {
        return Flow
                .<Pair<String, Integer>>create()
                .mapConcat(request -> Collections.nCopies(request.second(), request.first()))
                .mapAsync(5,
                        url -> {
    }


    public static void main(String[] args) {
        System.out.println(WELCOME_MSG);






    }

}
