package cl.duoc.javierfernandez.repository;

import cl.duoc.javierfernandez.model.caso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class casoepository {

private List<caso> lista = new ArrayList<>();
private Long id = 1L;

public List<caso> listar() {
return lista;
}

public caso guardar(caso c) {
c.setId(id++);
lista.add(c);
return c;
}

public caso buscar(Long id) {
for (caso c : lista) {
if (c.getId().equals(id)) return c;
}
return null;
}

public void eliminar(Long id) {
lista.removeIf(c -> c.getId().equals(id));
}
}
