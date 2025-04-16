import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class thread1 implements Runnable {

    public thread1() {
        Thread t1 = Thread.currentThread();
        Thread t2 = new Thread(this,"secondo");

        t2.start();

        System.out.println(t1.getName());
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("t 1 Sec->" + (i + 1));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("mi hanno interrotto");
        }


        
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < Math.random()*10; i++){
                URL url = new URL("https://icanhazdadjoke.com/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "text/plain");
                
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println(inputLine);
                    }
                }
            }
            
        } catch (IOException e) {
            System.err.println("Errore durante la richiesta: " + e.getMessage());
        }
    }
}