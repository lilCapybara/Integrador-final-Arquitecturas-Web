package edu.unicen.exa.microserviciousuario.Services;

import edu.unicen.exa.microserviciousuario.Entities.Cuenta;
import edu.unicen.exa.microserviciousuario.Repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {


    private CuentaRepository cuentaRepository;

    //CRUD de cuenta

    public Cuenta agregarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta getCuenta(int idCuenta) {
        return cuentaRepository.findById(idCuenta).get();
    }

    public void borrarCuenta(int idCuenta) {
        cuentaRepository.deleteById(idCuenta);
    }

    public void modificarCuenta(int idCuenta, Cuenta nuevaCuenta) {
        Cuenta cuentaAModificar = cuentaRepository.findById(idCuenta).get();

        cuentaAModificar.setUsuarios(nuevaCuenta.getUsuarios());
        cuentaAModificar.setSaldo(nuevaCuenta.getSaldo());

        cuentaRepository.save(cuentaAModificar);
    }
}
