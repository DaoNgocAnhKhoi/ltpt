package app;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Map;

import entity.Candidate;
import entity.Position;

public class Clients {

    public static void main(String[] args) throws Exception {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        InetAddress localHost = InetAddress.getLocalHost();
        String localHostAddress = localHost.getHostAddress();

        try (Socket socket = new Socket(localHostAddress, 8080)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            String line;
            while (true) {
                // Hiển thị menu chọn hoạt động cho người dùng
                System.out.println("Chọn hoạt động:");
                System.out.println("1 - listCandidatesWithLongestWorking (): Map<Candidate, Position>");
                System.out.println("'bye' để thoát");
                line = userInput.readLine();

                if (line.equalsIgnoreCase("bye")) {
                    break; // Thoát nếu người dùng chọn 'bye'
                }

                // Nhập dữ liệu cần thiết cho yêu cầu
                String requestData = "";
                switch (line) {
                    case "1":
                        requestData = "listCandidatesWithLongestWorking";
                        break;
                    default:
                        System.out.println("Yêu cầu không hợp lệ");
                        continue; // Bỏ qua lần lặp hiện tại và tiếp tục vòng lặp
                }

                // Gửi yêu cầu đến máy chủ
                out.writeBytes(requestData + "\n");
                out.flush();

                // Đọc và hiển thị phản hồi từ máy chủ
                Map<Candidate, Position> response = (Map<Candidate, Position>) in.readObject();
//                System.out.println("Phản hồi từ máy chủ: " + response);
                for (Map.Entry<Candidate, Position> entry : response.entrySet()) {
                    System.out.println("Candidate: " + entry.getKey().get_id() + " - Position: " + entry.getValue().getName());
                }

            }

            // Đóng kết nối và thoát
            userInput.close();
            in.close();
            out.close();
        }
    }
}

