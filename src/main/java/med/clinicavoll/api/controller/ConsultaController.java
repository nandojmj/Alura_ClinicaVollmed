package med.clinicavoll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @PostMapping
    @Transactional
    @Operation(
            summary = "Registra una consulta en la base de datos",
            description = "Consultas Citas",
            tags = { "Consultas ClinicaVoll.med" })
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) throws ValidacionDeIntegridad {
        var response = service.agendar(datos);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(
            summary = "Obtiene el listado de consultas en la base de datos",
            description = "Listado Citas",
            tags = { "Consultas ClinicaVoll.med" })
      public ResponseEntity<Page<DatosDetalleConsulta>> listar(@PageableDefault(size = 10, sort = {"fecha"}) Pageable paginacion) {
        var response = service.consultar(paginacion);
        return ResponseEntity.ok(response);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id) {
//        service.cancelarConsulta(id);
//        return ResponseEntity.noContent().build();
//    }

//    @DeleteMapping
//    @Transactional
//    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelamientoConsulta datos) {
//        service.cancelar(datos);
//        return ResponseEntity.noContent().build();
//    }

}