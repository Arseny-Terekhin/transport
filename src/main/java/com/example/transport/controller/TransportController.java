package com.example.transport.controller;

import com.example.transport.entity.Transport;
import com.example.transport.service.TransportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    TransportService transportService;

    @GetMapping
    public String transportList(Model modelView,
                                @RequestParam(defaultValue = "") String brand,
                                @RequestParam(defaultValue = "") String model,
                                @RequestParam(defaultValue = "") String category,
                                @RequestParam(defaultValue = "") String licenseNumber,
                                @RequestParam(defaultValue = "") String releaseYear){
        Iterable<Transport> transp = transportService.findTransport(brand, model, category, licenseNumber, releaseYear );
        modelView.addAttribute("transportList", transp);
        return "transport-List";
    }

    @GetMapping("/add")
    public String addTransp(Model model) {
        model.addAttribute("transport", new Transport());
        return "transport-add";
    }

    @PostMapping("/add")
    public String addTransport(Model model, @ModelAttribute("transport") @Valid @RequestBody Transport transport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "transport-add";
        }
        try {
            transportService.addTransport(transport);
        } catch (Exception e){
            model.addAttribute("uniqueLicenseNumberError", true);
            return "transport-add";
        }

        return "transport-add";
    }

}
