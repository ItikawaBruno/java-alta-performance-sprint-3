package domain;

public class Colaborador {
    private int id;
    private String nome;
    private String gestor;
    private String setor;
    private int nota;


    public Colaborador(int id, String nome, String gestor, String setor, int nota) {
        this.id = id;
        this.nome = nome;
        this.gestor = gestor;
        this.setor = setor;
        this.nota = nota;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getGestor() {
        return gestor;
    }

    public String getSetor() {
        return setor;
    }

    public double getNota() {
        return nota;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", gestor='" + gestor + '\'' +
                ", setor='" + setor + '\'' +
                ", nota=" + nota +
                '}';
    }
}
