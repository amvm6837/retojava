package com.bancopichincha.retojava.infrastructure.adapters.output.persistence.repository;

import com.bancopichincha.retojava.infrastructure.adapters.output.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
