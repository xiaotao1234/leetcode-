public class Singleton {
    private Singleton(){

    }
    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder{
        public static Singleton singleton = new Singleton();
    }
}
