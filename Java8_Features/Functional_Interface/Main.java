package Java8_Features.Functional_Interface;

public class Main {
    public static void main(String[] args) {

        // Anonymous inner class
        Multiply m1 = new Multiply() {
            @Override
            public void multiply(int a, int b) {
                System.out.println(a * b);
            }
        };

        // With Lamda Expression
        Multiply m2 = (a, b) -> System.out.println(a * b);
        m2.multiply(9, 50);

        Vote v1 = age -> {
            if (age >= 18) {
                return true;
            } else return false;
        };

        // more short
        Vote v2 = age -> age >= 18;
        System.out.println(v2.canVote(23));

        MaxNumber m = (a, b) -> a > b ? a : b;
        System.out.println(m.max(9, 12));

        Discount d = (price, discount) -> price - (price * discount * 0.01);
        System.out.println(d.calculate(25000, 10));

    }


}

