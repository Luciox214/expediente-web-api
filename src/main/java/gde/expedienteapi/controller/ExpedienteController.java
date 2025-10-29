package gde.expedienteapi.controller;
import gde.expedienteapi.service.ExpedienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expedientes")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpedienteController {

    @Autowired
    ExpedienteService expedienteService;
    @GetMapping
    public List<Map<String, Object>> buscarExpediente(
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false) Integer numero,
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) int page,
            @RequestParam(required = false) int size){
        return expedienteService.buscarExpediente(anio, numero, codigo, page, size);
    }

}