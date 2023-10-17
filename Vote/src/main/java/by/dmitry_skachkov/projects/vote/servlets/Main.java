package by.dmitry_skachkov.projects.vote.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //hometask with console working

        Scanner scanner = new Scanner(System.in);




        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();



        URL url = new URL("http://localhost:8080/Second/hello_with_name?firstName=" + firstName + "&lastName=" + lastName);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if(responseCode == 200) {
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println(responseReader.readLine());
        } else {
            System.out.println("error");
        }
        connection.disconnect();

    }
}