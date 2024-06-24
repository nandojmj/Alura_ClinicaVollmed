package med.clinicavoll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.clinicavoll.api.domain.medico.Especialidad;

import java.time.LocalDateTime;

public record DatosAgendarConsulta(@NotNull
                                   Long idPaciente,
                                   Long idMedico,
                                   @NotNull
                                   @Future
                                   LocalDateTime fecha,
                                   Especialidad especialidad) {
}
