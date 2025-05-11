package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.GatoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ControlGatoTest {

    private ControlGato controlGato;
    private ControlPrincipal controlPrincipalMock;

    @BeforeEach
    void setUp() {
        // Crear mock de ControlPrincipal
        controlPrincipalMock = Mockito.mock(ControlPrincipal.class);
        controlGato = new ControlGato(controlPrincipalMock);
    }

    @Test
    void testIdentificarRazaSegunEMS() {
        // Prueba con código EMS
        String resultado = controlGato.identificarRazaSegunEMS(new String[]{"BRI"});
        assertEquals("BRI-British Shorthair", resultado);
        
        // Prueba con nombre de raza
        resultado = controlGato.identificarRazaSegunEMS(new String[]{"Persian"});
        assertEquals("PER-Persian", resultado);
        
        // Prueba con entrada inválida
        resultado = controlGato.identificarRazaSegunEMS(new String[]{"RazaInexistente"});
        assertNull(resultado);
    }

    @Test
    void testIdentificarColorCuerpoSegunEMS() {
        // Prueba con código EMS
        String resultado = controlGato.identificarColorCuerpoSegunEMS(new String[]{"a"});
        assertEquals("a-blue", resultado);
        
        // Prueba con nombre de color
        resultado = controlGato.identificarColorCuerpoSegunEMS(new String[]{"red"});
        assertEquals("d-red", resultado);
    }

    @Test
    void testIdentificarPatronSegunEMS() {
        // Prueba con código EMS
        String resultado = controlGato.identificarPatronSegunEMS(new String[]{"21"});
        assertEquals("21-tabby / lynx", resultado);
        
        // Prueba con nombre de patrón
        resultado = controlGato.identificarPatronSegunEMS(new String[]{"spotted"});
        assertEquals("24-spotted", resultado);
    }

    @Test
    void testIdentificarColorOjosSegunEMS() {
        // Prueba con código EMS
        String resultado = controlGato.identificarColorOjosSegunEMS(new String[]{"61"});
        assertEquals("61-blue", resultado);
        
        // Prueba con nombre de color
        resultado = controlGato.identificarColorOjosSegunEMS(new String[]{"green"});
        assertEquals("64-green", resultado);
    }

    @Test
    void testIdentificarColaSegunEMS() {
        // Prueba con código EMS
        String resultado = controlGato.identificarColaSegunEMS(new String[]{"51"});
        assertEquals("51-rumpy", resultado);
        
        // Prueba con nombre de tipo de cola
        resultado = controlGato.identificarColaSegunEMS(new String[]{"stumpy"});
        assertEquals("53-stumpy", resultado);
    }
}