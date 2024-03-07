package Practice6.abstract_fabric;

public class Factory1 implements IFactory {
    @Override
    public IProduct1 createProduct1() {
        return new Product11();
    }

    @Override
    public IProduct2 createProduct2() {
        return new Product21();
    }
}
