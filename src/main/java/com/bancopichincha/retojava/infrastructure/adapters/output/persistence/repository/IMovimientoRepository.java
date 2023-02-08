package com.bancopichincha.retojava.infrastructure.adapters.output.persistence.repository;

import com.bancopichincha.retojava.infrastructure.adapters.output.persistence.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimientoRepository extends JpaRepository<MovimientoEntity, Long> {

}
