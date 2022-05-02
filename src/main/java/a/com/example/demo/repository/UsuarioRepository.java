package a.com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import a.com.example.demo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    @Query(value = "SELECT u.idUsuario FROM Usuario u GROUP BY u.idUsuario", nativeQuery = true)
    List<Usuario> getListaRutasxUsuario();
}
