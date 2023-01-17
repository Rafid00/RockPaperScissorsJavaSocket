import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket( 63340);
        Socket socket = serverSocket.accept();

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str="";
        String computerChoice = "";
        String clientChoice = "";
        String result = "";

        str = bf.readLine();
        System.out.println("Player Name : " +str);

        while(!str.toLowerCase().equals("quit")){
            Random rand = new Random();
            int randomNumber = rand.nextInt(3) + 1;

            if(randomNumber == 1){
                computerChoice = "Rock";
            }else if(randomNumber == 2){
                computerChoice = "Paper";
            }else if(randomNumber == 3){
                computerChoice = "Scissors";
            }else {
                break;
            }

            str = bf.readLine();

            if(Integer.parseInt(str) == 1){
                clientChoice = "Rock";
            }else if(Integer.parseInt(str) == 2){
                clientChoice = "Paper";
            }else if(Integer.parseInt(str) == 3){
                clientChoice = "Scissors";
            }else {
                break;
            }

            System.out.println("Client Have Chosen " +clientChoice);


            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            pr.println(computerChoice);
            pr.flush();

            if(randomNumber == 1 && Integer.parseInt(str)==2){
                pr.println("You Win, Server Lost");
                pr.flush();
            } else if (randomNumber == 2 && Integer.parseInt(str)==3) {
                pr.println("You Win, Server Lost");
                pr.flush();
            }else if (randomNumber == 3 && Integer.parseInt(str)==1) {
                pr.println("You Win, Server Lost");
                pr.flush();
            } else if (randomNumber == Integer.parseInt(str)) {
                pr.println("Draw");
                pr.flush();
            }else {
                pr.println("You Lost, Server Win");
                pr.flush();
            }


        }





    }
}
