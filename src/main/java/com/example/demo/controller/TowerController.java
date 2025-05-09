package com.example.demo.controller;



import com.example.demo.entity.Tower;
import com.example.demo.repository.TowerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tower")
public class TowerController {

    private final TowerRepository towerRepository;

    public TowerController(TowerRepository towerRepository) {
        this.towerRepository = towerRepository;
    }

    @GetMapping(value = {"/list", ""})
    public String listarTorres(Model model) {
        List<Tower> lista = towerRepository.findAll();
        model.addAttribute("towerList", lista);

        return "towerList";
    }

    @GetMapping("/new")
    public String nuevoTorreFrm(@ModelAttribute("tower") Tower tower) {
        return "tower/editFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoTorre(Model model, RedirectAttributes attr, @ModelAttribute("tower") @Valid Tower tower, BindingResult bindingResult) {

        /*if(!bindingResult.hasErrors()) {
            if (shipper.getProductname().equals("gaseosa")) {
                model.addAttribute("msg", "Error al crear producto");
                model.addAttribute("listaCategorias", categoryRepository.findAll());
                model.addAttribute("listaProveedores", supplierRepository.findAll());
                return "product/editFrm";
            } else {
                if (product.getId() == 0) {
                    attr.addFlashAttribute("msg", "Producto creado exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
                }
                productRepository.save(product);
                return "redirect:/product";
            }
        }
        else{
            return "shipper/editFrm";
        }*/
        return "shipper/editFrm";
    }

    /*@GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("shipper") Shipper shipper, Model model,
                                      @RequestParam("id") int id) {

        Optional<Shipper> optShipper = shipperRepository.findById(id);

        if (optShipper.isPresent()) {
            shipper = optShipper.get();
            model.addAttribute("shipper", shipper);
            return "shipper/editFrm";
        } else {
            return "redirect:/shipper/list";
        }
    }

    @GetMapping("/delete")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Shipper> optShipper = shipperRepository.findById(id);

        if (optShipper.isPresent()) {
            shipperRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Transportista borrado exitosamente");
        }
        return "redirect:/shipper/list";

    }

    @PostMapping("/BuscarTransportistas")
    public String buscarTransportista(@RequestParam("searchField") String searchField,
                                      Model model) {

        List<Shipper> listaTransportistas = shipperRepository.buscarTransPorCompName(searchField);
        model.addAttribute("shipperList", listaTransportistas);

        return "shipper/list";
    }*/


}

