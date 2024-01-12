import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String url = sc.next();

        System.out.println("Enter the desired url (without https://)");
        System.out.println("https://" + url);
        write(findCertificates(url));

    }
    public static Certificate[] findCertificates(String url) throws IOException {
        URL destinationURL = new URL("https://" + url);
        HttpsURLConnection connection = (HttpsURLConnection) destinationURL.openConnection();
        connection.connect();
        return connection.getServerCertificates();
    }

    public static void write(Certificate[] certificates) {
        int i = 1;

        for (Certificate cert:certificates
        ) {
            System.out.println("Certifikát: "+ i + cert);
            i++;
        }
    }
}