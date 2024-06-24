package med.clinicavoll.api.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.clinicavoll.api.domain.direccion.DatosDireccion;
import med.clinicavoll.api.domain.medico.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/admin")
//    public String adminAccess() {
//        return "Acceso solo para administradores";
//    }
//
//    @PreAuthorize("hasRole('USER')")
//    @GetMapping("/user")
//    public String userAccess() {
//        return "Acceso solo para usuarios";
//    }


    @PostMapping
    @Operation(
            summary = "Registra un medico en la base de datos",
            description = "Registro de Medicos",
            tags = { "Medicos ClinicaVoll.med" })
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DatosRespuestaMedico datosRespuestaMedico = new DatosRespuestaMedico(medico.getId(), medico.getNombre(), medico.getEmail(),
                medico.getTelefono(), medico.getEspecialidad().toString(),
                new DatosDireccion(medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(), medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento()));

        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMedico);


        // RETORNA 201 CREATED
        // URL donde encontrar al medico guardado
        // Get http://localhost:8080/medicos/xx
    }


    @GetMapping
    @Operation(
            summary = "Obtiene el listado de medicos en la base de datos",
            description = "Listado de medicos",
            tags = { "Medicos ClinicaVoll.med" })
    public ResponseEntity<Page<DatosListadoMedico>> listadoMedicos(@PageableDefault(size = 9) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new));
    }

    @PutMapping
    @Transactional
    @Operation(
            summary = "Actualiza datos de medicos en la base de datos",
            description = "Actualiza datos de medicos",
            tags = { "Medicos ClinicaVoll.med" })
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosRespuestaMedico(medico.getId(), medico.getNombre(), medico.getEmail(),
                medico.getTelefono(), medico.getEspecialidad().toString(),
                new DatosDireccion(medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(), medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento())));
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    @Operation(
            summary = "Elimina datos de medicos en la base de datos",
            description = "Elimina datos de medicos",
            tags = { "Medicos ClinicaVoll.med" })
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
        // RETORNA 204  No Content
    }

//    DELETE EN BASE DE DATOS
//    public void eliminarMedico(@PathVariable Long id){
//        Medico medico = medicoRepository.getReferenceById(id);
//        medicoRepository.delete(medico);
//    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtiene datos de un medico x ID en la base de datos",
            description = "Listado de medicos",
            tags = { "Medicos ClinicaVoll.med" })
    public ResponseEntity<DatosRespuestaMedico> retornaDatosMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        var datosMedico = new DatosRespuestaMedico(medico.getId(), medico.getNombre(), medico.getEmail(),
                medico.getTelefono(), medico.getEspecialidad().toString(),
                new DatosDireccion(medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(), medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento()));
        return ResponseEntity.ok(datosMedico);
    }

}