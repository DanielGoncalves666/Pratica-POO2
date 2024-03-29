package Personagem.factory;

import Personagem.*;

public class FabricaPersonagemAvancada extends FabricaPersonagem {
    
    private static FabricaPersonagemAvancada instancia = null;
    
    // impede a criação com o construtor
    private FabricaPersonagemAvancada(){};

    // lazy instantiation 
    public static synchronized FabricaPersonagemAvancada getInstancia()
    {
        if(instancia == null)
            instancia = new FabricaPersonagemAvancada();
        
        return instancia;
    }
    
    public Personagem createPersonagem()
    {
        double rand = Math.random();
        Personagem criado;
        
        if(rand <= 0.2)
        {
            criado = new PersonagemTanque();
        }
        else if(rand <= 0.4)
        {
            criado = new PersonagemMago();
        }
        else if(rand <= 0.6)
        {
            criado = new PersonagemLadino();
        }
        else if(rand <= 0.8)
        {
            criado = new PersonagemPerfeito();
        }
        else
        {
            criado = new PersonagemFraco();
        }
        
        rand = Math.random();
        if(rand <= 0.33)
        {
            criado.adicionarPoderAtaque(1); // fogo
        }
        else if(rand <= 0.66)
        {
            criado.adicionarPoderAtaque(2); // gelo
        }
        else
        {
            criado.adicionarPoderAtaque(3); // trovao
        }
        
        return criado;
    }
}
