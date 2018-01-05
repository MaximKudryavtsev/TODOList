public class Program {
    private static TODOListManager manager = new TODOListManager();

    public static void main(String[] args) throws Exception {
        try {
            manager.doMainLoop();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
