package br.com.notrash.notrash.entity;

import br.com.notrash.notrash.entity.pk.UsuaCondMoradPK;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Data
@Entity
@Table(name = "TB_USUA_CONDO_MORAD")
@IdClass(UsuaCondMoradPK.class)
public class UsuarioCondMorador implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", nullable = false, unique = true)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "CONDOMINIO_ID", referencedColumnName = "ID", nullable = false, unique = true)
    private Condominio condominio;

    @Id
    @ManyToOne
    @JoinColumn(name = "MORADOR_ID", referencedColumnName = "ID", unique = true)
    private Morador morador;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATAHORA")
    private Calendar datahora;

}
