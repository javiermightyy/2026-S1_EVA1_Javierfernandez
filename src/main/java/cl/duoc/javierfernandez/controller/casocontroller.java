package cl.duoc.javierfernandez.controller;

import cl.duoc.javierfernandez.model.caso;
import cl.duoc.javierfernandez.service.casoservice;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casos")
public class casocontroller {

private final casoservice service;

public casocontroller(casoservice service) {
this.service = service;
}

@PostMapping
public ResponseEntity<?> crear(@Valid @RequestBody caso c) {
return ResponseEntity.ok(service.crear(c));
}

@GetMapping
public ResponseEntity<List<caso>> listar() {
return ResponseEntity.ok(service.listar());
}

@GetMapping("/{id}")
public ResponseEntity<?> buscar(@PathVariable Long id) {
return ResponseEntity.ok(service.buscar(id));
}

@PutMapping("/{id}")
public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody caso c) {
return ResponseEntity.ok(service.actualizar(id, c));
}

@DeleteMapping("/{id}")
public ResponseEntity<?> eliminar(@PathVariable Long id) {
service.eliminar(id);
return ResponseEntity.noContent().build();
}

@GetMapping("/ordenados")
public ResponseEntity<List<caso>> ordenar() {
return ResponseEntity.ok(service.ordenar());
}
}