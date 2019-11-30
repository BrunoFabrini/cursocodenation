package com.br.codenation.aplicacao.service.impl;

import com.br.codenation.aplicacao.annotation.Metodo;
import com.br.codenation.aplicacao.service.FileService;

import java.io.*;
import java.math.BigDecimal;

public class FileServiceImpl implements FileService {


//    AplicacaoServiceImpl aplicacaoService = new AplicacaoServiceImpl();

//    public AplicacaoServiceImpl getAplicacaoService() {
//        return aplicacaoService;
//    }

    @Override
    @Metodo(text = "Metodo que le o arquivo")
    public void readUsuariosFromFile(String path) throws IOException {

        File usuariosTxt = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(usuariosTxt));

        String fileLines;
        boolean header = true;
        Long id = 1L;
        while ((fileLines = br.readLine()) != null){

            String[] lineAttribute = fileLines.split(";");

            if (header){
                header = false;
                continue;
            }

            if (lineAttribute.length != 7){

                System.out.println("Falha ao ler dados do usuario" + lineAttribute[0]);
                continue;
            }

            //nome;documento;idade;login;senha;empresa;salario
            String nome = lineAttribute[0];
            String documento = lineAttribute[1];
            int idade = Integer.parseInt(lineAttribute[2]);
            String login = lineAttribute[3];
            String senha = lineAttribute[4];
            Long empresaId = Long.parseLong(lineAttribute[5]);
            BigDecimal salario = new BigDecimal(lineAttribute[6]);

            try{
//                aplicacaoService.addUsuario(id, empresaId, nome, documento, idade, login, senha, salario);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            id = id + 1L;
        }
    }

    @Override
    public void readEmpresasFromFile(String path) throws IOException {

        File empresasFile = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(empresasFile));

        String fileLines;
        boolean header = true;
        Long id = 1L;
        while ((fileLines = br.readLine()) != null){

            String[] lineAttribute = fileLines.split(";");

            if (header){
                header = false;
                continue;
            }

            if (lineAttribute.length != 4){

                System.out.println("Falha ao ler dados da empresa " + lineAttribute[0]);
                continue;
            }

            //nome;documento;vagas;site
            String nome = lineAttribute[0];
            String documento = lineAttribute[1];
            int vagas = Integer.parseInt(lineAttribute[2]);
            String site = lineAttribute[3];

//            aplicacaoService.addEmpresa(id, nome, documento, vagas, site);

            id = id + 1L;
        }
    }

//    public void printMediaSalarial(){
//
//        aplicacaoService.printMediaSalarial();
//    }
//
//    public void printValorTotalFolha(){
//
//        aplicacaoService.printValorTotalFolha();
//    }
//
//    public void printEmpresaMenorCusto(){
//
//        aplicacaoService.printEmpresaMenorCusto();
//    }
//
//    public void printMediaIdadeEmpresas(){
//
//        aplicacaoService.printMediaIdadeEmpresas();
//    }
//
//    public void printUsuariosOrderedByIdade(){
//
//        aplicacaoService.printUsuariosOrderedByIdade();
//    }

}
