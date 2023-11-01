package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.MahasiswaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_mahasiswa")
public class MahasiswaEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "nim", length = 16)
    private String nim;

    @Column(name = "tempat_lahir", length = 48)
    private String tmptLahir;

    @Column(name = "tanggali_Lahir")
    private LocalDate tglLahir;

    @Column(name = "jk")
    private String jk;

    @Column(name = "agama")
    private String agama;

    @Column(name = "jurusan_id")
    private String jurusanId;

    @Column(name = "fakultas_id")
    private String fakultasId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jurusan_id", insertable = false, updatable = false)
    private JurusanEntity jurusan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fakultas_id", insertable = false, updatable = false)
    private FakultasEntity fakultas;


    public MahasiswaEntity(MahasiswaModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }

    public MahasiswaEntity(String id) {
        this.id = id;
    }
}
