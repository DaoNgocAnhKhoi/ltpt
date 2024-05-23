package app;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import entity.Candidate;
import entity.Position;
import jakarta.persistence.EntityManager;
import service.CandidateServices;

public class RequestHandler {

    private int port;
    private CandidateServices candidateServices;
    private Gson gson = new Gson();
    public RequestHandler(EntityManager entityManager ,int port) {
        this.port = port;
        candidateServices = new CandidateServices(entityManager);
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server ready");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        new Thread(() -> {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

                String request = in.readLine();
                Object response = processRequest(request);
                out.writeObject(response);
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private Object processRequest(String request) {
//        String[] parts = request.split(";");
//        String operation = parts[0];
    	System.out.println("Tín hiệu: " + request);
        try {
            switch (request) {
                case "listCandidatesWithLongestWorking":
                    Map<Candidate, Position> candidateList = candidateServices.listCandidatesWithLongestWorking();
                    return candidateList;
                   
                default:
                    return "Invalid operation";
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}
