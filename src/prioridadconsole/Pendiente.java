package prioridadconsole;

/**
 * @org Instituto Tecnológico de Toluca
 * @author Humberto Avila Ortiz
 */
public class Pendiente {
    /*
     * La clase pending contiene referencias de memoria
     * de los hilos que aún no se ejecutan, se puede pensar como
     * una lsita de espera
     */
    private Hilo inicial;
    
    public Pendiente(){
        inicial = null;
    }
    
    public Pendiente(Hilo inicial){
        this.inicial = inicial;
    }
    
    public Hilo getNext(){
        try{
            Hilo temp = inicial;
            inicial = inicial.getNext();
            System.out.println(temp.getNombre() + " ya no está en lista");
            return temp;
        }catch (NullPointerException e){
            System.out.println("ya no hay elementos en la lista");
            return null;
        }
    }
    
    public void add(Hilo h){
        System.out.println("Añadiendo " + h.getNombre() + " a pendientes.");
        if (inicial != null){
            //buscar su lugar
            Hilo index = inicial;
            while (index != null){
                if (h.getDuracion() <= index.getDuracion())
                    //El nuevo hilo tiene una prioridad menor o igual al índice actual
                {
                    if (index == inicial) this.inicial = h;
                    h.setNext(index);
                    break;
                }
                else if (index.getNext() == null){   
                    //El nuevo hilo tiene una prioridad mayor a todos en la lista
                    index.setNext(h);
                    break;
                }
                index = index.getNext();
            }
        } else {
            //No hay un hilo siguiente en la lista
            inicial = h;
        }
    }
    
}
