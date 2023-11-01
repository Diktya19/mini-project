package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.DosenModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_dosen")
public class DosenEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nip")
    private String nip;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "jk")
    private String jk;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "gelar")
    private String gelar;


    public DosenEntity(DosenModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }
}
