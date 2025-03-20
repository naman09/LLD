package builder;

public class HttpRequest {
    private String uri;
    private HttpMethod method;

    private HttpRequest(Builder builder) {
        this.uri = builder.uri;
        this.method = builder.method;
    }

    public static class Builder {
        private String uri;
        private HttpMethod method;

        public Builder uri(String uri) {
            this.uri = uri;
            return this;
        }
        public Builder method(HttpMethod httpMethod) {
            this.method = httpMethod;
            return this;
        }
        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
    
    public HttpMethod getMethod() {
        return method;
    }
    public String getUri() {
        return uri;
    }
}
