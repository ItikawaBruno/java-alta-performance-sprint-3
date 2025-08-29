package listas;

import domain.Colaborador;

public class ListaCrescenteColaborador {

    private class NO {
        Colaborador dado;
        NO prox;
    }

    NO lista = null;

    public boolean isEmpty() {
        return (lista == null);
    }

    public void add(Colaborador elem) {
        NO novo = new NO();
        novo.dado = elem;
        if (isEmpty()) {
            lista = novo;
            novo.prox = null;
        } else if (novo.dado.getNota() < lista.dado.getNota()) {
            novo.prox = lista;
            lista = novo;
        } else if (novo.dado.getNota() == lista.dado.getNota()) {
            if (novo.dado.getId() < lista.dado.getId()){
                novo.prox = lista;
                lista = novo;
            }else{
                NO aux = lista;
                boolean achou = false;
                while (aux.prox != null && !achou){
                    if (aux.prox.dado.getId() < novo.dado.getId())
                        aux = aux.prox;
                    else
                        achou = true;
                }
                novo.prox = aux.prox;
                aux.prox = novo;
            }
        } else {
            NO aux = lista;
            boolean achou = false;
            while (aux.prox != null && !achou) {
                if (aux.prox.dado.getNota() < novo.dado.getNota())
                    aux = aux.prox;
                else
                    achou = true;
            }
            novo.prox = aux.prox;
            aux.prox = novo;
        }
    }

    public void atualiza(int id, int nota) {
        NO atual = lista;
        Colaborador colaborador = null;

        while (atual != null) {
            if (id == atual.dado.getId()) {
                colaborador = atual.dado;
                colaborador.setNota(nota);
                remove(colaborador);
                add(colaborador);
                return;
            }
            atual = atual.prox;
        }
    }

    public void show() {
        NO aux = lista;
        System.out.println("*********** Lista ************");
        int cont = 0;
        while(aux.prox != null && cont < 3){
            System.out.print(aux.dado + "\t");
            System.out.println("\n");
            aux = aux.prox;
            cont++;
        }
        System.out.println();
    }
    public boolean remove(Colaborador valor) {
        boolean achou = false;
        if (!isEmpty()) {
            if (valor==lista.dado) {
                achou = true;
                lista = lista.prox;
            }
            else
            {
                NO aux = lista;
                while (aux.prox!=null && !achou) {
                    if (valor == aux.prox.dado)
                        achou = true;
                    else
                        aux = aux.prox;
                }
                if (achou)
                    aux.prox = aux.prox.prox;
            }
        }
        return achou;
    }



}
