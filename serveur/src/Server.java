import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Server extends JFrame {
	 //public static final int PORT = 20012;
    public static int port = 20013;
    public static final int MAX_CONNECTION = 21;
    public JTextArea msg;
    public JScrollPane scrollp;

    public Server(){
        super("Server Log");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
        msg = new JTextArea();
        scrollp = new JScrollPane(msg);
        scrollp.setBounds(20, 20, 400, 400);
        msg.setEditable(false);
        scrollp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.getContentPane().setBackground(Color.black);
        this.getContentPane().add(scrollp);
    }

    public static void main(String[] arg) throws IOException, ClassNotFoundException, SQLException{
        ServerSocket serverSocket;
        Server server = new Server();
        PoolConnexion pool = new PoolConnexion();
        pool.start();
        serverSocket = new ServerSocket(port);
        Socket client;
        int i=0;
        while(true){
                server.msg.append("\nWaiting for Connection"+i);
                client = serverSocket.accept();
                Service s = new Service(client,server,i,pool);
                s.start();
                server.msg.append("\nconnection"+"is connected");
                i++;
                }
     
   
    }
}