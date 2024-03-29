package Personagem;

import Armas.Arma;
import Strategy.Decorator.*;
import Estados.*;
import Strategy.*;
import Escudos.*;
import Jogar.*;

/**
 * Classe abstrata Personagem
 */

// atua como invoker
public abstract class Personagem implements Runnable
{
    private int Life;
    private LifeState vida;
    private Escudo prox = null;
    private Arma weapon = null;
    private JogarJogo jj = null; // armazena o jogo sendo jogado
    
    private Ataque atk;
    private Correr run;
    private Pulo jump;
    
    int x;
    int y;
    
    public Personagem()
    {
        this.setLife(70);
        this.setLifeState(Normal.getInstancia());
        this.setPulo(PuloMedio.getInstancia()); // para nao ficar incompleto
    }
    
    public void sofrerDano(int dano)
    {
        int novoDano = dano;
        
        if(prox != null) // se houver um escudo equipado
        {
            novoDano = prox.processaDefesa(dano);  
            System.out.print("** " + (dano - novoDano) + " Defendido\n");
        }
        
        this.vida.sofrerDano(this,novoDano);
        System.out.print("-" + novoDano + "HP\n");
    }
    
    public void recuperarVida(int recuperar)
    {
        this.vida.recuperarVida(this,recuperar);
        System.out.print("+" + recuperar + "HP\n");
    }
    
    public void atacar(Personagem atacado)
    {
        double modificador = this.atk.ataque(); // recebe o modificador do ataque da arma equipada
        if(weapon == null)
            atacado.sofrerDano(0); // nenhuma arma equipada, nem mesmo os punhos. Nenhum dano
        else
            atacado.sofrerDano( (int) Math.floor(weapon.getDano() * modificador)); 
            // o dano deferido é o dano da arma vezes o modificador, para baixo
    }
    
    public void correr()
    {
        this.run.correr();
    }
    
    public void pular()
    {
        this.jump.pular();
    }
    
    public void setAtaque(Ataque novo)
    {
        this.atk = novo;
    }
    
    public void adicionarPoderAtaque(int tipo)
    {
        switch(tipo)
        {
            case 1:// fogo
                atk = new Fogo(atk);
                break;
            case 2:// gelo
                atk = new Gelo(atk);
                break;
            case 3:// trovao
                atk = new Trovao(atk);
                break;
            default:// invalido
                // faz nada
                break;
        }
    }
    
    public void setCorrida(Correr nova)
    {
        this.run = nova;
    }
    
    public void setPulo(Pulo novo)
    {
        this.jump = novo;
    }
    
    public void setLife(int valor)
    {
        if(valor < 0)
            this.Life = 0;
        else if(valor > 100)
            this.Life = 100;
        else      
            this.Life = valor;
    }
    
    public void setLifeState(LifeState novo)
    {
        this.vida = novo;
    }
    
    public LifeState getLifeState()
    {
        return this.vida;
    }
    
    public void printLifeState()
    {
        System.out.print(this.vida.toString().substring(0, this.vida.toString().indexOf('@')) + "\n");
    }

    public int getLife()
    {
         return this.Life;   
    }
    
    public Ataque getAtaque()
    {
        return atk;
    }
    
    public void adicionarEscudo(Escudo novo)
    {
        // o primeiro escudo adicionado sera o ultima da lista
        novo.setProx(this.prox);
        this.prox = novo;
    }
    
    public void setArma(Arma weapon)
    {
        this.weapon = weapon;
    }
    
    public Arma getArma()
    {
        return this.weapon;
    }
    
    public void jogar(JogarJogo jj)
    {
        this.jj = jj;
    }
    
    public void run()
    {
        if(jj == null)
            System.out.println("Nenhum jogo disponível: " + this.toString() );
            
        System.out.println("Personagem " + this.toString() + " entrando no labirinto.");
        jj.execute(this);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
