package com.salesianostriana.dam.monumento.controlador;






import com.salesianostriana.dam.monumento.modelo.Monumento;
import com.salesianostriana.dam.monumento.servicio.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/m")
@RequiredArgsConstructor
public class MonumentoController {


    private final MonumentoService service;



    @PostMapping("/crear")
    public ResponseEntity<Monumento>crear(@RequestBody Monumento monumento) {
        Monumento monumento1 = service.save(monumento);
        return ResponseEntity.status(201).body(monumento1);/*201=creación del objeto correctamente*/
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Monumento> buscar(@PathVariable Long id) {
        Monumento monumento = service.findById(id);
        return ResponseEntity.ok(monumento);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<Monumento> editar(@RequestBody Monumento monumento, @PathVariable Long id) {
        Monumento monumento1 = service.edit(monumento, id);
        return ResponseEntity.status(201).body(monumento1);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) { /* el ? para devolver algo ya que el monumento ha sido borrado*/
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

