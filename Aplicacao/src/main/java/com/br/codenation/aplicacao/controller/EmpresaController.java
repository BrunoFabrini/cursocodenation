package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.data.EmpresaDTO;
import com.br.codenation.aplicacao.domain.entity.Empresa;
import com.br.codenation.aplicacao.exception.CodenationException;
import com.br.codenation.aplicacao.service.EmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/empresa")
@Api(value = "Empresa Controller")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping("/save")
    @ApiOperation(value = "Metodo para criar empresa")

    public ResponseEntity addEmpresa(@RequestBody EmpresaDTO empresaSolicitacao) {

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try{

//            if (empresaService.anyEmpresaByNome(empresaSolicitacao.getNome())){
//
////                return new Result("Não é permitido inserir empresas com nome já existente na lista!");
//                responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
//                return responseEntity;
//            }

//            if (service.getEmpresaIdByDocumento(empresaSolicitacao.getDocumento()) != 0L){
//
////                return new Result("Não é permitido inserir empresas com documento já existente na lista!");
//                responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
//                return responseEntity;
//            }

            Empresa empresa = empresaService.addEmpresa(empresaSolicitacao.getNome(), empresaSolicitacao.getDocumento(), empresaSolicitacao.getVagas(), empresaSolicitacao.getSite(), empresaSolicitacao.getEnderecoId());
            if (empresa == null)
                throw new CodenationException("Falha ao incluir empresa!");
        }
        catch(CodenationException cEx) {

            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch(Exception ex) {

            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @GetMapping("/get/{id}")
    public Empresa getByEmpresaId(@PathVariable("id") Long id) {

        return empresaService.getEmpresaById(id);
    }

    @DeleteMapping(value ="/delete/{id}")
    public ResponseEntity deleteByEmpresaId(@PathVariable Long id) {

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {

            empresaService.deleteEmpresaById(id);
        }
        catch (NotFoundException ex){

            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        catch (Exception ex){

            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

//
//    public Long getEmpresaByDocumento(String documento){
//
//        return service.getEmpresaIdByDocumento(documento);
//    }
//
//    public List<Empresa> getEmpresasListByNome(String nome) {
//
//        return service.getEmpresasListByNome(nome);
//    }
//
//    public boolean anyEmpresaByNome(String nome) {
//
//        return service.getEmpresasListByNome(nome).size() > 0;
//    }
//
//    public boolean anyEmpresaById(Long empresaId) {
//
//        return service.anyEmpresaById(empresaId);
//    }
//
//    public boolean anyUsuarioInEmpresaById(Long usuarioId, Long empresaId) {
//
//        return service.anyUsuarioInEmpresaById(usuarioId, empresaId);
//    }
//
//    public void printEmpresas(){
//
//        service.printEmpresas();
//    }
//
//    public void printValorTotalFolha(){
//
//    }
}
