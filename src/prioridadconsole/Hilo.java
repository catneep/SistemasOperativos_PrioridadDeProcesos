package prioridadconsole;

import javax.swing.JProgressBar;

/**
 * @org Instituto Tecnológico de Toluca
 * @author Humberto Avila Ortiz
 */
public class Hilo extends Thread {
    private String nombre;
    private int duracion;
    private Hilo next;
    private boolean done;
    private javax.swing.JProgressBar barra;

    public Hilo(String name, int duracion) {
        this.nombre = name;
        this.duracion = duracion;
        done = false;
    }
    
    public Hilo(String name, int duracion, javax.swing.JProgressBar barra) {
        this.nombre = name;
        this.duracion = duracion;
        this.barra = barra;
        done = false;
    }

    public Hilo getNext() {
        return next;
    }

    public void setNext(Hilo next) {
        this.next = next;
    }
    
    @Override
    public void run(){
        System.out.println("Iniciando " + nombre + " (Duración: " + duracion + ")");
        while (!done){
            //TODO: agregar asignaciones para cambiar el estado de un JProgressBar
            barra.setValue(0);
            barra.setMaximum(duracion);
            for (int i = 0; i < duracion; i++){
                System.out.println(nombre + ": " + i);
                barra.setValue(i);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
            barra.setValue(barra.getMaximum());
            done = true;
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    
    public String getNombre(){
        return nombre;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }
    
    
    
}
