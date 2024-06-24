package med.clinicavoll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.clinicavoll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    @Operation(
            summary = "Registra un paciente en la base de datos",
            description = "Registro de Pacientes",
            tags = { "Pacientes ClinicaVoll.med" })
    public ResponseEntity registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datos,
                                            UriComponentsBuilder uriComponentsBuilder){
        var paciente = new Paciente(datos);
        pacienteRepository.save(paciente);

        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosRespuestaPaciente(paciente));
    }

    @GetMapping
    @Operation(
            summary = "Obtiene el listado de pacientes en la base de datos",
            description = "Listado de pacientes",
            tags = { "Pacientes ClinicaVoll.med" })
    public ResponseEntity<Page<DatosListadoPaciente>> listadoPacientes(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion){
        var page = pacienteRepository.findAllByActivoTrue(paginacion).map(DatosListadoPaciente::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    @Operation(
            summary = "Actualiza datos de pacientes en la base de datos",
            description = "Actualiza datos de pacientes",
            tags = { "Pacientes ClinicaVoll.med" })
    public ResponseEntity actualizarPaciente(@RequestBody @Valid DatosActualizacionPaciente datosActualizacionPaciente) {
        var paciente = pacienteRepository.getReferenceById(datosActualizacionPaciente.id());
        paciente.actualizarInformacion(datosActualizacionPaciente);

        return ResponseEntity.ok(new DatosRespuestaPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Elimina datos de un paciente x Id en la base de datos",
            description = "Elimina datos de pacientes",
            tags = { "Pacientes ClinicaVoll.med" })
    public ResponseEntity eliminarPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.desactivarPaciente();

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity detallar(@PathVariable Long id) {

        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaPaciente(paciente));

    }

}
