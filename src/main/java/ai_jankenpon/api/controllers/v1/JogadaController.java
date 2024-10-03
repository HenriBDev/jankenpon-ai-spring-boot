package ai_jankenpon.api.controllers.v1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1/jogada")
public class JogadaController {
    
    @PostMapping
    public void CriarJogada(@RequestBody() String movimento){
        try{
            System.out.println(movimento);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
