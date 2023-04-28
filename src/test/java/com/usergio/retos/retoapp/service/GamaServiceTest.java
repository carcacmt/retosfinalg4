package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Gama;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class GamaServiceTest {
    @Resource
    GamaService gamaService;

    @Test
    @DisplayName("Prueba Guardar Gama")
    void save() {
         Gama gama = Gama.builder()
                .name("Familiar")
                .description("Auto Familiar")
                .build();
        assertEquals(gama, gamaService.save(gama));
    }
    @Test
    @DisplayName("Prueba Mostrar Todos Registro Gama")
    void getAll() {
        Gama gama =  Gama.builder()
                .idGama(1L)
                .name("Familiar")
                .description("Auto Familiar")
                .build();
        List<Gama> gamasexpect = new ArrayList<Gama>();
       // gamasexpect.add(gama);
        List<Gama> gamaAll = gamaService.getAll();
        assertEquals(gamasexpect,gamaAll);
    }
    @Test
    @DisplayName("Actualizar Gama")
    void updateGama() {
        Gama gamaEditar = Gama.builder().idGama(1L)
                                        .name("Familiar Colombia")
                                        .description("Auto Familiar Colombia")
                                        .build();
        assertEquals(gamaEditar,gamaService.updateGama(gamaEditar));
    }

    @Test
    @DisplayName("Eliminar Gama")
    void deleteGama() {
        gamaService.deleteGama(1L);
        Gama gama = Gama.builder().build();
        if(!gamaService.getFindById(1L).isPresent()){
            gama = null;
        }
        assertEquals(null,gama);
    }
}