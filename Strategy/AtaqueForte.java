package Strategy;

public class AtaqueForte extends Ataque
{
    private static AtaqueForte instancia = null;
    
    private AtaqueForte(){}
    
    public static synchronized AtaqueForte getInstancia()
    {
        if(instancia == null)
            instancia = new AtaqueForte();
        
        return instancia;
    }
    
    public double ataque()
    {
        System.out.print("Ataque Forte\n");
        return 1.5;
    }
}
