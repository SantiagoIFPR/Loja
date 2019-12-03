package com.loja.Molina.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loja.Molina.Model.Marca;
import com.loja.Molina.Repository.MarcaRepository;

@Controller
public class MarcaController {

	@Autowired
	private MarcaRepository repositoryMarca;

	@GetMapping("administrativo/marcas/cadastrar")
	public ModelAndView add(Marca marca) {
		ModelAndView mv = new ModelAndView("/administrativo/marcas/cadastro");
		mv.addObject("marca", marca);
		return mv;
	}

	@GetMapping("administrativo/marcas/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/marcas/lista");
		mv.addObject("marca", repositoryMarca.findAll());
		return mv;
	}

	@GetMapping("administrativo/marcas/editarMarca/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Marca> op = repositoryMarca.findById(id);
		Marca m = op.get();
		return add(m);
	}

	@GetMapping("administrativo/marcas/removerMarca/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Marca> op = repositoryMarca.findById(id);
		Marca m = op.get();
		repositoryMarca.delete(m);
		return listar();
	}

	@PostMapping("administrativo/marcas/salvarMarca")
	public ModelAndView salvar(Marca marca) {
		repositoryMarca.save(marca);
		return listar();
	}

}
