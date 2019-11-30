package com.br.codenation.aplicacao;

import com.br.codenation.aplicacao.controller.EmpresaController;
import com.br.codenation.aplicacao.controller.FileController;
import com.br.codenation.aplicacao.domain.entity.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
//@ComponentScan(basePackages = {"br.com.codenation.aplicacao.domain.entity"})
public class AplicacaoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AplicacaoApplication.class, args);

//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aplicacao");
//		factory.close();

//		FileController fileController = new FileController();
		
//		Result result = new Result();
				
//		controller.addUsuario(2L, "Bruno", "17763810", 25, "bruno.fabrini", "senhadobruno");
//		controller.addUsuario(3L, "Fabio", "987654321", 25, "fabio.admin", "senhadofabio");
//		controller.addUsuario(4L, "Cintia", "444555666", 25, "cintia.admin", "senhadacintia");
		
//		controller.addEmpresa(4L, "Codenation", "31472046000137", 3);
//		if (!result.success())
//			printMessage(result.getMessage());
//		
//		result = controller.addEmpresa(5L, "Banco Inter", "123456789", 100);
//		if (!result.success())
//			printMessage(result.getMessage());
//		
//		result = controller.addEmpresa(6L, "UNA - Aimorés", "987654321", 10);
//		if (!result.success())
//			printMessage(result.getMessage());
		
//		result = controller.addUsuario(4L, null, "17763810", 25, "bruno.fabrini", "senhadobruno");
//		if (!result.success())
//			printMessage(result.getMessage());
//		
//		result = controller.addUsuario(5L, "Bruno", "", 25, "bruno.fabrini", "senhadobruno");
//		if (!result.success())
//			printMessage(result.getMessage());
//		
//		result = controller.addUsuario(6L, "Bruno", "17763810", -1, "", "senhadobruno");
//		if (!result.success())
//			printMessage(result.getMessage());
//		
//		result = controller.addUsuario(7L, "Bruno", "17763810", 10, "", "senhadobruno");
//		if (!result.success())
//			printMessage(result.getMessage());
//		
//		result = controller.addUsuario(8L, "Bruno", "17763810", 25, "bruno.fabrini", null);
//		if (!result.success())
//			printMessage(result.getMessage());
//		
//		result = controller.addUsuario(9L, "Bruno", "17763810", 25, "bruno.fabrini", "senhadobruno");
//		if (!result.success())
//			printMessage(result.getMessage());
		
//		controller.addEmpresa(1L, "Codenation", "31472046000137", 3);
//		controller.addEmpresa(2L, "Banco Inter", "123456789", 100);
//		controller.addEmpresa(3L, "UNA - Aimorés", "987654321", 10);
		
//		Result result = controller.addUsuario(1L, 1L, "Thiago", "123456789", 31, "oathiago", "codenation");
//		if (!result.success())
//			printMessage(result.getMessage());
		
//		result = controller.addUsuario(2L, 2L, "Bruno", "17763810", 25, "bruno.fabrini", "senhadobruno");
//		if (!result.success())
//			printMessage(result.getMessage());
		
//		result = controller.addUsuario(2L, 10L, "Bruno", "17763810", 25, "bruno.fabrini", "senhadobruno");
//		if (!result.success())
//			printMessage(result.getMessage());
		
//		controller.findUsuarios(1L, "Thiago", "123456789", 31);
//		controller.findUsuarios(2L, "Bruno", "17763810", 25);

		//Inclusao de empresas
		//Inclusao de usuarios
//		String empresasPath = "/home/bruno/arquivos/empresa.txt";
//		fileController.readEmpresasFromFile(empresasPath);
//		fileController.printEmpresas();

		//Inclusao de empresas
//		String usuariosPath = "/home/bruno/arquivos/usuarios.txt";
//		fileController.readUsuariosFromFile(usuariosPath);
		//fileController.printUsuarios();

//		fileController.printMaiorSalario();
//		fileController.printMediaSalarial();
//		fileController.printValorTotalFolha();
//		fileController.printEmpresaMenorCusto();
//		fileController.printMediaIdadeEmpresas();
//		fileController.printUsuariosOrderedByIdade();

//		EmpresaController empresaController = new EmpresaController();
//		List<Empresa> empresaList = empresaController.getEmpresasListByNome("Empresa 1");
//
//		if (empresaList != null && empresaList.size() > 0){
//
//			System.out.println("Empresa Id: " + empresaList.get(0).getId());
//		}
//		else{
//
//			System.out.println("Empresa nao encontrada!");
//		}

//		System.out.println("Programa finalizado!");
//		return;
	}
	
	//public static void printMessage(String message) {
	//	System.out.println(message);
	//}
}
