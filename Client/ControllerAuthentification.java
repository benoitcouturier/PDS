package Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControllerAuthentification {
	private ViewA view  ;
	private EventHandler<ActionEvent> eh;
    private Socket socket;
    private BufferedReader in;
    private PrintStream out;
    private View view2;

    public ControllerAuthentification(ViewA view2, Socket client2,View a) {
		this.view=view2;
		this.socket=client2;
		this.view2=a;
    }
    
    public void control() throws IOException {
		eh = e1 -> {
			try {
				System.out.println("click on button");
				out = new PrintStream(socket.getOutputStream());
				String compte = view.getLogin().getText();
	            String password = String.valueOf(view.getPass().getText());
				out.println(compte);
				out.flush();
				out.println(password);
				out.flush();
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String res = in.readLine();
				if (res.equals("true")) {
					System.out.print("good");
					view2 = new View();
					view2.getStage1().show();
					ControllerView controlview = new ControllerView(view2, in, out);
					controlview.Control();
				} else
					System.out.println("not good");
		     } catch (Exception e) {
		     	e.printStackTrace();	
		     }
		};
		view.getSign().setOnAction(eh);
	}
}