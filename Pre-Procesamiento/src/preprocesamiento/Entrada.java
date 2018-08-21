/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocesamiento;

/**
 *
 * @author isabe
 */
public class Entrada {
    String tag;
    String preguntas;
    int respuestas;
    int votos;
    int vistas;

    public Entrada(String tag, String preguntas, int respuestas, int votos, int vistas) {
        this.tag = tag;
        this.preguntas = preguntas;
        this.respuestas = respuestas;
        this.votos = votos;
        this.vistas = vistas;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public int getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(int respuestas) {
        this.respuestas = respuestas;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }
    
}
