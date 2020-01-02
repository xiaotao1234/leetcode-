public class base {
    public static void main(String[] args) {
        base s = new base();
        s.uniquePaths();
    }

    public void uniquePaths() {

    }

    public enum singletonEnum {
        INSTANCE;

        public static void dosomething() {
            System.out.println(1);
        }
    }
}
