package Practice6.builder;

public class Director {
    void constructProduct1(IBuilder builder) {
        builder.setName("product1");
        builder.setCost(100);
        builder.setCount(10);
    }
    void constructProduct2(IBuilder builder) {
        builder.setName("product2");
        builder.setCost(200);
        builder.setCount(20);
    }
}
