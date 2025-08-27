import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            File password = new File("passwords.yml"); // you can use your own file name
            if (password.createNewFile()) {
                System.out.println("password file created successfully");
            } else {
                System.out.println("password file already exists");
            }
        } catch (Exception e) {
            System.out.println("error while creating password file");
        }


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String password = encoder.encode(RandomStringUtils.random(10, true, true)); // example, you can hash your own password

        try {
            FileWriter fileWriter = new FileWriter("passwords.yml"); // you can use your own file name
            fileWriter.append(password);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
