package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject {

	public LeiloesPage(WebDriver browser) {
		super(browser);
	}
	
	public boolean IsPaginaDeLeiloes() {
		return browser.getCurrentUrl().equals("http://localhost:8089/leiloes");
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to("http://localhost:8089/leiloes/new");
		return new CadastroLeilaoPage(browser);
	}

	public boolean isLeilaoCadastrado(String nome, String valor, String data) {
		WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		return colunaNome.getText().equals(nome) 
				&& colunaValorInicial.getText().equals(valor) 
				&& colunaDataAbertura.getText().equals(data); 
	}

	public boolean isPaginaAtual() {
		
		return browser.getCurrentUrl().equals("http://localhost:8089/leiloes");
	}
	
	

}
