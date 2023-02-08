package com.bancopichincha.retojava.infrastructure.adapters.output.persistence.repository;

import com.bancopichincha.retojava.infrastructure.adapters.output.persistence.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository<CuentaEntity, Long> {
}
