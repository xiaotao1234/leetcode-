public class Sington {
    private Sington sington;

    public Sington getSington() {
        if (sington == null) {
            synchronized (Sington.class) {
                if (sington == null) {
                    sington = new Sington();
                }
            }
        }
        return sington;
    }
}
