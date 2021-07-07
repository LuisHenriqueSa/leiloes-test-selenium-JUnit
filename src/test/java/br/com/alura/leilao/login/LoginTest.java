package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforEach() {
		paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void fecharNavegador() {
		paginaDeLogin.fechar();
	}
	
	@Test
	public void efetuarLoginComDadosValidos() {
		paginaDeLogin.preencheCamposDeLogin("fulano", "pass");
		paginaDeLogin.submeterLogin();
		
		Assert.assertFalse(paginaDeLogin.IsPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
	}
	
	@Test
	public void naoEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.preencheCamposDeLogin("invalido", "passInvalido");
		paginaDeLogin.submeterLogin();
		
		Assert.assertTrue(paginaDeLogin.IsPaginaDeLoginComError());
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}
	
	@Test
	public void naoAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.navegaParaPaginaLances();
		
		Assert.assertTrue(paginaDeLogin.IsPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}
}
