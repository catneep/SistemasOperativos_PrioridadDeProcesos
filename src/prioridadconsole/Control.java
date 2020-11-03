package prioridadconsole;

import javax.swing.JLabel;

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
    private javax.swing.JLabel label;
    
    public Control(Pendiente p){
        lista = p;
    }
    
    public Control(Pendiente p, javax.swing.JLabel label){
        lista = p;
        this.label = label;
    }
    
    @Override
    public void run(){
        System.out.println("Iniciando Proceso de Pendientes");
        Hilo index = lista.getNext();
        while (true){
            if (index != null && !index.isAlive()){
                label.setText("Proceso Actual: " + index.getNombre());
                index.start();
                try{
                    Thread.sleep(index.getDuracion()*1000);
                } catch (InterruptedException e){
                    
                }
                index = lista.getNext();
            } else break;
        }
    }

    public Pendiente getLista() {
        return lista;
    }

    public void setLista(Pendiente lista) {
        this.lista = lista;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
}
