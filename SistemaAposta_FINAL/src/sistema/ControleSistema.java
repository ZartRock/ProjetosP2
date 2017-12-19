package sistema;

import java.util.ArrayList;

public class ControleSistema {

	private ArrayList<Cenario> cenarios;
	private Financas financeiro;


	public ControleSistema(double porcetagemCasa, int caixaAtual){
		this.cenarios = new ArrayList<Cenario>();
		this.financeiro = new Financas(porcetagemCasa, caixaAtual);
	}
	
	public int getCaixaAtual(){ return (int)(this.financeiro.getCaixaAtualCentavos()); }
	
	public void cadastrarCenario(String descricaoCenario){
		this.cenarios.add(new Cenario(descricaoCenario));
	}
	
	public int getNumCenario(String descricaoCenario){
		for (int i = 0; i < this.cenarios.size(); i++) {
			if (this.cenarios.get(i).getDescricao().equals(descricaoCenario)) {
				return i;
			}
		}
		
		throw new IndexOutOfBoundsException("Numerador de cenario não existente");
	}
	
	public boolean adicionarApostaCenario(int numFornecidoUsuario, String nomeApostador, double qtnAposta, String previsaoString){
		String[] mensagensExcecoes = {"Erro no cadastro de aposta: Cenario invalido",
							  		  "Erro no cadastro de aposta: Cenario nao cadastrado"};

	    tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes, false);

		int numCenario = numFornecidoUsuario - 1;
	    Aposta aposta = new Aposta(nomeApostador, qtnAposta, previsaoString);

	    this.cenarios.get(numCenario).adicionarAposta(aposta);
		return true;
	}
	
	public String exibirCenario(int numFornecidoUsuario){
		String[] mensagensExcecoes = {"Erro na consulta de cenario: Cenario invalido",
				                      "Erro na consulta de cenario: Cenario nao cadastrado"};

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes, false);

        int numCenario = numFornecidoUsuario - 1;
	    return this.cenarios.get(numCenario).toString(numFornecidoUsuario);
	}
	
	public String exibirTodosCenarios(){
		String saida = "";
		for (int i = 0; i < this.cenarios.size(); i++) {
			saida += this.cenarios.get(i).toString(i);
		}
		
		return saida;
	}

	public int retornarNumApostaCenario(int numFornecidoUsuario){
		String[] mensagensExcecoes = {"Erro na consulta do total de apostas: Cenario invalido",
							          "Erro na consulta do total de apostas: Cenario nao cadastrado"};

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes, false);

		int numCenario = numFornecidoUsuario - 1;
	    return this.cenarios.get(numCenario).getNumApostas();
    }

    public String exibirApostas(int numFornecidoUsuario){
		return this.cenarios.get(numFornecidoUsuario - 1).exibeApostas();
    }

    public int retornarValorTotalApostas(int numFornecidoUsuario){
		String[] mensagensExcecoes = {"Erro na consulta do valor total de apostas: Cenario invalido",
                                      "Erro na consulta do valor total de apostas: Cenario nao cadastrado"};

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes, false);

	
	    return (int) this.cenarios.get(numFornecidoUsuario - 1).getValorTotalApostas();
    }

    public int getCaixaCenario(int numFornecidoUsuario){
		String[] mensagensExcecoes = {"Erro na consulta do caixa do cenario: Cenario invalido",
				"Erro na consulta do caixa do cenario: Cenario nao cadastrado"};

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes, false);
		int numCenario = numFornecidoUsuario - 1;

		Cenario cenario = this.cenarios.get(numCenario);

		if (!cenario.getEstaTerminado()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}

		return cenario.valorRecolhido() / 100;
	}


    public void fecharAposta(int numFornecidoUsuario, boolean ocorreu){
		String[] mensagensExcecoes = {"Erro ao fechar aposta: Cenario invalido",
				"Erro ao fechar aposta: Cenario nao cadastrado",
                "Erro ao fechar aposta: Cenario ja esta fechado"};

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes, true);

		int numCenario = numFornecidoUsuario - 1;
		Cenario cenario = this.cenarios.get(numCenario);

        if (cenario.getEstaTerminado()) {
            throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
        }

        cenario.setResultadoCenario(ocorreu);
		int valorParaCaixa = (int)(cenario.valorRecolhido() * this.financeiro.getPorcetagemCasa());

		this.financeiro.adicionarValorCaixa(valorParaCaixa);
    }


    public int getTotalRateioCenario(int numFornecidoUsuario){
		String[] mensagensExcecoes = {
		            "Erro na consulta do total de rateio do cenario: Cenario invalido",
                    "Erro na consulta do total de rateio do cenario: Cenario nao cadastrado",
                    "Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto" };

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes, false);

        int numCenario = numFornecidoUsuario - 1;

		Cenario cenario = this.cenarios.get(numCenario);


		double valorCentavos =  Math.floor((cenario.valorRecolhido() - cenario.valorRecolhido() * financeiro.getPorcetagemCasa()));

		return (int) valorCentavos;
	}

	public void fecharCenario(int numFornecidoUsuario, boolean resultadoCenario){
        String[] mensagensExcecoes = {"Erro ao fechar aposta: Cenario invalido",
                                      "Erro ao fechar aposta: Cenario nao cadastrado"};

        tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes, false);
        int numCenario = numFornecidoUsuario - 1;
        Cenario cenarioEscolhido = this.cenarios.get(numCenario);

        cenarioEscolhido.setResultadoCenario(resultadoCenario);
        int valor = (int)(cenarioEscolhido.valorRecolhido() * this.financeiro.getPorcetagemCasa());
        this.financeiro.adicionarValorCaixa(valor);

    }


	private void tratarErroSelecionarCenario(int numFornecidoUsuario, String[] mensagens, boolean esperadoLancarExcessao){
		tratarErrosCenarioInvalido(numFornecidoUsuario, mensagens[0]);
		tratarErrosCenarioNaoCadastrado(numFornecidoUsuario, mensagens[1]);
		if (mensagens.length > 3){

		    tratarErrosCenariosTerminados(numFornecidoUsuario,mensagens[2],esperadoLancarExcessao);
        }
	}


	private void tratarErrosCenarioInvalido(int numFornecidoUsuario, String mensagem){
		if (numFornecidoUsuario < 1){
			throw new IllegalArgumentException(mensagem);
		}
	}

	private void tratarErrosCenarioNaoCadastrado(int numFornecidoUsuario, String mensagem){
		if (numFornecidoUsuario > this.cenarios.size()){
			throw new IllegalArgumentException(mensagem);
		}
	}


	private void tratarErrosCenariosTerminados(int numFornecidoUsuario, String mensagem, boolean esperado){
        Boolean cenarioAlvo =  this.cenarios.get(numFornecidoUsuario + 1).getEstaTerminado();
	    if (!esperado){
            cenarioAlvo = !cenarioAlvo;
        }

        if (cenarioAlvo){
	        throw new IllegalArgumentException(mensagem);
        }


    }
}
