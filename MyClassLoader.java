public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return defineClass(name,new byte[2],0,12);
        }catch (Exception e){
            return super.findClass(name);
        }
    }
}
