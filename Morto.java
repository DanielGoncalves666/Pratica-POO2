public class Morto extends LifeState
{
    public Morto(Personagem p)
    {
        super(p);   
    }
    
    public void setLimites()
    {
        this.setLimiteInferior(0.0);
        this.setLimiteSuperior(0.0);
    }
    
    public void verificarAlteracaoEstado()
    {
        System.out.print("Morto - Fim de jogo.\n");
    }
}