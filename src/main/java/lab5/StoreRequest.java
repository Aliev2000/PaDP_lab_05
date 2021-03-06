package lab5;

public final class StoreRequest {
    private final String url;
    private final Long time;

    public StoreRequest(String url, long time) {
        this.url = url;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public long getTime() {
        return time;
    }
}
