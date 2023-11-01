package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.RuanganModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_ruangan")
public class RuanganEntity {
    @Id
    @Column(name = "id", length =  36)
    private String id;

    @Column(name = "code", length = 20, unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "gedung_id")
    private String gedungId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gedung_id", insertable = false, updatable = false)
    private GedungEntity gedung;

    public RuanganEntity(RuanganModel model) {
        this.id = UUID.randomUUID().toString();
        this.code = model.getCode();
        this.name = model.getName();
        this.gedungId = model.getGedungId();
    }
}
