package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Подключение к серверу...");
            System.out.print("Введите размер матрицы: ");
            String input = stdIn.readLine();
            out.println(input);
            System.out.println("Матрица:");
            String matrixRow;
            while ((matrixRow = in.readLine()) != null) {
                System.out.println(matrixRow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}