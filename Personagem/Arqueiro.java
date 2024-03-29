package Personagem;

import Estados.Forte;
import Strategy.*;

public class Arqueiro extends Personagem {
    
    public Arqueiro()
    {
        this.setLife(100);
        this.setLifeState(Forte.getInstancia());
        this.setAtaque(AtaqueForte.getInstancia());
        this.setCorrida(CorridaMedia.getInstancia());
        this.setPulo(PuloMedio.getInstancia());
    }
}
