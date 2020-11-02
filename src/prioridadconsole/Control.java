package prioridadconsole;

/**
 * @org Instituto Tecnológico de Toluca
 * @author Humberto Avila Ortiz
 */
public class Control extends Thread{
    
    /*
     * La clase control es el hilo principal de la aplicación,
     * pues determina qué proceso será ejecutado
     * obteniendo el de mayor prioridad de la lista
     */
    
    private Pendiente lista;
    
    public Control(Pendiente p){
        lista = p;
    }
    
    @Override
    public void run(){
        System.out.println("Iniciando Proceso de Pendientes");
        Hilo index = lista.getNext();
        while (true){
            if (index != null && !index.isAlive()){
                index.start();
                try{
                    Thread.sleep(index.getDuracion()*1000);
                } catch (InterruptedException e){
                    
                }
                index = lista.getNext();
            } else break;
        }
    }
    
}
