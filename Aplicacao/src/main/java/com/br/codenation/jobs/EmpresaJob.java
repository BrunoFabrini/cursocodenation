package com.br.codenation.jobs;

import com.br.codenation.aplicacao.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class EmpresaJob {

    @Autowired
    EmpresaService empresaService;

    @Scheduled(fixedRate = 5000L)
    public void main(String[] args){

        int countEmpresas = empresaService.getEmpresasList().size();

//        LOG.info();
    }
}
