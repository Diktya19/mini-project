package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.GedungModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "tbl_gedung")
public class GedungEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "gedung_code", length = 20, unique = true)
    private String code;

    @Column(name = "gedung_name",length = 200)
    private String name;

    @Column(name = "jumlah_lantai")
    private Integer jumlahLantai;

    public GedungEntity(GedungModel model) {
      this.id = UUID.randomUUID().toString();
      this.code = model.getCode();
      this.name = model.getName();
      this.jumlahLantai = model.getJumlahLantai();
    }
}
