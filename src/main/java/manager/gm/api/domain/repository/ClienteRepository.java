package manager.gm.api.domain.repository;

import manager.gm.api.domain.models.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Modifying
    @Query("""
            UPDATE Clientes
            SET nome=:nome, sobrenome=:sobrenome , endereco=:endereco , email=:email  , telefone=:telefone 
            WHERE idcliente=:idcliente
            """ )
    int AtualizaCliente(Long idcliente,String nome, String sobrenome, String endereco, String email, String telefone);
}
