package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.JurusanModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_jurusan")
public class JurusanEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "jurusan_code", length = 10, unique = true)
    private String code;

    @Column(name = "jurusan_name", length = 128)
    private String name;

    @Column(name = "fakultas_id")
    private String fakultasId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fakultas_id", insertable = false, updatable = false)
    private FakultasEntity fakultas;

    public JurusanEntity(JurusanModel model) {
        this.id = UUID.randomUUID().toString();
        this.code = model.getCode();
        this.name = model.getName();
        this.fakultasId = model.getFakultasId();
    }
}
