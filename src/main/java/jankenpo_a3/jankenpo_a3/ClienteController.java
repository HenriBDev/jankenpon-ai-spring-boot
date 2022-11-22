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
    private int PORTA_SERVER = 8081;
    private int PORTA_CLIENTE = 8000;
    private String HOST_CLIENTE = "localhost";
    private Socket socketCliente;
    private Socket socketResposta;
    private ServerSocket socketServer;
    private DataOutputStream serverOutput;
    private DataInputStream respostaInput;

    @PostMapping("/conectarJogo")
    public String conectarJogo(){
        try{
            this.socketCliente = new Socket("localhost", PORTA_SERVER);
            this.serverOutput = new DataOutputStream(this.socketCliente.getOutputStream());
            this.serverOutput.writeUTF("Conexão");
            this.serverOutput.flush();
            this.socketServer = new ServerSocket(PORTA_CLIENTE);
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
