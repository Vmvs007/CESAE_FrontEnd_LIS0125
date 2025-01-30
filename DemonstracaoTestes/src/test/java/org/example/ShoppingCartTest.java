package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart shoppingCart001;
    private ShoppingCart shoppingCart002;

    @BeforeEach
    void setUp() {
        shoppingCart001= new ShoppingCart("001");
        shoppingCart002= new ShoppingCart("002");
    }

    @Test
    public void testCartStartsWithZeroItems(){
        assertEquals(0,shoppingCart001.getItemCount());
        assertEquals(0,shoppingCart002.getItemCount());
    }


    @Test
    public void testAddItemSize(){
        // Adiciono um item ao carrinho 001
        shoppingCart001.addItem("Computador");

        // Tamanho do carrinho001 é 1, do carrinho002 é 0
        assertEquals(1,shoppingCart001.getItemCount());
        assertEquals(0,shoppingCart002.getItemCount());

        // Adiciono um item ao carrinho 001
        shoppingCart001.addItem("Rato PC");

        // Tamanho do carrinho001 é 2, do carrinho002 é 0
        assertEquals(2,shoppingCart001.getItemCount());
        assertEquals(0,shoppingCart002.getItemCount());
    }

    @Test
    public void testAddItemExact(){
        // Adiciono um item ao carrinho 001
        shoppingCart001.addItem("Computador");

        assertTrue(shoppingCart001.containsItem("Computador"));
        assertFalse(shoppingCart001.containsItem("Rato PC"));

        // Adiciono um item ao carrinho 001
        shoppingCart001.addItem("Rato PC");

        assertTrue(shoppingCart001.containsItem("Computador"));
        assertTrue(shoppingCart001.containsItem("Rato PC"));
        assertFalse(shoppingCart001.containsItem("Teclado"));
    }

    @Test
    public void testClearCart(){
        // Adiciono alguns itens ao carrinho 001
        shoppingCart001.addItem("Computador");
        shoppingCart001.addItem("Rato PC");
        shoppingCart001.addItem("Teclado");
        shoppingCart001.addItem("Disco SSD");

        assertEquals(4,shoppingCart001.getItemCount());

        shoppingCart001.clearCart();

        assertEquals(0,shoppingCart001.getItemCount());
    }

    @Test
    public void testRemoveItem(){
        // Adiciono alguns itens ao carrinho 001
        shoppingCart001.addItem("Computador");
        shoppingCart001.addItem("Rato PC");
        shoppingCart001.addItem("Teclado");
        shoppingCart001.addItem("Disco SSD");

        assertEquals(4,shoppingCart001.getItemCount());

        shoppingCart001.removeItem("Cenouras");

        assertEquals(4,shoppingCart001.getItemCount());

        shoppingCart001.removeItem("Teclado");

        assertEquals(3,shoppingCart001.getItemCount());
        assertFalse(shoppingCart001.containsItem("Teclado"));

        assertTrue(shoppingCart001.containsItem("Computador"));
    }

}