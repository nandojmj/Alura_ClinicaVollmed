package med.clinicavoll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.clinicavoll.api.domain.consulta.ConsultaRepository;
import med.clinicavoll.api.domain.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia implements ValidadorCancelamientoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DatosCancelamientoConsulta datos) {
        var consulta = repository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();

        if (diferenciaEnHoras < 24) {
            throw new ValidationException("Consulta solamente puede ser cancelada con antecedencia mínima de 24h!");
        }
    }

}
