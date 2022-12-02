package jankenpo_a3.jankenpo_a3;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/conectarJogo")
    public String conectarJogo(){
        try{
            this.socketCliente = new Socket(IP_SERVER, PORTA_SERVER);
            this.serverOutput = new DataOutputStream(this.socketCliente.getOutputStream());
            this.respostaInput = new DataInputStream(this.socketCliente.getInputStream());
            this.serverOutput.writeUTF("Conectar");
            this.serverOutput.flush();
            return this.respostaInput.readUTF();
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/decidirVencedor")
    public String decidirVencedor(){
        try{
            this.serverOutput.writeUTF("Decidir Vencedor");
            this.serverOutput.flush();
            return this.respostaInput.readUTF();
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    
    @PostMapping("/atualizarMovimento")
    public void atualizarTela(@RequestParam("movimento") String movimento){
        try{
            this.serverOutput.writeUTF("Atualizar Movimento " + movimento);
            this.serverOutput.flush();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
