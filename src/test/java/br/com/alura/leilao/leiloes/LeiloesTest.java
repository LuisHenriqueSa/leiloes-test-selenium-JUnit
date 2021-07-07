package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage  paginaDeCadastro;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheCamposDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.submeterLogin();
		paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
	}
	
	@AfterEach
	public void fecharNavegador() {
		paginaDeLeiloes.fechar();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";
		paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	public void validarCadastroDeLeilao() {
		paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
		
		Assert.assertFalse(paginaDeCadastro.isPaginaAtual()); 
		Assert.assertTrue(paginaDeLeiloes.isPaginaAtual()); 
		Assert.assertTrue(paginaDeCadastro.isMensagensDeValidacaoVisiveis()); 
		
	}
	
}
