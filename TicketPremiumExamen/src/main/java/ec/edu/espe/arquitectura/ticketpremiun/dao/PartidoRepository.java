/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.ticketpremiun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketpremiun.arquitectura.espe.edu.ec.ws.Partido;

/**
 *
 * @author terry
 */
public interface PartidoRepository extends JpaRepository<Partido, String> {
}


