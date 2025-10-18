package poly.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class Lab1Java5Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab1Java5Application.class, args);

        // Sau khi chạy xong thì mở trình duyệt
        try {
            String url = "http://localhost:8080/poly/hello";
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
