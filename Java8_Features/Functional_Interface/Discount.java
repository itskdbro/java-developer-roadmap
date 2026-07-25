package Java8_Features.Functional_Interface;

@FunctionalInterface
public interface Discount {
    double calculate(int amount, int discount);
}
