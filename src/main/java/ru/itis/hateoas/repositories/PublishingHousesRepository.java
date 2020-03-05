package ru.itis.hateoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoas.models.PublishingHouse;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Long> {
}
