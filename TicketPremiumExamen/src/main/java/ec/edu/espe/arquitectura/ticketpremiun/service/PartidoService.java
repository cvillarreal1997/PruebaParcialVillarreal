/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.ticketpremiun.service;

import ec.edu.espe.arquitectura.ticketpremiun.dao.PartidoRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import ticketpremiun.arquitectura.espe.edu.ec.ws.Partido;

/**
 *
 * @author terry
 */
public class PartidoService {

    private final PartidoRepository partidoRepository;
     public PartidoService(PartidoRepository productoRepository) {
        this.partidoRepository = productoRepository;
    }

     public Optional<Partido> obtainByCodigo(String codigo) {
        return this.partidoRepository.findById(codigo);
    }
      @Transactional
    public Partido createPartido(Partido partido) {
        Optional<Partido> productoOpt = this.obtainByCodigo(partido.getCODIGO());
        if (!productoOpt.isPresent()) {
            return this.partidoRepository.save(partido);
        } else {
            StringBuilder sbMsg = new StringBuilder("The PRODUCTO with code: ");
            sbMsg.append(partido.getCODIGO());
            sbMsg.append(" is already in the database");
            throw new CreateException(sbMsg.toString());
        }
    }
}
