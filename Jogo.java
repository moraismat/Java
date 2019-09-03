
/**
 * Implementa as mecânicas e regras do jogo Ludo.
 *
 * @author Alan Moraes / alan@ci.ufpb.br
 * @author Victor Koehler / koehlervictor@cc.ci.ufpb.br
 */
public class Jogo {
    // Define que o dado nao foi jogado
    private boolean dadoJogado = false;

    private String jogadorVez;
    private int number = 1;

    private int numberVerde = -1;
    private int numberVermelho = -1;
    private int numberAzul = -1;
    private int numberAmarelo = -1;
    private int numberReturn = 0;

    //private String[] vez;
    // Tabuleiro do jogo
    private final Tabuleiro tabuleiro;

    // Dados do jogo.
    private final Dado[] dados;

    /**
     * Construtor padrão do Jogo Ludo.
     * Isto é, um jogo de Ludo convencional com dois dados.
     */
    public Jogo() {
        this(2);
    }

    /**
     * Construtor do Jogo Ludo para inserção de um número arbitrário de dados.
     * @param numeroDados Número de dados do jogo.
     */
    public Jogo(int numeroDados) {

        this.tabuleiro = new Tabuleiro();
        this.dados = new Dado[numeroDados];

        for (int i = 0; i < this.dados.length; i++) {
            // remover parâmetro do construtor para dado não batizado
            this.dados[i] = new Dado(i);
        }

        inicializaJogo();
    }

    /**
     * Construtor do Jogo Ludo para inserção de dados arbitrários.
     * Útil para inserir dados "batizados" e fazer testes.
     * @param dados Dados
     */
    public Jogo(Dado[] dados) {
        this.tabuleiro = new Tabuleiro();
        this.dados = dados;
        assert dados.length > 0; // TO BE REMOVED

        inicializaJogo();
    }

    private void inicializaJogo() {
        // AQUI SUGERE-SE QUE SE INSIRA A INICIALIZAÇÃO DO JOGO
        // ISTO É, A INSERÇÃO DAS PEÇAS NO TABULEIRO E AS DEFINIÇÕES DOS CAMPOS
        // SE NECESSÁRIO, MODIFIQUE A ASSINATURA DO MÉTODO

        //
        // TRECHO DE EXEMPLO
        //

        // Vamos inicializar a guarita verde colocando as 4 peças do jogador verde nela.
        //
        // Guarita = espaço onde fica as peças fora do jogo;
        // Consulte a imagem "referencia.png" acompanhada na pasta dessa classe.
        Guarita guarita;
        //Cria as peças dentro da guarita
        guarita = tabuleiro.getGuarita("VERDE");
        for (Casa casaGuarita : guarita.obterTodasAsCasas()) {
            Peca novaPeca = new Peca("VERDE");
            novaPeca.mover(casaGuarita);
        }
        guarita = tabuleiro.getGuarita("AMARELO");
        for (Casa casaGuarita : guarita.obterTodasAsCasas()) {
            Peca novaPeca = new Peca("AMARELO");
            novaPeca.mover(casaGuarita);
        }
        guarita = tabuleiro.getGuarita("AZUL");
        for (Casa casaGuarita : guarita.obterTodasAsCasas()) {
            Peca novaPeca = new Peca("AZUL");
            novaPeca.mover(casaGuarita);
        }
        guarita = tabuleiro.getGuarita("VERMELHO");
        for (Casa casaGuarita : guarita.obterTodasAsCasas()) {
            Peca novaPeca = new Peca("VERMELHO");
            novaPeca.mover(casaGuarita);
        }

        // Obtemos uma das peças verdes que inicializamos logo acima para usa-la como exemplo.
        // Movemos ela para a casa de inicio do jogador verde.
        //Casa casaGuarita;
        //Casa casaInicio;
        //Peca peca;

        //guarita = tabuleiro.getGuarita("AZUL");
        //casaGuarita = guarita.getCasa(0);
        //peca = casaGuarita.getPeca();
        //casaInicio = tabuleiro.getCasaInicio("AZUL");
        //peca.mover(casaInicio);

        //guarita = tabuleiro.getGuarita("VERDE");
        //casaGuarita = guarita.getCasa(0);
        //peca = casaGuarita.getPeca();
        //casaInicio = tabuleiro.getCasaInicio("VERDE");
        //peca.mover(casaInicio);

        //guarita = tabuleiro.getGuarita("VERMELHO");
        //casaGuarita = guarita.getCasa(0);
        //peca = casaGuarita.getPeca();
        //casaInicio = tabuleiro.getCasaInicio("VERMELHO");
        //peca.mover(casaInicio);

        // Apenas como um exemplo adicional, colocamos uma peça azul no tabuleiro. 

        //
        // TRECHO DE EXEMPLO
        //
    }    

    /**
     * Método invocado pelo usuário através da interface gráfica ou da linha de comando para jogar os dados.
     * Aqui deve-se jogar os dados e fazer todas as verificações necessárias.
     */
    public void rolarDados() {

        // AQUI SE IMPLEMENTARÁ AS REGRAS DO JOGO.
        // TODA VEZ QUE O USUÁRIO CLICAR NO DADO DESENHADO NA INTERFACE GRÁFICA,
        // ESTE MÉTODO SERÁ INVOCADO.

        //
        // TRECHO DE EXEMPLO
        //

        /*Pergunta se o dado foi jogado.
         * Caso o dado nao seja jogado, rolar os dados.
         * 
         */if(dadoJogado == false){
            // Aqui percorremos cada dado para lançá-lo individualmente.
            for (Dado dado : dados) {
                dado.rolar();
                //Dado foi jogado.
                dadoJogado = true;
            }

        }
    }

    /**
     * Método invocado pelo usuário através da interface gráfica ou da linha de comando quando escolhida uma peça.
     * Aqui deve-se mover a peça e fazer todas as verificações necessárias.
     * @param casa Casa escolhida pelo usuário/jogador.
     */
    public void escolherCasa(Casa casa) {
        if(dadoJogado == true){
            // AQUI SE IMPLEMENTARÁ AS REGRAS DO JOGO.
            // TODA VEZ QUE O USUÁRIO CLICAR EM UMA CASA DESENHADA NA INTERFACE GRÁFICA,
            // ESTE MÉTODO SERÁ INVOCADO.

            //
            // TRECHO DE EXEMPLO
            //

            // Perguntamos à casa se ela possui uma peça. 
            // Se não possuir, não há nada para se fazer.
            if (!casa.possuiPeca()) {
                return;
            }

            // Perguntamos à casa qual é a peça.
            Peca peca = casa.getPeca();

            // Percorremos cada dado, somando o valor nele à variável somaDados.
            int somaDados = 0;
            for (Dado dado : dados) {
                somaDados += dado.getValor();
            }
            //Verifica se a peça clicada eh da mesma cor que o jogador da vez.
            if(verificarTurno(number) == peca.obterCor()){ 
                // Percorreremos N casas.
                Casa proximaCasa = casa;
                //Criando booleano e definindo ele como true. 
                boolean indoFrente = true;

                for (int i = 0; i < somaDados && proximaCasa != null; i++) {

                    /*Pergunta se a proxima casa eh a casa final.
                     * Caso seja, indoFrente eh false.
                     * Senao, eh falso.
                     */ 
                    if(proximaCasa.ehCasaFinal() ){
                        indoFrente = false;
                    }
                    else if(proximaCasa.getCasaAnterior() == null){
                        indoFrente = true;
                    }
                    /* Pergunta se o jogador dentro da casasegura esta indo para frente.
                     * Caso nao, ele esta voltando
                     * 
                     */
                    if(indoFrente == true){
                        proximaCasa = proximaCasa.qualEhCasa(peca);
                    }
                    else if(indoFrente == false && casa.getQuantidadePecas() == 0){
                        proximaCasa = proximaCasa.getCasaAnterior();
                    }

                }

                if (proximaCasa != null) {
                    // Finalmente, a variável casaN contém a casa que a peça deve ser inserida.

                    // Define a peca que esta na casa que os dados corresponde.
                    Peca pecaMorta = proximaCasa.getPeca();
                    // Pergunta se a casa possivel peca.
                    // No caso, possui.
                    if(pecaMorta != null){
                        // Pergunta se a peca eh a mesma peca do jogador da vez.
                        if(pecaMorta.obterCor().equals(peca.obterCor())){
                            //Verifica se a proxima casa eh a final.
                            if(proximaCasa.ehCasaFinal()){
                                proximaCasa.setPeca(peca);
                            }
                            // Nao eh casa final, jogador perde a vez.
                            else{
                                dadoJogado = false;
                                return;
                            }

                        }
                        // Nao eh da mesma cor, jogador come a peca do outro jogador e esta retorna para guarita.
                        if(!pecaMorta.obterCor().equals(peca.obterCor())){
                            retornarGuarita(pecaMorta);
                        }
                    }
                    peca.mover(proximaCasa);

                }
                else {

                    // Verifica se a os dados sao iguais.
                    if(dados[0].getValor() == (dados[1].getValor())) {
                        // Pergunta se a casa pertence a guarita, se sim a peca sai da guarita.
                        if (casa.pertenceGuarita()){
                            // Metodo utilizado para tirar peca da guarita.
                            tirarDaAguarita(peca, contadorGuarita(peca));
                        }
                    }
                }
                // define dado como nao jogado, chama metodo dadosIguais e verifica o turno.
                dadoJogado = false;
                dadosIguais();
                verificarTurno(number);
            }
        }
    }

    /*  Verifica o turno do jogado.
     *  Cada numero eh atribuido a uma cor.
     *  retorna uma string com o nome da cor do jogador.
     */
    public String verificarTurno(int number){
        if(number == 1){
            jogadorVez = "VERDE";

        }
        if(number == 2){

            jogadorVez = "VERMELHO";
        }
        if(number == 3){

            jogadorVez = "AZUL";
        }
        if(number == 4){
            jogadorVez = "AMARELO";
        }
        return jogadorVez;
    }

    /* 
     * Metodo utilizado para retornar a peca a guarita.
     * Recebe uma peca e devolve para guarita.
     */
    public void retornarGuarita(Peca peca){
        Guarita guarita = tabuleiro.getGuarita(peca.obterCor());
        Casa[] casas = guarita.obterTodasAsCasas();

        for(Casa casaNaGuarita : casas)
        {
            if(casaNaGuarita.getPeca() == null)
            {
                peca.mover(casaNaGuarita);
            }
        }   
    }

    /*
     * Metodo usado para tirar peca da guarita.
     */
    public void tirarDaAguarita(Peca peca, int number){
        Casa casaGuarita;
        Casa casaInicio;
        Guarita guarita;
        guarita = tabuleiro.getGuarita(peca.obterCor());
        casaGuarita = guarita.getCasa(number);
        peca = casaGuarita.getPeca();
        casaInicio = tabuleiro.getCasaInicio(peca.obterCor());
        if(casaInicio.possuiPeca()){
            if(casaInicio.getPeca().obterCor().equals(peca.obterCor())){
                return;
            }
            else{

                Peca outra = casaInicio.getPeca();
                retornarGuarita(outra);
                peca.mover(casaInicio);
            }
        }
        else{
            peca.mover(casaInicio);
        }
    }

    //Conta a posiçao das peças na guarita
    public int contadorGuarita(Peca peca){
        if(peca.obterCor().equals("VERDE")){
            numberVerde += 1;
            if(numberVerde > 3){
                numberVerde = 0;
            }
            numberReturn = numberVerde;
        }
        else if(peca.obterCor().equals("VERMELHO")){
            numberVermelho += 1;
            if(numberVermelho > 3){
                numberVermelho = 0;
            }
            numberReturn = numberVermelho;
        }
        else if(peca.obterCor().equals("ARMARELO")){
            numberAmarelo += 1;
            if(numberAmarelo > 3){
                numberAmarelo = 0;
            }
            numberReturn = numberAmarelo;

        }
        else if(peca.obterCor().equals("AZUL")){
            numberAzul += 1;
            if(numberAzul > 3){
                numberAzul = 0;
            }
            numberReturn = numberAzul;
        }
        return numberReturn;
    }

    /*
     * Metodo utilizado para verificar se os dados sao iguais.
     * Caso sejam, o jogador joga novamente.
     * Caso nao, incrementa mais, e eh a vez do outro jogador.
     * OBS: Ao passa a vez do jogador AMARELO(4), retorna para o verde(1);
     */
    public int dadosIguais(){
        int dadosiguais[] = new int[2];
        for(int i = 0; i <= 1; i++){
            dadosiguais[i] = dados[i].getValor();
        }
        if(dadosiguais[0] == dadosiguais[1]){
        number = number;
        }
        else{
        if(number != 4){
        number += 1;
        }
        else{
        number = 1;
        }
        }
        return number;
    }

    /**
     * Retorna o jogador que deve jogar os dados ou escolher uma peça.
     * @return Cor do jogador.
     */
    public String getJogadorDaVez() {

        return jogadorVez;
    }

    /**
     * O tabuleiro deste jogo.
     * @return O tabuleiro deste jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    /**
     * Retorna o i-ésimo dado deste jogo entre 0 (inclusivo) e N (exclusivo).
     * Consulte obterQuantidadeDeDados() para verificar o valor de N
     * (isto é, a quantidade de dados presentes).
     * @param i Indice do dado.
     * @return O i-ésimo dado deste jogo.
     */
    public Dado getDado(int i) {
        return dados[i];
    }

    /**
     * Obtém a quantidade de dados sendo usados neste jogo.
     * @return Quantidade de dados.
     */
    public int getQuantidadeDados() {
        return dados.length;
    }
}
