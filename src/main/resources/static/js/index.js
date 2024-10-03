document.addEventListener('DOMContentLoaded', () => {

    const API_URL = "/api/v1";

    const BUTTON_INICIAR = document.getElementById('btn-iniciar');
    const CONTAINER_MOVIMENTOS = document.getElementById("container-movimentos");
    const IMG_MAO_JOGADOR = document.getElementById("img-mao-jogador");
    const LABEL_SESSAO = document.getElementById("label-sessao");
    const LABEL_PONTUACAO = document.getElementById("label-pontuacao");
    
    Array.from(document.getElementsByClassName("btn-movimento")).forEach(btn => btn.addEventListener('click', async e => {

        let movimentoSelecionado = e.target.innerHTML.toLowerCase();

        try{
            await fetch(`${API_URL}/jogada`, {
                method: "POST",
                body: movimentoSelecionado
            });

            IMG_MAO_JOGADOR.setAttribute("src", `/imgs/${movimentoSelecionado}Jogador.png`);
        }
        
        catch (err){
            LABEL_SESSAO = "Não foi possível realizar essa jogada."
        }

    }))
    
    BUTTON_INICIAR.addEventListener('click', async (e) => {
        
        LABEL_SESSAO.innerHTML = "Selecione seu movimento";
        LABEL_PONTUACAO.innerHTML = "0-0";
        CONTAINER_MOVIMENTOS.style.display = "flex";
        e.target.style.display = "none";
    
    })
});
