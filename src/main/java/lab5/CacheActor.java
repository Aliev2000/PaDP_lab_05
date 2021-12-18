package lab5;

import akka.actor.AbstractActor;
import akka.japi.Pair;
import akka.japi.pf.ReceiveBuilder;
import java.util.HashMap;
import java.util.Map;

public class CacheActor extends AbstractActor{
    private final Map<String, Long> data = new HashMap<>();

    @Override
    public Receive createReceive() {

    private void storeToCache(StoreRequest request) {
        data.put(request.getUrl(), request.getTime());
    }

    private void findInCache(Pair<String, Integer> request) {
        String url = request.first();
        sender().tell(
                new CacheResponse(url, data.getOrDefault(url, -1L)),
                getSelf()
        );
    }

}
