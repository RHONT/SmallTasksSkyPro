package t8;

/**
 * Напишите пример перехвата и обработки исключения в секции throws-метода и передачи вызывающему методу.
 */
public class Main {
    public static void main(String[] args) {
        ExceptionExample example = new ExceptionExample();
        example.method2();
    }

    static class ExceptionExample {
        public void method1() throws NullPointerException {
            String s = null;
            System.out.println(s.length());
        }

        public void method2() {
            try {
                method1();
            } catch (NullPointerException e) {
                System.err.println("Caught an exception: " + e);
            }
        }
    }
}
