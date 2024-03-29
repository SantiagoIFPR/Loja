package com.loja.Molina.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImagemController {

	private static String caminhoImagens = "C:\\Users\\Karen Violim\\Pictures\\imagens2\\";
	
	@GetMapping("/mostrarImagem/{imagem}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imagem") String imagem) throws IOException {
		File imagemArquivo = new File(caminhoImagens + imagem);
		if (imagem != null || imagem.trim().length() > 0) {

			return Files.readAllBytes(imagemArquivo.toPath());
		}
		return null;
	}
}
