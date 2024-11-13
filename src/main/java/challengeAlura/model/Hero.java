package challengeAlura.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="herois")
public class Hero {


    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String poderes;
    @Column(nullable = false)
    private String identidadeSecreta;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String universo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPoderes() {
        return poderes;
    }

    public void setPoderes(String poderes) {
        this.poderes = poderes;
    }

    public String getIdentidadeSecreta() {
        return identidadeSecreta;
    }

    public void setIdentidadeSecreta(String identidadeSecreta) {
        this.identidadeSecreta = identidadeSecreta;
    }

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    private String urlAvatar;
}
