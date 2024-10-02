package com.salesianostriana.dam.monumento.servicio;


import com.salesianostriana.dam.monumento.modelo.Monumento;
import com.salesianostriana.dam.monumento.repositorio.MonumentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor /*sustituye el poner el Autowired*/
public class MonumentoService {


    private final MonumentoRepositorio repository;




    //Métodos


    public List<Monumento> findAll() {


        return repository.findAll();
    }




    public Monumento findById(Long id) {
        Optional<Monumento> monumento = repository.findById(id);
        if (monumento.isPresent()) {
            return monumento.get();
        }else {
            throw new RuntimeException("Monumento no encontrado");
            /*El optional buscar si esta presente el objeto con ese id */
        }
    }


    public Monumento save(Monumento monumento) {


        return repository.save(monumento);
    }


    public Monumento edit(Monumento monumento, Long id) {
        Optional<Monumento> monumento1 = repository.findById(id);
        if (monumento1.isPresent()) {
            monumento1.get().setNombreCiudad(monumento.getNombreCiudad());
            monumento1.get().setNombreMonumento(monumento.getNombreMonumento());
            /*con esto quedan los demas atributos a nullo se deberia usar los dto*/
            return repository.save(monumento1.get());   /*poner el .get para coger el objeto*/
        }else {
            throw new RuntimeException("Monumento no encontrado");
            /*El optional buscar si esta presente el objeto con ese id */
        }
    }


    public void deleteById(Long id) {
        Optional<Monumento> monumento1 = repository.findById(id);
        if(monumento1.isPresent()) {
            repository.deleteById(id);
        }else {
            throw new RuntimeException("Monumento no encontrado");
        }
    }
}
