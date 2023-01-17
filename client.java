import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 63340);

        String conv = "";
        String clientChoice = "";
        PrintWriter pr = new PrintWriter(socket.getOutputStream());

        System.out.print("Player Name: ");
        conv = (new Scanner(System.in)).nextLine();


        pr.println(conv);
        pr.flush();

        System.out.println("---- Rock Paper Scissors Game ---- by Rafid ");
        System.out.println("(1)Rock, (2)Paper, (3)Scissors ---- Type any other number to end the game or type quit");

        while(!conv.toLowerCase().equals("quit")){
            System.out.print("Input: ");
            conv = (new Scanner(System.in)).nextLine();

            //        Sending Message

            pr.println(conv);
            pr.flush();

            if(Integer.parseInt(conv) == 1){
                clientChoice = "Rock";
            }else if(Integer.parseInt(conv) == 2){
                clientChoice = "Paper";
            }else if(Integer.parseInt(conv) == 3){
                clientChoice = "Scissors";
            }else {
                break;
            }

            System.out.println("You have chosen "+clientChoice);

            //        Receiving Message
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("Server have chosen " +str);
            str = bf.readLine();
            System.out.println("Result: " +str);
        }


    }
}
