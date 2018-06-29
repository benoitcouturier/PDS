import java.awt.Color;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Server extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int port = 20013;
    private JTextArea msg;
    private JScrollPane scrollp;
    
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

    

    public static void main(String[] arg) throws IOException, ClassNotFoundException, SQLException {
    	
        Server server = new Server();
        server.msg.append("\nAUTHENTIFICATION  with ");
        PoolConnexion pool = new PoolConnexion();
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            Runnable worker = new ConnectionThread(serverSocket,server,pool);
            executor.execute(worker); 
          }
    }
    
    public JTextArea getMsg() {
    	return msg;
    }
}