package Strategy;

public class AtaqueMedio extends Ataque
{
    private static AtaqueMedio instancia = null;
    
    private AtaqueMedio(){}
    
    public static synchronized AtaqueMedio getInstancia()
    {
        if(instancia == null)
            instancia = new AtaqueMedio();
        
        return instancia;
    }
    
    public double ataque()
    {
        System.out.print("Ataque Medio\n");
        return 1;
    }
}
