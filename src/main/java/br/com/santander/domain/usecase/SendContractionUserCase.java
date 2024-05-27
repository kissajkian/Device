package br.com.santander.domain.usecase;

import br.com.santander.app.dto.DeviceContracted;

public interface SendContractionUserCase {

    public void execute(DeviceContracted device);

}