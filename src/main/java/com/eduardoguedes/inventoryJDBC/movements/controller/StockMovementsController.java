package com.eduardoguedes.inventoryJDBC.movements.controller;

import com.eduardoguedes.inventoryJDBC.movements.service.StockMovementsService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.Kernel;
import java.util.Map;

@RestController
@RequestMapping("/stock-movements")
public class StockMovementsController {


  StockMovementsService stockMovementsService = new StockMovementsService();

  @PostMapping
  public String registerNewMovements(@RequestBody Map<String, Object> body){
    int idProduct = (int) body.get("product");
    double quantity = (double) body.get("quantity");
    String type = (String) body.get("type");

    stockMovementsService.createStockMovements( (long)idProduct, quantity, type);

    return "Movimentacao inserida com sucesso";
  }
}
