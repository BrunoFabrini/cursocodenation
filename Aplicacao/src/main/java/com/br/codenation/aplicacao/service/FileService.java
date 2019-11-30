package com.br.codenation.aplicacao.service;

import java.io.IOException;

public interface FileService {

    public void readUsuariosFromFile(String path) throws IOException;

    public void readEmpresasFromFile(String path) throws IOException;
}
