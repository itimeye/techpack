package com.practice.techpack.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "PANTONE_COLORS"
)
public class PantoneColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pms;
    private int l;
    private int a;
    private int b;
    private int r;
    private int g;
    private int rgbB;
    private String hex;

    public PantoneColor( String pms, int l, int a, int b, int r, int g, int rgbB, String hex){
        this.pms = pms;
        this.l = l;
        this.a = a;
        this.b = b;
        this.r = r;
        this.g = g;
        this.rgbB = rgbB;
        this.hex = hex;
    }

    @Override
    public String toString() {
        return "PantoneColor{" +
                "pms='" + pms + '\'' +
                ", l=" + l +
                ", a=" + a +
                ", b=" + b +
                ", r=" + r +
                ", g=" + g +
                ", rgbB=" + rgbB +
                ", hex='" + hex + '\'' +
                '}';
    }
}
