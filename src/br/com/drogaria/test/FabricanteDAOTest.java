package br.com.drogaria.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar() {

		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAO 1");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAO 2");

		Fabricante f3 = new Fabricante();

		FabricanteDAO dao = new FabricanteDAO();

		dao.salvar(f1);
		dao.salvar(f2);
		dao.salvar(f3);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();

		System.out.println(fabricantes);
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um código: ");
		Long codigo = sc.nextLong();
		
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscarPorCodigo(codigo);
		
		System.out.println(fabricante);
	
	}

}
