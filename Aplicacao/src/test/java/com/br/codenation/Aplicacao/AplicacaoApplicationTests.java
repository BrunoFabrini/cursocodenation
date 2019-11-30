package com.br.codenation.Aplicacao;

import com.br.codenation.aplicacao.annotation.Metodo;
import com.br.codenation.aplicacao.domain.dao.EmpresaDAO;
import com.br.codenation.aplicacao.domain.entity.Empresa;
import com.br.codenation.aplicacao.service.EmpresaService;
import com.br.codenation.aplicacao.service.impl.EmpresaServiceImpl;
import com.br.codenation.aplicacao.service.impl.FileServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

@SpringBootTest(classes = FileServiceImpl.class)
class AplicacaoApplicationTests {

//	@Autowired
//	EmpresaService empresaService;

	@Test
	void contextLoads() {

	}

	@Test
	void testePersonaliado(){
//		FileServiceImpl service = new FileServiceImpl();
//
//			for (Method declaredMethod : service.getClass().getDeclaredMethods()){
//
//				if (declaredMethod.getAnnotation(Metodo.class) != null){
//
//					//System.out.println(declaredMethod.getAnnotation(Metodo.class).text());
//					assertEquals("Metodo que le oXX arquivo" , declaredMethod.getAnnotation(Metodo.class).text());
//				}
//			}
	}

	@Test
	void testeGetEmpresaByNome(){

//		List<Empresa> empresaList = empresaService.getEmpresasListByNome("Empresa 1");
//
//		if (empresaList != null && empresaList.size() > 0){
//
//			assertEquals(1, empresaList.get(0).getId());
//			System.out.println("Empresa Id: " + empresaList.get(0).getId());
//		}
//		else{
//
//			System.out.println("Empresa nao encontrada!");
//		}
//
//		System.out.println("Teste finalizado!");
	}
}
