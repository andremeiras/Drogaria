package br.com.drogaria.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	private static Scanner sc;
	private Long codigo;
	private String descricao;

	@Test
	@Ignore
	public void salvar() {
		sc = new Scanner(System.in);

		System.out.print("Digite um fabricante: ");
		String descricao = sc.nextLine();

		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao(descricao);

		FabricanteDAO dao = new FabricanteDAO();

		dao.salvar(fabricante);
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
		System.out.print("Digite um código: ");
		codigo = sc.nextLong();

		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscarPorCodigo(codigo);

		System.out.println(fabricante);
	}

	// Resolvendo com lógica (if else)
	@Test
	@Ignore
	public void excluir() {
		System.out.println("Digite um código: ");
		codigo = sc.nextLong();

		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscarPorCodigo(codigo);

		if (fabricante != null) {
			dao.excluir(fabricante);
		} else {
			System.out.println("Fabricante " + codigo + " não existe");
		}

		// esta forma existe quando não for trabalhar com persistência
//		Fabricante fabricante = new Fabricante();
//		fabricante.setCodigo(codigo);
//
//		FabricanteDAO dao = new FabricanteDAO();
//		dao.excluir(fabricante);

	}

	// Resolvendo com Transação
	@Test
	@Ignore
	public void excluirPorCodigo() {
		System.out.print("Digite um código: ");
		codigo = sc.nextLong();

		FabricanteDAO dao = new FabricanteDAO();

		dao.excluir(codigo);
	}

	@Test
	public void editar() {

		sc = new Scanner(System.in);

		Fabricante fabricante = new Fabricante();
		FabricanteDAO dao = new FabricanteDAO();

		System.out.print("Digite um código: ");
		codigo = sc.nextLong();
		
		dao.buscarPorCodigo(fabricante.getCodigo()).setCodigo(codigo);

		if (fabricante.getCodigo() == null) {
			System.out.println("nem chegou aqui");
			System.out.println(fabricante.getCodigo());
			System.out.println("Fabricante selecionado: " + dao.buscarPorCodigo(fabricante.getCodigo()).getDescricao());
			
			System.out.println("\n");

			System.out.print("Digite a nova descrição: ");
			descricao = sc.nextLine();
			fabricante.setDescricao(descricao);

			dao.editar(fabricante);
		} else 
		{
			System.out.println("ERRO!!!!");
		}
		sc.close();
	}

}
