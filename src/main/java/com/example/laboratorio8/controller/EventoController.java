package com.example.laboratorio8.controller;


import com.example.laboratorio8.Entity.Evento;
import com.example.laboratorio8.Entity.TipoTickerEvento;
import com.example.laboratorio8.repository.EventoRepository;
import com.example.laboratorio8.repository.TipoTickerEventoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("")
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    @ResponseBody
    @GetMapping("/evento")
    public List<Evento> listaEventos(){
        return eventoRepository.findAll();
    }


    public static boolean esNumero(String texto) {
        try {
            Integer.parseInt(texto);
            int id = Integer.parseInt((texto));
            if (id>0){
                return true;
            }else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @ResponseBody
    @GetMapping("/evento/{id}")
    public ResponseEntity<HashMap<String,Object>>listarUnEvento(@PathVariable String id){


        HashMap<String, Object> responseMap = new HashMap<>();
        if(id.isEmpty() || id.isBlank()){
            responseMap.put("msg", "Debe enviar un parametro");
            responseMap.put("resultado", "Falla");
            return ResponseEntity.badRequest().body(responseMap);

        } else {
            if(esNumero(id)){
                int ID = Integer.parseInt(id);
                Optional<Evento> opt = eventoRepository.findById(ID);
                if (opt.isPresent()) {
                    Evento evento = opt.get();
                    responseMap.put("Evento",evento);
                    return ResponseEntity.ok(responseMap);
                }else {
                    responseMap.put("msg", "Evento no encontrado");
                    responseMap.put("resultado", "Falla");
                    return ResponseEntity.badRequest().body(responseMap);
                }
            }else {
                responseMap.put("msg", "el ID debe ser un número entero positivo");
                responseMap.put("resultado", "Falla");
                return ResponseEntity.badRequest().body(responseMap);
            }
        }

    }

    @PostMapping("/evento")
    public ResponseEntity<HashMap<String, Object>> saveUser(
            @RequestBody Evento evento,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();
        if(fetchId){
            responseJson.put("id",evento.getId());
        }
        eventoRepository.save(evento);
        responseJson.put("estado","creado");
        responseJson.put("id", evento.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> gestionException(HttpServletRequest request){
        HashMap<String,String> responseMap = new HashMap<>();
        if(request.getMethod().equals("POST")){
            responseMap.put("msg","Debe enviar un evento");
            responseMap.put("estado","error");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }

    @Autowired
    TipoTickerEventoRepository tipoTickerEventoRepository;
    @ResponseBody
    @GetMapping("/eventoConTipodeTicket/{id}")
    public ResponseEntity<HashMap<String,Object>> eventoConTipoDeTicket(@PathVariable String id){


        HashMap<String, Object> responseMap = new HashMap<>();
        if(id.isEmpty() || id.isBlank()){
            responseMap.put("msg", "Debe enviar un parametro");
            responseMap.put("resultado", "Falla");
            return ResponseEntity.badRequest().body(responseMap);

        } else {
            if(esNumero(id)){
                int ID = Integer.parseInt(id);
                Optional<Evento> opt = eventoRepository.findById(ID);
                if (opt.isPresent()) {
                    Evento evento = opt.get();
                    int iddd = evento.getId();
                    List<TipoTickerEvento> listaTickets = tipoTickerEventoRepository.findAll();

                    int ppp = 0;
                    for (TipoTickerEvento p : listaTickets){
                        ppp = p.getIdevento().getId();
                        if(p.getIdevento().getId().equals(evento.getId())){

                        }
                    }
                    responseMap.put("Evento",evento);
                    responseMap.put("Resultado","exitoso");
                    return ResponseEntity.ok(responseMap);
                }else {
                    responseMap.put("msg", "Evento no encontrado");
                    responseMap.put("resultado", "Falla");
                    return ResponseEntity.badRequest().body(responseMap);
                }
            }else {
                responseMap.put("msg", "el ID debe ser un número entero positivo");
                responseMap.put("resultado", "Falla");
                return ResponseEntity.badRequest().body(responseMap);
            }
        }

    }

}
