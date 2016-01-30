package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	
	private final JdbcTarefaDao dao;
	@Autowired
	public TarefasController(JdbcTarefaDao dao){
		this.dao = dao;
	}

	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adicionaTarefa(@Valid Tarefa tarefa, BindingResult result ){
		
		if(result.hasFieldErrors("descricao")){
			return "tarefa/formulario";
		}
		
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("/listaTarefas")
	public String listaTarefas(Model model){
		
		List<Tarefa> lista = dao.lista();
		model.addAttribute("tarefas", lista);
		return "tarefa/listaTarefas";
	}
	
	@RequestMapping("/removeTarefa")
	@ResponseBody
	public String removeTarefa(Tarefa tarefa){
		
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("/removeAgora")
	@ResponseBody
	public void removeAgora(long id){
		Tarefa tar = new Tarefa();
		tar.setId(id);
		String saida = removeTarefa(tar);
	}
	
	@RequestMapping("/mostraTarefa")
	public String mostraTarefa(long id, Model model){
		
		model.addAttribute("tarefa", dao.buscaPorId(id));
		
		return "tarefa/mostra";
	}
	
	@RequestMapping("/alterarTarefa")
	public String alterarTarefa(Tarefa tarefa){
		
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("/finalizaTarefa")
	@ResponseBody
	public void finaliza(Long id){
		
		dao.finaliza(id);
	}
}
