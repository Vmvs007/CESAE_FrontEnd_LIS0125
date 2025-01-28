package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    Animal leao;
    Animal elefante;

    @BeforeEach
    public void setUp() {
        leao = new Animal("Leão", Alimento.CARNE);
        elefante = new Animal("Elefante", Alimento.VEGETAIS);
    }

    @Test
    public void testGetNome() {
        assertEquals("Leão", leao.getNome());
        assertEquals("Elefante", elefante.getNome());
    }

    @Test
    public void testGetTipoAlimentacao() {
        assertEquals(Alimento.CARNE, leao.getTipoAlimentacao());
        assertEquals(Alimento.VEGETAIS, elefante.getTipoAlimentacao());
    }

    @Test
    public void testComerLeao() {
        // O animal foi criado agora - tem de ter fome
        assertTrue(leao.estaComFome());

        // Alimentamos com algo que não gosta
        leao.comer(Alimento.VEGETAIS);

        // Tem de continuar com fome
        assertTrue(leao.estaComFome());

        // Alimentamos com algo que gosta
        leao.comer(Alimento.CARNE);

        // Tem de deixar de ter fome
        assertFalse(leao.estaComFome());

        // Alimentamos com algo que não gosta
        leao.comer(Alimento.FRUTAS);

        // Não pode ter fome, porque já comeu antes
        assertFalse(leao.estaComFome());
    }

    @Test
    public void testComerElefante() {
        // O animal foi criado agora - tem de ter fome
        assertTrue(elefante.estaComFome());

        // Alimentamos com algo que não gosta
        elefante.comer(Alimento.CARNE);

        // Tem de continuar com fome
        assertTrue(elefante.estaComFome());

        // Alimentamos com algo que gosta
        elefante.comer(Alimento.VEGETAIS);

        // Tem de deixar de ter fome
        assertFalse(elefante.estaComFome());

        // Alimentamos com algo que não gosta
        elefante.comer(Alimento.PEIXE);

        // Não pode ter fome, porque já comeu antes
        assertFalse(elefante.estaComFome());
    }
}