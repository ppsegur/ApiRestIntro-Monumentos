package com.salesianostriana.dam.monumento.repositorio;

import com.salesianostriana.dam.monumento.modelo.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentoRepositorio  extends JpaRepository<Monumento,  Long> {


}
