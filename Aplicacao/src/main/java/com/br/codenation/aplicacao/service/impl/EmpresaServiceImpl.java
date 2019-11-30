package com.br.codenation.aplicacao.service.impl;

import com.br.codenation.aplicacao.domain.dao.EmpresaDAO;
import com.br.codenation.aplicacao.domain.dao.EnderecoDAO;
import com.br.codenation.aplicacao.domain.entity.Empresa;
import com.br.codenation.aplicacao.domain.entity.Endereco;
import com.br.codenation.aplicacao.domain.entity.Usuario;
import com.br.codenation.aplicacao.exception.CodenationException;
import com.br.codenation.aplicacao.service.EmpresaService;
import com.br.codenation.aplicacao.service.EnderecoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class EmpresaServiceImpl extends BaseService implements EmpresaService {

    private List<Empresa> empresasList = new ArrayList<>();

    @Autowired
    private EmpresaDAO empresaDAO;

    @Autowired
    private EnderecoService enderecoService;

    private void validateEmpresa(String nome, String documento, int vagas){

//        if (id == null)
//            throw new CodenationException("Falha ao inserir Empresa. A Idade precisa ser informada!");

        if (nome == null || nome.isEmpty())
            throw new CodenationException("Falha ao inserir Empresa. O Nome precisa ser informado!");

        if (documento == null || documento.isEmpty())
            throw new CodenationException("Falha ao inserir Empresa. O Documento precisa ser informado!");

        if (vagas < 0)
            throw new CodenationException("Falha ao inserir Empresa. O Login precisa ser informado!");
    }

    @Override
    @Transactional
    public Empresa addEmpresa(String nome, String documento, int vagas, String site, Long enderecoId) {

        validateEmpresa(nome, documento, vagas);

        Endereco endereco = enderecoService.getEnderecoById(enderecoId);

        Empresa empresa = new Empresa().builder().documento(documento).nome(nome).vagas(vagas).site(site).endereco(endereco).usuariosList(new ArrayList<>()).build();

        return empresaDAO.save(empresa);
    }

    @Override
    public List<Empresa> getEmpresasList() {

        return empresaDAO.findAll();
    }

    @Override
    public void deleteEmpresaById(Long empresaId) throws NotFoundException {


        empresaDAO.delete(empresaId);

//        Empresa empresa = empresaDAO.findById(empresaId).orElse(null);
//
//        if (empresa == null)
//        {
//            throw new NotFoundException("");
//        }
//
//        empresaDAO.delete(empresa);
    }

    @Override
    public Empresa getEmpresaById(Long empresaId) {

        return empresaDAO.findById(empresaId).orElse(null);
    }

    @Override
    public List<Empresa> getEmpresasListByNome(String nome) {

        if (nome == null || nome.isEmpty())
            throw new CodenationException("Nome invalido.");

        return empresaDAO.getEmpresasListByNome(nome);
    }

    private Empresa getEmpresaByDocumento(String documento){

        if (documento == null || documento.isEmpty())
            throw new CodenationException("Documento invalido.");

//        return empresasList.stream().filter(empresa -> empresa.getDocumento().equals(documento)).findFirst().orElse(null);

        return empresaDAO.getEmpresaByDocumento(documento);
    }

    public Long getEmpresaIdByDocumento(String documento){

        Empresa empresa = getEmpresaByDocumento(documento);
        if (empresa == null)
            throw new CodenationException("Empresa nao encontrada!");

        return empresa.getId();
    }

    private Empresa getEmpresa(Long empresaId){

        if (empresaId == null)
            throw new CodenationException("Id invalido.");

        return empresasList.stream().filter(empresa -> empresa.getId().equals(empresaId)).findFirst().orElse(null);
    }

    public void printMaiorSalario(Long empresaId){

//        BigDecimal salarioUsuario = BigDecimal.ZERO;
//        Comparator<Usuario> comparadorMaiorSalario = Comparator.comparing(Usuario::getSalario).reversed();
//        String mensagem = "Maior Salario:";
//
//        if (empresaId > 0){
//
//            Empresa empresa = getEmpresa(empresaId);
//            if (empresa == null)
//                throw new CodenationException("Empresa nao encontrada!");
//
////			salarioUsuario = empresa.getUsuariosList().stream().sorted(comparadorMaiorSalario).limit(1).map(Usuario::getSalario).findFirst().orElse(BigDecimal.ZERO);
//            mensagem = mensagem.replace(":", "da Empresa '" + empresa.getNome() + "': " );
//        }
//        else
//            salarioUsuario = usuariosList.stream().sorted(comparadorMaiorSalario).limit(1).map(Usuario::getSalario).findFirst().orElse(BigDecimal.ZERO);
//
//        System.out.println(mensagem + salarioUsuario);
    }

    public void printMaiorSalario(){

//        printMaiorSalario(0L);
//
//        for (Empresa empresa:empresasList)
//            printMaiorSalario(empresa.getId());
    }

    private void printMediaSalarialPorEmpresa(Long empresaId){

        BigDecimal mediaSalarial = BigDecimal.ZERO;
        Comparator<Usuario> comparadorMaiorSalario = Comparator.comparing(Usuario::getSalario).reversed();

        Empresa empresa = getEmpresa(empresaId);
        if (empresa == null)
            throw new CodenationException("Empresa nao encontrada!");

//		for (Usuario usuario:empresa.getUsuariosList()){
//			mediaSalarial = mediaSalarial.add(usuario.getSalario());
//		}

//		Integer size = empresa.getUsuariosList().size();
//		mediaSalarial =  mediaSalarial.divide(BigDecimal.valueOf(size));

        System.out.println("Media salarial da empresa '" + empresa.getNome() + "' - eh de: R$" + mediaSalarial);
    }

    public void printMediaSalarial(){

//        for (Empresa empresa:empresasList)
//            printMediaSalarialPorEmpresa(empresa.getId());
    }

    private BigDecimal getValorTotalFolha(Empresa empresa){

        BigDecimal valorTotalFolha = BigDecimal.ZERO;

        if (empresa == null)
            throw new CodenationException("Empresa nao encontrada!");

//		for (Usuario usuario:empresa.getUsuariosList()){
//			valorTotalFolha = valorTotalFolha.add(usuario.getSalario());
//		}

        return valorTotalFolha;
    }

    public void printValorTotalFolha(){

//        for (Empresa empresa:empresasList){
//            System.out.println("Valor total da Folha de Pagamento da empresa '" + empresa.getNome() + "' - eh de: R$" + getValorTotalFolha(empresa));
//        }
    }

    public void printEmpresaMenorCusto(){

//        String empresaNome = "";
//        BigDecimal menorCusto = BigDecimal.valueOf(Double.MAX_VALUE);
//        BigDecimal custoEmpresa = BigDecimal.ZERO;
//
//        for (Empresa empresa:empresasList){
//
//            custoEmpresa = getValorTotalFolha(empresa);
//
//            if (menorCusto.compareTo(custoEmpresa) > 0){
//
//                menorCusto = custoEmpresa;
//                empresaNome = empresa.getNome();
//            }
//        }
//
//        if (empresaNome.isEmpty())
//            throw new CodenationException("Nao foi encontrada a empresa de menor custo");
//
//        System.out.println("A empresa " + empresaNome + " tem o menor custo.");
    }

    public Float getMediaIdadeEmpresa(Empresa empresa){

        Float mediaIdadeEmpresa = 0F;

        if (empresa == null)
            throw new CodenationException("Empresa nao encontrada!");

        for (Usuario usuario:empresa.getUsuariosList()){
            mediaIdadeEmpresa += usuario.getIdade();
        }

        mediaIdadeEmpresa = mediaIdadeEmpresa / empresa.getUsuariosList().size();

        return mediaIdadeEmpresa;
    }

    public void printMediaIdadeEmpresas(){

//        empresasList.forEach(empresa -> {
//                    System.out.println(getMediaIdadeEmpresa(empresa));
//                }
//        );
    }

    public void printUsuariosOrderedByIdade(){

//        Comparator<Usuario> comparadorIdade = Comparator.comparing(Usuario::getIdade);
//        empresasList.forEach(empresa -> {
//
//                    List<Usuario> usuariosOrdenados = empresa.getUsuariosList().stream().sorted(comparadorIdade).collect(Collectors.toList());
//                    printUsuarios(usuariosOrdenados);
//                }
//        );
    }

    public void printEmpresas() {

//        for (Empresa empresa:empresasList){
//
//            StringBuilder sb = new StringBuilder();
//
//            sb.append("Id: '" + empresa.getId() + "'; ");
//            sb.append("Empresa: '" + empresa.getNome() + "'; ");
//            sb.append("Documento: '" + empresa.getDocumento() + "'; ");
//            sb.append("Vagas: '" + empresa.getVagas() + "'; ");
//            sb.append("Site: '" + empresa.getSite());
//
//            System.out.println(sb.toString());
//        }
    }

    public boolean anyEmpresaByNome(String nome) {

//        try {
//
//            for(Empresa item:empresasList) {
//                if(item.getNome().equals(nome)) {
//                    return true;
//                }
//            }
//        }
//        catch(Exception ex) {
//            return false;
//        }
//
        return false;
    }

    public boolean anyEmpresaById(Long empresaId) {

//        try {
//
//            for(Empresa item:empresasList) {
//                if(item.getId() == empresaId) {
//                    return true;
//                }
//            }
//        }
//        catch(Exception ex) {
//            return false;
//        }
//
        return false;
    }

    public boolean anyUsuarioInEmpresaById(Long usuarioId, Long empresaId) {

//        try {
//
//            for(Empresa empresa:empresasList) {
//                if(empresa.getId() == empresaId) {
//                    for(Usuario usuario:empresa.getUsuariosList()) {
//                        if(usuario.getId() == usuarioId) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        catch(Exception ex) {
//            return false;
//        }

        return false;
    }
}
