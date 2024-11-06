package pe.upc.edu.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.edu.aaw.tf_finanzas.entities.Usuario;
@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario,Integer> {


    public Usuario findByUsername(String username);

    //BUSCAR POR NOMBRE
    @
    Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    @Query(value = "SELECT id_usuario FROM usuario\n" +
            "ORDER BY id_usuario DESC\n" +
            "LIMIT 1 ", nativeQuery = true)
    public int findLastUserRegister();

}
