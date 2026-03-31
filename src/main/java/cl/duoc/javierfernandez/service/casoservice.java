package cl.duoc.javierfernandez.service;

import cl.duoc.javierfernandez.model.caso;
import cl.duoc.javierfernandez.repository.casorepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class casoservice {

private final casorepository repo;

public casoservice(casorepository repo) {
this.repo = repo;
}

public caso crear(caso c) {
return repo.guardar(c);
}

public List<caso> listar() {
return repo.listar();
}

public caso buscar(Long id) {
caso c = repo.buscar(id);
if (c == null) {
throw new RuntimeException("No existe el caso");
}
return c;
}

public caso actualizar(Long id, caso nuevo) {
caso c = buscar(id);
c.setPaciente(nuevo.getPaciente());
c.setEspecialidad(nuevo.getEspecialidad());
c.setEstado(nuevo.getEstado());
c.setFecha(nuevo.getFecha());
c.setPrioridad(nuevo.getPrioridad());
return c;
}

public void eliminar(Long id) {
repo.eliminar(id);
}

public List<caso> ordenar() {
List<caso> lista = repo.listar();
lista.sort(Comparator.comparingInt(caso::getPrioridad));
return lista;
}
}