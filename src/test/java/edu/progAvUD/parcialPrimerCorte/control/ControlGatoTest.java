package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.GatoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Clase de pruebas para la clase ControlGato.
 * Se verifica que los métodos de identificación de características según el código EMS funcionen correctamente.
 */
class ControlGatoTest {

    private ControlGato controlGato;
    private ControlPrincipal controlPrincipalMock;

    @BeforeEach
    void setUp() {
        // Se crea un mock de ControlPrincipal para evitar dependencias reales en las pruebas
        controlPrincipalMock = Mockito.mock(ControlPrincipal.class);
        // Se instancia ControlGato usando el mock anterior
        controlGato = new ControlGato(controlPrincipalMock);
    }

    @Test
    void testIdentificarRazaSegunEMS() {
        // Prueba con código EMS: se espera una salida combinada del código y el nombre de raza
        String resultado = controlGato.identificarRazaSegunEMS(new String[]{"BRI"});
        assertEquals("BRI-British Shorthair", resultado);
        
        // Prueba con el nombre de raza en lugar del código EMS
        resultado = controlGato.identificarRazaSegunEMS(new String[]{"Persian"});
        assertEquals("PER-Persian", resultado);
        
        // Prueba con una entrada inválida (no reconocida)
        resultado = controlGato.identificarRazaSegunEMS(new String[]{"RazaInexistente"});
        assertNull(resultado); // Se espera un null al no encontrar coincidencias
    }

    @Test
    void testIdentificarColorCuerpoSegunEMS() {
        // Prueba con código EMS del color
        String resultado = controlGato.identificarColorCuerpoSegunEMS(new String[]{"a"});
        assertEquals("a-blue", resultado);
        
        // Prueba con nombre de color, debe retornar el código EMS correspondiente
        resultado = controlGato.identificarColorCuerpoSegunEMS(new String[]{"red"});
        assertEquals("d-red", resultado);
    }

    @Test
    void testIdentificarPatronSegunEMS() {
        // Prueba con código EMS del patrón
        String resultado = controlGato.identificarPatronSegunEMS(new String[]{"21"});
        assertEquals("21-tabby / lynx", resultado);
        
        // Prueba con nombre de patrón
        resultado = controlGato.identificarPatronSegunEMS(new String[]{"spotted"});
        assertEquals("24-spotted", resultado);
    }

    @Test
    void testIdentificarColorOjosSegunEMS() {
        // Prueba con código EMS del color de ojos
        String resultado = controlGato.identificarColorOjosSegunEMS(new String[]{"61"});
        assertEquals("61-blue", resultado);
        
        // Prueba con nombre de color
        resultado = controlGato.identificarColorOjosSegunEMS(new String[]{"green"});
        assertEquals("64-green", resultado);
    }

    @Test
    void testIdentificarColaSegunEMS() {
        // Prueba con código EMS del tipo de cola
        String resultado = controlGato.identificarColaSegunEMS(new String[]{"51"});
        assertEquals("51-rumpy", resultado);
        
        // Prueba con nombre del tipo de cola
        resultado = controlGato.identificarColaSegunEMS(new String[]{"stumpy"});
        assertEquals("53-stumpy", resultado);
    }
}
