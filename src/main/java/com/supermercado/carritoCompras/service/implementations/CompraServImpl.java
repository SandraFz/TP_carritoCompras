package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.CompraDTO;
import com.supermercado.carritoCompras.model.entities.Cliente;
import com.supermercado.carritoCompras.model.entities.Compra;
import com.supermercado.carritoCompras.model.mapper.ClienteMapper;
import com.supermercado.carritoCompras.model.mapper.CompraMapper;
import com.supermercado.carritoCompras.service.interfaces.ICompraService;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import com.supermercado.carritoCompras.service.repositories.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CompraServImpl implements ICompraService {

    @Autowired
    public ICompraRepository repoCom;

    @Autowired
    public CompraMapper mapCom;

    @Autowired
    public IClienteRepository repoCli;

    @Override
    public CompraDTO newCompra(CompraDTO dto, Long id) {

        Compra com = mapCom.dtoToCompResquest(dto);
        Compra newCom = repoCom.save(com);
        CompraDTO newComDto = mapCom.comToDtoResponse(newCom);

        Cliente cli = repoCli.getReferenceById(id);
        cli.getCompras().add(newCom);
        repoCli.saveAndFlush(cli);

        return newComDto;
    }

    @Override
    public Compra findCompraById(Long id) {

        Compra com = repoCom.getReferenceById(id);
        return com;
    }

    @Override
    public List<Compra> findByCliente(Long id) {

        Cliente cli = repoCli.getReferenceById(id);

        return cli.getCompras();
    }

    @Override
    public List<Compra> allCompras() {

        List<Compra> compras = repoCom.findAll();
        return compras;
    }

    @Override
    public List<Compra> findByFecha(Date fecha){

        List<Compra> compras = repoCom.findByFecha(fecha);

        return compras;
    }

    @Override
    public List<Compra> findBetween (int desde, int hasta){

        //List<Compra> compras = repoCom.findBetween(desde, hasta);

        List<Compra> compras = repoCom.findAll();
        List<Compra> rango = new ArrayList<>();

        for(Compra compra: compras){

            LocalDate date = compra.getFecha();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dateString = date.format(formato);
            String[] fechacomp = dateString.split("-");
            int dia = Integer.parseInt(fechacomp[0]);

            if(dia >=  desde && dia <= hasta){
                    rango.add(compra);
                }
            }
        return rango;
        }


}
