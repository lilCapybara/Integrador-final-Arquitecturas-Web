package FeignClients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Date;

public interface ViajeFeign {
    @GetMapping("api/microservicioViaje/facturacion/{anio}/{mesInicio}/{mesFin}")
    public double getFacturacion(@PathVariable("anio") Date anio,@PathVariable("mesInicio") Date mesInicio,@PathVariable("mesFin") Date mesFin);

    @PutMapping("api/microservicioViaje//ajustarTarifaViaje/{nuevaTarifa}/{fecha}")
    public void ajustarTarifaViaje(@PathVariable("nuevaTarifa") int nuevaTarifa, @PathVariable("fecha") Date fecha);

    @PutMapping("api/microservicioViaje//ajustarTarifaPausa/{nuevaTarifa}/{fecha}")
    public void ajustarTarifaPausa(@PathVariable("nuevaTarifa") int nuevaTarifa, @PathVariable("fecha")  Date fecha);
}
