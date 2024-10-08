document.addEventListener('DOMContentLoaded', () => {

    // CONSTANTES
    const API_URL = "/api/v1";

    // ENUMS
    const MOVIMENTO_ENUM = ["PEDRA", "PAPEL", "TESOURA"]

    // DOM
    const BUTTON_INICIAR = document.getElementById('btn-iniciar');
    const CONTAINER_MOVIMENTOS = document.getElementById("container-movimentos");
    const IMG_MAO_JOGADOR = document.getElementById("img-mao-jogador");
    const IMG_MAO_OPONENTE = document.getElementById("img-mao-oponente");
    const LABEL_SESSAO = document.getElementById("label-sessao");
    const LABEL_PONTUACAO = document.getElementById("label-pontuacao");
    
    Array.from(document.getElementsByClassName("btn-movimento")).forEach(btn => btn.addEventListener('click', async e => {

        let movimentoSelecionado = e.target.innerHTML.toUpperCase();

        if(!MOVIMENTO_ENUM.includes(movimentoSelecionado)){
            LABEL_SESSAO.innerHTML = "Movimento inválido.";
            return;
        }

        try{
            let response = await fetch(`${API_URL}/sessao/rodadas`, {
                method: "PATCH",
                body: JSON.stringify({
                    sessaoId: localStorage.getItem("sessaoId"),
                    movimento: movimentoSelecionado
                }),
                headers: {
                    "Content-Type": "application/json",
                },
            });

            let responseBody = await response.json();

            let movimentoCPU = responseBody.dados.movimentoCPU;
            let resultadoRodada = responseBody.dados.resultadoRodada

            IMG_MAO_JOGADOR.setAttribute("src", `/imgs/${movimentoSelecionado}Jogador.png`);
            IMG_MAO_OPONENTE.setAttribute("src", `/imgs/${movimentoCPU.toLowerCase()}Oponente.png`);

            let pontuacaoQuebrada = LABEL_PONTUACAO.innerHTML.split("-");
            switch(resultadoRodada){

                case "VENCEU":
                    LABEL_PONTUACAO.innerHTML = (parseInt(pontuacaoQuebrada[0]) + 1) + "-" + pontuacaoQuebrada[1]
                    LABEL_SESSAO.innerHTML = "Você ganhou a rodada!";
                break;

                case "PERDEU":
                    LABEL_PONTUACAO.innerHTML = pontuacaoQuebrada[0] + "-" + (parseInt(pontuacaoQuebrada[1]) + 1)
                    LABEL_SESSAO.innerHTML = "O oponente ganhou a rodada.";
                break;

                case "EMPATOU":
                    LABEL_SESSAO.innerHTML = "Empate nessa rodada.";
                break;

            }
        }
        
        catch (err){
            LABEL_SESSAO.innerHTML = "Não foi possível realizar essa Rodada.";
        }

    }))
    
    BUTTON_INICIAR.addEventListener('click', async (e) => {

        try{
            let response = await fetch(`${API_URL}/sessao`, {
                method: "POST",
            });

            let responseBody = await response.json();

            localStorage.setItem("sessaoId", responseBody.dados.sessao);

            LABEL_SESSAO.innerHTML = "Selecione seu movimento";
            LABEL_PONTUACAO.innerHTML = "0-0";
            CONTAINER_MOVIMENTOS.style.display = "flex";
            e.target.style.display = "none";
        }
        
        catch (err){
            LABEL_SESSAO.innerHTML = "Não foi possível iniciar o jogo.";
        }
    
    })
});
