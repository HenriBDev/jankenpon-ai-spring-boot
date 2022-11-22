package jankenpo_a3.jankenpo_a3;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;

@RestController
public class ClienteController {

    private String HOST_SERVER = "localhost";
    private int PORTA_SERVER = 8080;
    private Socket socketCliente;
    private Socket socketResposta;
    private ServerSocket socketServer;
    private DataOutputStream serverOutput;
    private DataInputStream respostaInput;

    @PostMapping("/conectarJogo")
    public String conectarJogo(){
        try{
            this.socketCliente = new Socket("localhost", 5000);
            this.serverOutput = new DataOutputStream(this.socketCliente.getOutputStream());
            this.serverOutput.writeUTF("Perguntei");
            this.serverOutput.flush();
            this.socketServer = new ServerSocket(5002);
            this.socketResposta = this.socketServer.accept();
            this.respostaInput = new DataInputStream(this.socketResposta.getInputStream());
            String resposta = this.respostaInput.readUTF();
            this.socketResposta.close();
            return resposta;
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    
    @PostMapping("/atualizarTela")
    public String atualizarTela(){
        return "client";
    }

}
