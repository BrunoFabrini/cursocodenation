package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.service.impl.FileServiceImpl;

public class FileController {

    FileServiceImpl fileService = new FileServiceImpl();

    public void readUsuariosFromFile(String path){

        try{

            fileService.readUsuariosFromFile(path);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public void readEmpresasFromFile(String path){

        try{

            fileService.readEmpresasFromFile(path);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void printEmpresas(){

//        fileService.getAplicacaoService().printEmpresas();
    }

    public void printUsuarios(){

//        fileService.getAplicacaoService().printUsuarios();
    }

    public void printMaiorSalario(){

//        fileService.getAplicacaoService().printMaiorSalario();
    }

    public void printMediaSalarial(){

//        fileService.getAplicacaoService().printMediaSalarial();
    }

    public void printValorTotalFolha(){

//        fileService.getAplicacaoService().printValorTotalFolha();
    }

    public void printEmpresaMenorCusto(){

//        fileService.getAplicacaoService().printEmpresaMenorCusto();
    }

    public void printMediaIdadeEmpresas(){

//        fileService.getAplicacaoService().printMediaIdadeEmpresas();
    }

    public void printUsuariosOrderedByIdade(){

//        fileService.getAplicacaoService().printUsuariosOrderedByIdade();
    }

}
