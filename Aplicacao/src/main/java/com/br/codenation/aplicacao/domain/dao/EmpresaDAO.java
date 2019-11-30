package com.br.codenation.aplicacao.domain.dao;

import com.br.codenation.aplicacao.domain.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmpresaDAO extends JpaRepository<Empresa, Long> {

    @Query(value = "SELECT * FROM company c where c.name = :name ORDER BY name ASC", nativeQuery = true)
    List<Empresa> getEmpresasListByNome(@Param("name") String nome);

//    public List<Empresa> findAllByNameOrderByNome(@Param("name") String nome);

    @Query(value = "SELECT * FROM company c where c.document = :document LIMIT 1", nativeQuery = true)
    Empresa getEmpresaByDocumento(@Param("document") String documento);

    @Transactional
    @Modifying
    @Query("DELETE FROM company c WHERE c.id=:id")
    void delete(@Param("id") Long id);
}
