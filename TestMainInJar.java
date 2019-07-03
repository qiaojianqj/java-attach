package agentmain;

public class TestMainInJar {
    public static void main(String[] args) throws InterruptedException {
		TransClass transClass = new TransClass();
        System.out.println(transClass.getNumber());
        while (true) {
            Thread.sleep(2000);
            int number = transClass.getNumber();
            System.out.println(number);
        }
    }
}

