package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject {

	public LoginPage() {
		super(null);
		browser.navigate().to("http://localhost:8089/login");
	}

	public void preencheCamposDeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage submeterLogin() {
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}

	public boolean IsPaginaDeLogin() {
		return browser.getCurrentUrl().equals("http://localhost:8089/login");
	}
	
	public boolean IsPaginaDeLoginComError() {
		return browser.getCurrentUrl().equals("http://localhost:8089/login?error");
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();			
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void navegaParaPaginaLances() {
		browser.navigate().to("http://localhost:8089/leiloes/2");
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

}
