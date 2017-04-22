package br.com.froli.sparkstarter;

import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		
		// Exemplo de GET simples
		get("/olamundo", (request, response) -> {
			return "Olá mundo GET!";
		});
		
		// Exemplo de POST simples exibindo o corpo da requisição
		post("/olamundo", (request, response) -> {
	        return "Olá Mundo POST! Corpo: " + request.body();
	    });
		
		// Exemplo com parâmetro
		get("/usuario/:nome", (request, response) -> {
	        return "Nome Informado: " + request.params(":nome");
	    });
		
		// Exemplo redirecionando para uma rota
		get("/redirecionar", (request, response) -> {
	        response.redirect("/olamundo");
	        return null;
	    });
		
		// Define o código de status para 401 Unauthorized (Não Autorizado)
		get("/paginaprivada", (request, response) -> {
	        response.status(401);
	        return "Vocẽ não tem acesso a página solicitada!";
	    });
		
		// Exemplo de halt (para imediatamente a requisição de rota ou filtro) com retorno de status 403 Forbidden (Proibido)
		get("/paginaprotegida", (request, response) -> {
	        halt(403, "Acesso proibido! :(");
	        return null;
	    });
		
	}
}
