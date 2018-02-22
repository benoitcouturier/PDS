import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.SwingUtilities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControllerAuthentification {
	private ViewA view  ;
	private EventHandler<ActionEvent> ac;
    private Socket socket;
    private BufferedReader in;
    private PrintStream out;
    private View view2;

public ControllerAuthentification(ViewA view2, Socket client2,View a) {
	// TODO Auto-generated constructor stubge
	this.view=view2;
	this.socket=client2;
	this.view2=a;
}
public void control() throws IOException{
	
	ac = e1 -> {
		try{
			System.out.println("clic sur button");
			out = new PrintStream(socket.getOutputStream());
			String compte = view.getLogin().getText();
            String password = String.valueOf(view.getPass().getText());
			out.println(compte);
			out.flush();
			out.println(password);
			out.flush();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	     	String res ;
			res= in.readLine();
			if (res.equals("true")) {
				System.out.print("good");
				view2 = new View();
				view2.getStage1().show();
				ControllerView controlview = new ControllerView(view2,in,out,socket);
				controlview.Control();
			}
			else {
				System.out.println("not good");
			}
	     	System.out.println(res);
	     	}catch(Exception e2) {
	     		
	     	}
		
		
		
		
	};view.getValide().setOnAction(ac);
	
	
		


	
}
}






