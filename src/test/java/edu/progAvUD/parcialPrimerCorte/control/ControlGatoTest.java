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
 *
 * Se verifica que los métodos de identificación de características según el
 * código EMS funcionen correctamente.
 */
class ControlGatoTest {

    private ControlGato controlGato;
    private ControlPrincipal controlPrincipalMock;

    /**
     * Método que se ejecuta antes de cada prueba. - Crea un mock de
     * ControlPrincipal para no depender de la implementación real. - Instancia
     * ControlGato pasando el mock.
     */
    @BeforeEach
    void setUp() {
        controlPrincipalMock = Mockito.mock(ControlPrincipal.class);
        controlGato = new ControlGato(controlPrincipalMock);
    }

    /**
     * Prueba el método identificarRazaSegunEMS: 1. Cuando se pasa un código EMS
     * válido ("BRI"), devuelve "BRI-British Shorthair". 2. Cuando se pasa el
     * nombre en lugar del código ("Persian"), devuelve "PER-Persian". 3. Con un
     * valor no reconocido ("RazaInexistente"), devuelve null.
     */
    @Test
    void testIdentificarRazaSegunEMS() {
        // Caso 1: código EMS válido -> combinación código-nombre
        String resultado = controlGato.identificarRazaSegunEMS(new String[]{"BRI"});
        assertEquals("BRI-British Shorthair", resultado);

        // Caso 2: nombre de raza -> retorna código EMS correspondiente y nombre
        resultado = controlGato.identificarRazaSegunEMS(new String[]{"Persian"});
        assertEquals("PER-Persian", resultado);

        // Caso 3: entrada inválida -> retorna null
        resultado = controlGato.identificarRazaSegunEMS(new String[]{"RazaInexistente"});
        assertNull(resultado);
    }

    /**
     * Prueba el método identificarColorCuerpoSegunEMS: 1. Con código EMS ("a"),
     * espera "a-blue". 2. Con nombre de color ("red"), espera "d-red".
     */
    @Test
    void testIdentificarColorCuerpoSegunEMS() {
        // Código EMS del color -> retorna código más nombre en inglés
        String resultado = controlGato.identificarColorCuerpoSegunEMS(new String[]{"a"});
        assertEquals("a-blue", resultado);

        // Nombre de color -> retorna código EMS correspondiente y nombre
        resultado = controlGato.identificarColorCuerpoSegunEMS(new String[]{"red"});
        assertEquals("d-red", resultado);
    }

    /**
     * Prueba el método identificarPatronSegunEMS: 1. Con código EMS ("21"),
     * espera "21-tabby / lynx". 2. Con nombre de patrón ("spotted"), espera
     * "24-spotted".
     */
    @Test
    void testIdentificarPatronSegunEMS() {
        // Código EMS del patrón -> retorna descripción combinada
        String resultado = controlGato.identificarPatronSegunEMS(new String[]{"21"});
        assertEquals("21-tabby / lynx", resultado);

        // Nombre de patrón -> retorna código EMS y nombre dado
        resultado = controlGato.identificarPatronSegunEMS(new String[]{"spotted"});
        assertEquals("24-spotted", resultado);
    }

    /**
     * Prueba el método identificarColorOjosSegunEMS: 1. Con código EMS ("61"),
     * espera "61-blue". 2. Con nombre de color ("green"), espera "64-green".
     */
    @Test
    void testIdentificarColorOjosSegunEMS() {
        // Código EMS del color de ojos -> retorna código y nombre en inglés
        String resultado = controlGato.identificarColorOjosSegunEMS(new String[]{"61"});
        assertEquals("61-blue", resultado);

        // Nombre de color de ojos -> retorna código EMS correspondiente y nombre
        resultado = controlGato.identificarColorOjosSegunEMS(new String[]{"green"});
        assertEquals("64-green", resultado);
    }

    /**
     * Prueba el método identificarColaSegunEMS: 1. Con código EMS ("51"),
     * espera "51-rumpy". 2. Con nombre de tipo de cola ("stumpy"), espera
     * "53-stumpy".
     */
    @Test
    void testIdentificarColaSegunEMS() {
        // Código EMS del tipo de cola -> retorna código y descripción
        String resultado = controlGato.identificarColaSegunEMS(new String[]{"51"});
        assertEquals("51-rumpy", resultado);

        // Nombre de tipo de cola -> retorna código EMS correspondiente y nombre
        resultado = controlGato.identificarColaSegunEMS(new String[]{"stumpy"});
        assertEquals("53-stumpy", resultado);
    }
}