package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

class ServerThread extends Thread {
    
    private int port;
    public  int squareNumber;
    public  int circleNumber;
    public  int rectangleNumber;

    public ServerThread(int port,int squareNumber,int circleNumber,int rectangleNumber) {
        this.port = port;
        this.squareNumber=squareNumber;
        this.circleNumber=circleNumber;
        this.rectangleNumber=rectangleNumber;
    }

    @Override
    public void run() {

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server Started, Port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                int clientsquareNumber = this.squareNumber;
                int clientcircleNumber = this.circleNumber;
                int clientrectangleNumber = this.rectangleNumber;
                ArrayList<Integer> integerValues = new ArrayList<Integer>();
                integerValues.add(clientsquareNumber);
                integerValues.add(clientcircleNumber);
                integerValues.add(clientrectangleNumber);
                OutputStream out = clientSocket.getOutputStream();
                DataOutputStream dout = new DataOutputStream(out);
                for (int value : integerValues) {
                    dout.writeInt(value);
                }
                dout.flush();
                System.out.println("A new client is connected: " + clientSocket.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

