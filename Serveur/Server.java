package Serveur;
import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Server extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static int port = 20013;
    private JTextArea textField;
    private JScrollPane scrollp;

    public Server() {
        super("Server Log");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
        textField = new JTextArea();
        scrollp = new JScrollPane(textField);
        scrollp.setBounds(20, 20, 400, 400);
        textField.setEditable(false);
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
        while (true) {
            server.textField.append("\nWaiting for Connection"+i);
            client = serverSocket.accept();
            Service s = new Service(client,server,i,pool);
            s.start();
            server.textField.append("\nconnection"+"is connected");
            i++;
        }
    }
    
    public JTextArea getTextField() {
    	return this.textField;
    }
}