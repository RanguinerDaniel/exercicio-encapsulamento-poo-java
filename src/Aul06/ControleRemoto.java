package Aul06;

public class ControleRemoto implements Controlador {
    private int volume;
    private boolean ligado;
    private boolean tocando;

    /**
     * Special methods
     */
    // Constructor
    public ControleRemoto() {
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private int getVolume() {
        return volume;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    private boolean getTocando() {
        return tocando;
    }

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if (getLigado()){
            System.out.println("Está ligado? " + this.getLigado());
            System.out.println("Está tocanddo?  " + this.getTocando());
            System.out.print("Volume: " + getVolume());
            for (int i = 0; i <= this.getVolume(); i += 10) {
                System.out.print(" |");
            }
        } else {
            System.out.println("Dispositivo não encontrado!");
        }
    }

    @Override
    public void fechaMenu() {
        System.out.println("Fechando menu...");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() + 5);
        } else {
            System.out.println("Impossível aumentar o volume!");
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() - 5);
        } else {
            System.out.println("Impossível diminuir o volume!");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0) {
            setVolume(0);
        } else {
            System.out.println("Ação impossibilitada!");
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() && this.getVolume() < 0) {
            setVolume(50);
        } else {
            System.out.println("Não há dispositivos ligados.");
        }
    }

    @Override
    public void play() {
        if (this.getLigado() && !(this.getTocando())) {
            this.setTocando(true);
        } else {
            System.out.println("Não foi possível completar a ação!");
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && (this.getTocando())) {
            this.setTocando(false);
        } else {
            System.out.println("Nada para pausar!");
        }
    }
}
