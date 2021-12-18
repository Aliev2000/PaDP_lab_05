package lab5;

public final class CacheResponse {
    private final String url;
    private final Long time;

    public String getUrl() {

    public Long getTime() {
        return time;
    }

    public CacheResponse(String url, Long time) {
        this.url = url;
        this.time = time;
    }
}