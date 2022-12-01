package jankenpo_a3.jankenpo_a3;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;

@RestController
public class ClienteController {

    private String IP_SERVER = "localhost";
    private int PORTA_SERVER = 8081;
    private Socket socketCliente;
    private DataOutputStream serverOutput;
    private DataInputStream respostaInput;
    private String resposta;

    @PostMapping("/conectarJogo")
    public String conectarJogo(){
        try{
            this.socketCliente = new Socket(IP_SERVER, PORTA_SERVER);
            this.serverOutput = new DataOutputStream(this.socketCliente.getOutputStream());
            this.serverOutput.writeUTF("Conexão");
            this.serverOutput.flush();
            this.respostaInput = new DataInputStream(this.socketCliente.getInputStream());
            this.resposta = this.respostaInput.readUTF();
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
