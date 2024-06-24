package med.clinicavoll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.clinicavoll.api.domain.consulta.AgendaDeConsultaService;
import med.clinicavoll.api.domain.consulta.DatosAgendarConsulta;
import med.clinicavoll.api.domain.consulta.DatosCancelamientoConsulta;
import med.clinicavoll.api.domain.consulta.DatosDetalleConsulta;
import med.clinicavoll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) throws ValidacionDeIntegridad {
        var response = service.agendar(datos);
        return ResponseEntity.ok(response);
    }

    @GetMapping
      public ResponseEntity<Page<DatosDetalleConsulta>> listar(@PageableDefault(size = 10, sort = {"fecha"}) Pageable paginacion) {
        var response = service.consultar(paginacion);
        return ResponseEntity.ok(response);
    }

//    @DeleteMapping
//    @Transactional
//    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelamientoConsulta datos) {
//        service.cancelar(datos);
//        return ResponseEntity.noContent().build();
//    }

}