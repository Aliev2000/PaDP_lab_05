package lab5;

public final class CacheResponse {
    private final String url;
    private final Long time;

    public CacheResponse(String url, Long time) {
        this.url = url;
        this.time = time;
    }
}