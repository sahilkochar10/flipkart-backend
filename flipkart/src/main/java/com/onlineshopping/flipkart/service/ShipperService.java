package com.onlineshopping.flipkart.service;

import com.onlineshopping.flipkart.entity.Shippers;
import com.onlineshopping.flipkart.exceptions.ShipperAlreadyExistsException;
import com.onlineshopping.flipkart.exceptions.ShipperNotFoundException;
import com.onlineshopping.flipkart.vo.Shipper;
import org.springframework.http.ResponseEntity;
import com.onlineshopping.flipkart.repository.ShipperRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;
    public ResponseEntity<List<Shippers>> getShippers() {
        return new ResponseEntity<>(shipperRepository.findAll(), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {ShipperNotFoundException.class})
    public void saveShippers(List<Shipper> shippers) throws ShipperNotFoundException {

        for (Shipper shipper : shippers) {
            if (shipperRepository.findById(shipper.getShipperID()).isPresent()) {
                throw new ShipperAlreadyExistsException(shipper.getShipperID());
            }
            shipperRepository.save(getEntity(shipper));
        }
    }
    // add transactionmanager
    public com.onlineshopping.flipkart.entity.Shippers getShipperByShipid(Integer shipid) throws ShipperNotFoundException{
        return shipperRepository.findById(shipid).orElseThrow(() -> new ShipperNotFoundException(shipid));
    }

    public void updateShippers(List<com.onlineshopping.flipkart.vo.Shipper> shippers) throws ShipperNotFoundException {
        for (Shipper sh : shippers) {
            if (shipperRepository.findById(sh.getShipperID()).isEmpty()) {
                throw new ShipperNotFoundException(sh.getShipperID());
            }
            shipperRepository.save(getEntity(sh));
        }
    }

    public Shippers getEntity(Shipper shippers) throws ShipperNotFoundException {
        return Shippers.builder()
                .shipperName(shippers.getShipperName())
                .shipperID(shippers.getShipperID())
                .phone(shippers.getPhone()).build();
    }
    public void  deleteShipperById(Integer shipid) {
        shipperRepository.delete(shipperRepository.findById(shipid).orElseThrow(() -> new ShipperNotFoundException(shipid)));

    }
}
