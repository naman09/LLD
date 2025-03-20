package builder;

class Main {
    public static void main(String[] args) {
        HttpRequest req = new HttpRequest.Builder()
                                .uri("dwad")
                                .method(HttpMethod.GET)
                                .build();

        System.out.println(req.getUri() + " " + req.getMethod());
    }
}