package med.clinicavoll.api.domain.consulta.validaciones;

import med.clinicavoll.api.domain.consulta.DatosAgendarConsulta;

public interface ValidadorDeConsultas {
    public void validar(DatosAgendarConsulta datos);
}
