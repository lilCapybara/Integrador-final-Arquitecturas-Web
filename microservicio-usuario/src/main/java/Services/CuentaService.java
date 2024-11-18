package Services;

import Entities.Cuenta;
import Repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    //CRUD de cuenta

    public Cuenta agregarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void getCuenta(int idCuenta) {
        Cuenta cuenta = cuentaRepository.findById(idCuenta).get();
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
