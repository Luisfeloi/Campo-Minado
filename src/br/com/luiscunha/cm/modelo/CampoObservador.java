package br.com.luiscunha.cm.modelo;
@FunctionalInterface
public interface CampoObservador {

     void eventoOcorreu(Campo campo, CampoEvento evento);
}
