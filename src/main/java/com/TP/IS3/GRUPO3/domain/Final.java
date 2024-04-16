package com.TP.IS3.GRUPO3.domain;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id", name = "idFinal")
@Table(name="final")
@Getter @Setter @NoArgsConstructor
public class Final extends NotaPedido{
	
	@Column(name="fechaExamen", nullable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaExamen;

}